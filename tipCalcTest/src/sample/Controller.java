package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label lblAmount3;

    @FXML
    private Label lblAmount2;

    @FXML
    private Label lblAmount1;

    @FXML
    private TextField txtTip;

    @FXML
    private TextField txtAmount;

    @FXML
    private Label lblAmount;

    @FXML
    private Slider percent;

    @FXML
    private Button btn;

    @FXML
    private TextField txtTotal;

    @FXML
    void initialize() {
        assert lblAmount3 != null : "fx:id=\"lblAmount3\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblAmount2 != null : "fx:id=\"lblAmount2\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblAmount1 != null : "fx:id=\"lblAmount1\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtTip != null : "fx:id=\"txtTip\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtAmount != null : "fx:id=\"txtAmount\" was not injected: check your FXML file 'sample.fxml'.";
        assert lblAmount != null : "fx:id=\"lblAmount\" was not injected: check your FXML file 'sample.fxml'.";
        assert percent != null : "fx:id=\"percent\" was not injected: check your FXML file 'sample.fxml'.";
        assert btn != null : "fx:id=\"btn\" was not injected: check your FXML file 'sample.fxml'.";
        assert txtTotal != null : "fx:id=\"txtTotal\" was not injected: check your FXML file 'sample.fxml'.";

    }
}
