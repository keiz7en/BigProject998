package com.example.bigproject998;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class StarterController {

    private Stage stage;
    private Scene scene;

    @FXML
    private void NewDataButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("NewFile.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void SettingsButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Settings.fxml")));
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private void QuitButton(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void OpenButton(ActionEvent event) {
        try {
            // Replace this with the actual folder path you want to open
            File folderToOpen = new File(System.getProperty("user.home") + "/Documents");

            if (folderToOpen.exists()) {
                Desktop.getDesktop().open(folderToOpen);
            } else {
                System.out.println("Folder does not exist: " + folderToOpen.getAbsolutePath());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
