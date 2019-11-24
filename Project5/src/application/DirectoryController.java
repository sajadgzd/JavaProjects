package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.xml.bind.DataBindingException;
import javax.xml.bind.JAXB;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Region;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DirectoryController {
    private static File selectedFile = null;

    private static int appEmpListIdx = 0;
    private static EmployeeList appEmpList = null;

    @FXML
    private TextField txtFldName;
    @FXML
    private TextField txtFldDepartment;
    @FXML
    private TextField txtFldExtension;
    @FXML
    private Label lblFilename;
    @FXML
    private Label lblCurrRecord;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnNavAdd;
    @FXML
    private Button btnNavDel;
    @FXML
    private Button btnNavNext;
    @FXML
    private Button btnNavPrev;
    @FXML
    private Button btnSerialize;
    @FXML
    private Button btnExit;

    public DirectoryController() {}

    @FXML
    private void initialize() {
        //executed after fxml is loaded
        txtFldName.setDisable(true);
        txtFldDepartment.setDisable(true);
        txtFldExtension.setDisable(true);
        btnNavAdd.setDisable(true);
        btnNavDel.setDisable(true);
        btnNavNext.setDisable(true);
        btnNavPrev.setDisable(true);
        btnSerialize.setDisable(true);
    }

    @FXML
    private void buttonClicked(ActionEvent event) {
        Button sourceBtn = (Button) event.getSource();

        switch(sourceBtn.getId()) {
            case "btnLoad":
                handleBtnLoad();
                break;
            case "btnNavAdd":
                handleBtnNavAdd();
                break;
            case "btnNavDel":
                handleBtnNavDel();
                break;
            case "btnNavNext":
                handleBtnNavNext();
                break;
            case "btnNavPrev":
                handleBtnNavPrev();
                break;
            case "btnSerialize":
                handleBtnSerialize();
                break;
            case "btnExit":
                handleBtnNavExit();
                break;
        }
    }

    private void handleBtnSerialize() {
        Alert alert = new Alert(AlertType.ERROR);
//        alert.getDialogPane().setMinHeight(Region.USE_PREF_SIZE);
        alert.setTitle("Serialize");

        // save and update current employee
        if(!saveUpdateEmployee()) return;

        //get output file
        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(new Stage());
        if(selectedFile == null) { return; }

        if(marshalToFile()) {
            alert.setAlertType(AlertType.INFORMATION);
            System.out.printf("Employees serialized to file %s successfully!", selectedFile.getName());
            alert.setHeaderText(String.format("Employees serialized to file %s successfully!", selectedFile.getName()));
            alert.showAndWait();
        } else {
            System.out.printf("Error occurred serializing Employees to file @ %s.", selectedFile.getAbsolutePath());
            alert.setHeaderText(String.format("Error occurred serializing Employees to file @ %s.", selectedFile.getAbsolutePath()));
            alert.showAndWait();
            return;
        }

        //update lblFilename
        lblFilename.setText("File: " + selectedFile.getName());
    }

    private void handleBtnNavExit() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit?");
        Optional<ButtonType> selection = alert.showAndWait();
        if(!selection.get().getText().equals("OK")) {
            return;
        }

        // exit successfully
        System.exit(0);
    }

    private void handleBtnNavPrev() {
        // ensure there's a previous record
        if(appEmpListIdx <= 0) {
            //no prev record
            btnNavPrev.setDisable(true);
            return;
        }
        // save and update the current record
        if(!saveUpdateEmployee()) return;

        // go to prev record
        appEmpListIdx--;
        updateUI(appEmpList, appEmpListIdx);

        //update current record label
        lblCurrRecord.setText(String.format("%d of %d", appEmpListIdx + 1, appEmpList.getLst().size()));

        //disable prev button if no prev record, else enable
        btnNavPrev.setDisable(appEmpListIdx == 0);

        //enable next button
        btnNavNext.setDisable(false);
    }

    private void handleBtnNavNext() {

        // save and update the current record
        if(!saveUpdateEmployee()) return;

        //go to next record
        appEmpListIdx++;
        updateUI(appEmpList, appEmpListIdx);

        //update current record label
        lblCurrRecord.setText(String.format("%d of %d", appEmpListIdx + 1, appEmpList.getLst().size()));

        //disable next button if no next record, else enable
        btnNavNext.setDisable(appEmpListIdx == appEmpList.getLst().size() - 1);

        //enable prev button
        btnNavPrev.setDisable(false);

    }

    private Employee handleBtnNavDel() {
        //remove current displayed record
        Employee removed = appEmpList.getLst().remove(appEmpListIdx);

        //if list size is now <= 1, disable next/prev
        if(appEmpList.getLst().size() <= 1) {
            //disable next button
            btnNavNext.setDisable(true);

            //disable prev button
            btnNavPrev.setDisable(true);
        }

        if(appEmpList.getLst().size() == 0) {
            //disable del button
            btnNavDel.setDisable(true);

            appEmpListIdx = 0;

            txtFldName.setText("");
            txtFldDepartment.setText("");
            txtFldExtension.setText("");

            txtFldName.setDisable(true);
            txtFldDepartment.setDisable(true);
            txtFldExtension.setDisable(true);

            lblCurrRecord.setText("0 of 0");

            return removed;
        }

        //if last element, update index to prev
        if(appEmpListIdx > appEmpList.getLst().size() - 1) {
            appEmpListIdx--;
        }

        //update UI inputs to prev record
        updateUI(appEmpList, appEmpListIdx);

        //update current record label
        lblCurrRecord.setText(String.format("%d of %d", appEmpListIdx + 1, appEmpList.getLst().size()));

        //disable next button if no next record, else enable
        btnNavNext.setDisable(appEmpListIdx == appEmpList.getLst().size() - 1);

        //enable prev button
        // btnNavPrev.setDisable(false);

        return removed;
    }

    private void handleBtnNavAdd() {
        //validate & save current employee unless list is empty
        if(appEmpList.getLst().size() > 0) {

            // save and update current employee
            if(!saveUpdateEmployee()) return;

            // enable prev button
            btnNavPrev.setDisable(false);
        }

        // clear inputs for new entry
        txtFldName.setText("");
        txtFldDepartment.setText("");
        txtFldExtension.setText("");

        // enable inputs
        txtFldName.setDisable(false);
        txtFldDepartment.setDisable(false);
        txtFldExtension.setDisable(false);

        // add new entry
        appEmpList.createNew();

        // enable del button
        btnNavDel.setDisable(false);

        // disable next button
        btnNavNext.setDisable(true);

        // update current record label
        appEmpListIdx = appEmpList.getLst().size() - 1;
        lblCurrRecord.setText(String.format("%d of %d", appEmpListIdx + 1, appEmpList.getLst().size()));
    }

    private void handleBtnLoad() {
        Alert alert = new Alert(AlertType.ERROR);

        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(new Stage());

        if(selectedFile == null) {
            alert.setTitle("Error Loading File");
            alert.setHeaderText("No File Selected");
            alert.setContentText("Please select a valid file and try again.");
            System.out.println("Please select a valid file and try again.");
            alert.showAndWait();
            return;
        }

        // marshal the file, and if it returns false
        if(!unmarshalFromFile()) {
            alert.setTitle("Error when reading the File");
            alert.setHeaderText("Could not parse file");
            alert.setContentText("Please select a valid file and try again.");
            System.out.println("Please select a valid file and try again.");
            alert.showAndWait();
            return;
        }

        // DEBUG helper
        System.out.println("selectedFile: " + selectedFile.getAbsolutePath());
        System.out.println(appEmpList.getLst());

        // validate employees
        if(!validateEmployees() && appEmpList.getLst().get(0).getId() != 0 ) {
            alert.setTitle("Error Validating File");
            alert.setHeaderText("Invalid Employees");
            alert.setContentText("Please select a file with 'valid employees' and try again.");
            System.out.println("Please select a file with 'valid employees' and try again.");
            alert.showAndWait();

            // reset list of employees
            appEmpList.setLst(new ArrayList<>());
            return;
        }

        //valid file loaded

        //set file name text
        lblFilename.setText("File: " + selectedFile.getName());

        //enable add button
        btnNavAdd.setDisable(false);

        //enable serialize button
        btnSerialize.setDisable(false);

        //load 1st employee data to input fields
        txtFldName.setText(appEmpList.getLst().get(0).getName());
        txtFldDepartment.setText(appEmpList.getLst().get(0).getDepartment());
        txtFldExtension.setText(appEmpList.getLst().get(0).getExtension());

        //update appEmpListIdx
        appEmpListIdx = 0;

        // update current record label
        // for the first time, when the file being read is an empty file, show 0 of 0, else; the number of records
        if(appEmpList.getLst().get(0).getId() == 0){
            lblCurrRecord.setText("0 of 0");
        } else {
            lblCurrRecord.setText(String.format("%d of %d", appEmpListIdx+1, appEmpList.getLst().size()));
        }


        //disable del button if size < 1, else enable
        btnNavDel.setDisable(appEmpList.getLst().size() < 1);

        //disable next button if size == 1, else enable
        btnNavNext.setDisable(appEmpList.getLst().size() == 1);

        //enable inputs
        txtFldName.setDisable(false);
        txtFldDepartment.setDisable(false);
        txtFldExtension.setDisable(false);
    }

    private boolean validateEmployees() {
        for(Employee emp : appEmpList.getLst()){
            if(!emp.isValid()) return false;
        }
        return true;
    }

    private boolean marshalToFile() {
        try(BufferedWriter output = Files.newBufferedWriter(Paths.get(selectedFile.toURI()))){
            JAXB.marshal(appEmpList, output);
            //success
            return true;
        } catch(IOException ex) {
            System.err.println("Error writing to file!");
            return false;
        }
    }

    private boolean unmarshalFromFile() {

        // For the case of an empty file for the first time being read. id = 0.
        if(selectedFile.length() == 0){
            Employee emptyEmployee = new Employee(0,"","","");
            List<Employee> emptyList = new ArrayList<>();
            emptyList.add(emptyEmployee);
            appEmpList = new EmployeeList();
            appEmpList.setLst(emptyList);
            return true;
        }

        // not empty files:
        try(BufferedReader input = Files.newBufferedReader(Paths.get(selectedFile.toURI()))){
            appEmpList = JAXB.unmarshal(input, EmployeeList.class);
            return true;
        }
        catch (IOException ioException){
            System.err.println("Error loading file!!!");
            return false;
        }

    }

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;

    @FXML
    private ResourceBundle resources;

    private void showAlerts(Employee updatedEmp){
        Alert alert = new Alert(AlertType.ERROR);
        // display error dialog
        alert.setTitle("Invalid Value");
        if(!updatedEmp.isNameValid()) {
            alert.setHeaderText("Invalid Name \nNames can be 1 or 2 words.\n" +
                    "1. Each word must start with an uppercase letter followed by at least 2 characters.\n" +
                    "2. Numbers are not allowed.");
            alert.showAndWait();
        }
        if(!updatedEmp.isDepartmentValid()) {
            alert.setHeaderText("Invalid Department. Department name\n" +
                    "Departments can be 1 or 2 words.\n" +
                    "2. Each word must start with an uppercase letter or can just be a single uppercase letter.\n" +
                    "3. Numbers are allowed.");
            alert.showAndWait();
        }
        if(!updatedEmp.isExtensionValid()) {
            alert.setHeaderText("Invalid Extension.\n"+
                    "Extensions can only start with 1,2, or 3 numbers followed by a - followed 1 or 2 numbers." );
            alert.showAndWait();
        }
    }

    private void updateUI(EmployeeList appEmpList, int appEmpListIdx){
        txtFldName.setText(appEmpList.getLst().get(appEmpListIdx).getName());
        txtFldDepartment.setText(appEmpList.getLst().get(appEmpListIdx).getDepartment());
        txtFldExtension.setText(appEmpList.getLst().get(appEmpListIdx).getExtension());
    }

    private boolean saveUpdateEmployee(){
        String empName = txtFldName.getText();
        String empDepartment = txtFldDepartment.getText();
        String empExtension = txtFldExtension.getText();

        //create new copy of current employee with updated values to validate
        Employee updatedEmp = new Employee(appEmpList.getLst().get(appEmpListIdx).getId(), empName, empDepartment, empExtension);


        if(!updatedEmp.isValid()) {
            // display error dialog
            showAlerts(updatedEmp);
            return false;
        }

        // update/save current employee
        appEmpList.getLst().get(appEmpListIdx).setName(updatedEmp.getName());
        appEmpList.getLst().get(appEmpListIdx).setDepartment(updatedEmp.getDepartment());
        appEmpList.getLst().get(appEmpListIdx).setExtension(updatedEmp.getExtension());

        return true;
    }
}
