
package application;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.ResourceBundle;

import javax.xml.bind.*;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class DirectoryController {

    private static EmployeeList appEmpList = null;
    private static File selectedFile = null;

    @FXML
    private Label lblCurrRecord;

    @FXML
    private Button btnLoad;

    @FXML
    private Button btnNavNext;

    @FXML
    private Button btnNavDel;

    @FXML
    private Button btnNavPrev;

    @FXML
    private TextField txtFldDepartment;

    @FXML
    private BorderPane borderPane;

    @FXML
    private Button btnSerialize;

    @FXML
    private TextField txtFldName;

    @FXML
    private Button btnNavAdd;

    @FXML
    private Label lblFilename;

    @FXML
    private TextField txtFldExtension;

    @FXML
    private Button btnExit;

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
            case "btnExit":
                handleBtnExit();
                break;
        }
    }

    private void handleBtnLoad() {
        Alert alert = new Alert(AlertType.ERROR);

        FileChooser fileChooser = new FileChooser();
        selectedFile = fileChooser.showOpenDialog(new Stage());

        if(selectedFile == null) {
            alert.setTitle("Error Loading File");
            alert.setHeaderText("No File Selected");
            alert.setContentText("Please select a valid file an try again.");
            System.out.println("Please select a valid file an try again.");
            alert.showAndWait();
            return;
        }
        System.out.println("selectedFile: " + selectedFile.getAbsolutePath());

        if(!unmarshalFromFile()) {
            alert.setTitle("Error Loading File");
            alert.setHeaderText("Could not parse file");
            alert.setContentText("Please select a valid file an try again.");
            System.out.println("Please select a valid file an try again.");
            alert.showAndWait();
            return;
        }

        //DEBUG
        System.out.println("selectedFile: " + selectedFile.getAbsolutePath());
//        System.out.println(appEmpList.getLst());

        //validate employees
        if(!validateEmployees()) {
            alert.setTitle("Error Loading File");
            alert.setHeaderText("Invalid Employees");
            alert.setContentText("Please select a file with valid employees and try again.");
            System.out.println("Please select a file with valid employees and try again.");
            alert.showAndWait();

            //reset list of employees
            appEmpList.setLst(null);
            return;
        }

        //valid file loaded

        //set file name text
        lblFilename.setText("File: " + selectedFile.getName());

        //enable add button
        btnNavAdd.setDisable(false);
    }

    private boolean validateEmployees() {
        return true;
    }
    private boolean unmarshalFromFile() {
        try(BufferedReader input = Files.newBufferedReader(Paths.get(selectedFile.getAbsolutePath()))) {
//            EmployeeList appEmpList = JAXB.unmarshal(input, EmployeeList.class);

        } catch (IOException ioException) {
            System.err.println("Error opening file");
            return false;
        }

        //success
        return true;
    }


    private void handleBtnNavAdd() {
        Alert alert = new Alert(AlertType.ERROR);

        String empName = txtFldName.getText();
        String empDepartment = txtFldDepartment.getText();
        String empExtension = txtFldExtension.getText();
        Employee addedEmp = new Employee(empName, empDepartment, empExtension);

        //validate employee
        if(!addedEmp.isValid()) {
            //display error dialog
            alert.setTitle("Invalid value");
            if(!addedEmp.isNameValid()) {
                alert.setHeaderText("Invalid Name \nNames can be 1 or 2 words.\n" +
                        "1. Each word must start with an uppercase letter followed by at least 2 characters.\n" +
                                "2. Numbers are not allowed.");
                alert.showAndWait();
            }
            if(!addedEmp.isDepartmentValid()) {
                alert.setHeaderText("Invalid Department. Department name\n" +
                        "Departments can be 1 or 2 words.\n" +
                        "2. Each word must start with an uppercase letter or can just be a single uppercase letter.\n" +
                        "3. Numbers are allowed.");
                alert.showAndWait();
            }
            if(!addedEmp.isExtensionValid()) {
                alert.setHeaderText("Invalid Extension.\n"+
                        "Extensions can only start with 1,2, or 3 numbers followed by a - followed 1 or 2 numbers." );
                alert.showAndWait();
            }

            //reset list of employees
            appEmpList.setLst(null);
            return;
        }
    }

    private void handleBtnExit() {

        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setTitle("Exit");
        alert.setHeaderText("Are you sure you want to exit?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK){
            System.out.println("Exit");
            Platform.exit();
            System.exit(0);
        } else {
            System.out.println("CANCEL");
        }


    }






}