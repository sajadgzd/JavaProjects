package application;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException
    {
        // Create the FXMLLoader
        FXMLLoader loader = new FXMLLoader();

        //scene root object
        BorderPane pane = null;

        // Path to the FXML File
        String fxmlDocPath = "src/application/Directory.fxml";
        try {
            FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
            // Create the Pane and all Details
            pane = (BorderPane) loader.load(fxmlStream);
        } catch(Exception ex) {
            ex.printStackTrace();
            System.exit(1);
        }

        // Create the Scene
        Scene scene = new Scene(pane);
        // Set the Scene to the Stage
        stage.setScene(scene);
        // Set the Title to the Stage
        stage.setTitle("Assignment 5 - Sajad");
        // Display the Stage
        stage.show();
    }
}