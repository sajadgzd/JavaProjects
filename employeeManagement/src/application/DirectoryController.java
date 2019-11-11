package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class DirectoryController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtFldCompany;

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
    void buttonClicked(ActionEvent event) {

    }

//    @FXML
//    void buttonClicked(ActionEvent event) {
//
//    }
//
//    @FXML
//    void buttonClicked(ActionEvent event) {
//
//    }
//
//    @FXML
//    void buttonClicked(ActionEvent event) {
//
//    }
//
//    @FXML
//    void buttonClicked(ActionEvent event) {
//
//    }
//
//    @FXML
//    void buttonClicked(ActionEvent event) {
//
//    }
//
//    @FXML
//    void buttonClicked(ActionEvent event) {
//
//    }

    @FXML
    void initialize() {
        assert txtFldCompany != null : "fx:id=\"txtFldCompany\" was not injected: check your FXML file 'Directory.fxml'.";
        assert lblCurrRecord != null : "fx:id=\"lblCurrRecord\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnLoad != null : "fx:id=\"btnLoad\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnNavNext != null : "fx:id=\"btnNavNext\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnNavDel != null : "fx:id=\"btnNavDel\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnNavPrev != null : "fx:id=\"btnNavPrev\" was not injected: check your FXML file 'Directory.fxml'.";
        assert borderPane != null : "fx:id=\"borderPane\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnSerialize != null : "fx:id=\"btnSerialize\" was not injected: check your FXML file 'Directory.fxml'.";
        assert txtFldName != null : "fx:id=\"txtFldName\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnNavAdd != null : "fx:id=\"btnNavAdd\" was not injected: check your FXML file 'Directory.fxml'.";
        assert lblFilename != null : "fx:id=\"lblFilename\" was not injected: check your FXML file 'Directory.fxml'.";
        assert txtFldExtension != null : "fx:id=\"txtFldExtension\" was not injected: check your FXML file 'Directory.fxml'.";
        assert btnExit != null : "fx:id=\"btnExit\" was not injected: check your FXML file 'Directory.fxml'.";

    }
}
