package application;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
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
    private TextField txtFldName;
    @FXML
    private TextField txtFldDepartment;
    @FXML
    private TextField txtFldExtension;
    @FXML
    private Label lblFilename;
    @FXML
    private Button btnLoad;
    @FXML
    private Button btnNavAdd;
    
    public DirectoryController() {}

    @FXML
    private void initialize() {
        //executed after fxml is loaded
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
        }
    }
    
    private void handleBtnNavAdd() {
        Alert alert = new Alert(AlertType.ERROR);
        
        String empName = txtFldName.getText();
        String empDepartment = txtFldDepartment.getText();
        String empExtension = txtFldExtension.getText();
        Employee addedEmp = new Employee(empName, empDepartment, empExtension);

        //validate employee

        if(true) { // testing only
        // -- uncomment below line after testing and comment above line --
        // if(!addedEmp.isValid()) {
            //display error dialog
            alert.setTitle("Invalid Employee Value");
            if(!addedEmp.isNameValid()) {
                alert.setHeaderText("Invalid Name");
                alert.setContentText("1) Names can be 1 or 2 words.\n" + 
                        "2) Each word must start with an uppercase character followed by at least 2 characters.\n" + 
                        "3) Numbers are not allowed.");
                alert.showAndWait();
            }
            if(!addedEmp.isDepartmentValid()) {
                alert.setHeaderText("Invalid Department");
                alert.setContentText("1) Departments can be 1 or 2 words.\n" + 
                        "2) Each word must start with an uppercase character or can just be a single uppercase letter.\n" + 
                        "3) Numbers are allowed.");
                alert.showAndWait();
            }
            if(!addedEmp.isExtensionValid()) {
                alert.setHeaderText("Invalid Extension");
                alert.setContentText("1) Extensions are 2 groups of numbers separated by a dash \"-\".\n" + 
                        "2) The first group of numbers can be 1, 2, or 3 numbers.  The second group can be 1 or 2 numbers.");
                alert.showAndWait();
            }

            //reset list of employees
            appEmpList.setLst(null);
            return;
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
        System.out.println(appEmpList.getLst());

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
        lblFilename.setText(selectedFile.getName());

        //enable add button
        btnNavAdd.setDisable(false);
    }

    private boolean validateEmployees() {
        return !appEmpList.getLst().stream().filter(emp -> { return !emp.isValid(); }).findAny().isPresent();
    }

    private boolean marshalToFile() {
        try
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
         
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             
            //Marshal the employees list in console
            jaxbMarshaller.marshal(appEmpList, System.out);
             
            //Marshal the employees list in file
            jaxbMarshaller.marshal(appEmpList, selectedFile);
        } 
        catch (JAXBException e) 
        {
            e.printStackTrace();
            return false;
        }
        
        return true;
    }

    private boolean unmarshalFromFile() {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(EmployeeList.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

            appEmpList = (EmployeeList) jaxbUnmarshaller.unmarshal(selectedFile);

            //DEBUG
            // System.out.println(appEmpList.getLst());
        } catch (JAXBException e) {
            e.printStackTrace();
            return false;
        }

        //success
        return true;
    }

    // location and resources will be automatically injected by the FXML loader
    @FXML
    private URL location;
     
    @FXML
    private ResourceBundle resources;
}