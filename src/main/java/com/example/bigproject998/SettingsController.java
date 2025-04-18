package com.example.bigproject998;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Objects;

public class SettingsController {

    @FXML
    private ComboBox<String> lightOrDark;

    private Stage stage;
    private Scene scene;

    @FXML
    public void initialize() {
        lightOrDark.getItems().addAll("Light", "Dark");
    }

    @FXML
    public void SaveChanges(ActionEvent actionEvent) {
        String selected = lightOrDark.getValue();
        if (selected != null) {
            String cssFile = selected.equals("Dark") ? "dark.css" : "light.css";
            ThemeManager.getInstance().setCurrentTheme(cssFile);
            System.out.println("Theme updated to: " + cssFile);
        }
    }

    @FXML
    public void BackButtonToMenu(ActionEvent actionEvent) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Starter.fxml")));
            scene = new Scene(root);
            scene.getStylesheets().clear();
            scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource(
                    ThemeManager.getInstance().getCurrentTheme()
            )).toExternalForm());
            stage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}