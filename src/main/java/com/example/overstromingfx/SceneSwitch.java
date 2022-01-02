package com.example.overstromingfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class SceneSwitch {
    @FXML
    public Button startpaginaButton;

    @FXML
    public void onAdminLoginPress(ActionEvent event) throws IOException {
        setSceneTo("login-admin", startpaginaButton);
    }

    public void onFAQPress(ActionEvent event) throws IOException {
        setSceneTo("faqpagina", startpaginaButton);
    }

    public void onOverOnsPress(ActionEvent event) throws IOException {
        setSceneTo("overOnspagina", startpaginaButton);
    }

    public void onContactPress(ActionEvent event) throws IOException {
        setSceneTo("contactpagina", startpaginaButton);
    }

    public void onStartpaginaPress(ActionEvent event) throws IOException {
        setSceneTo("startpagina", startpaginaButton);
    }

    public static void setSceneTo(String sceneNaam, Button button) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(sceneNaam+".fxml"));
        Stage window = (Stage) button.getScene().getWindow();
        window.setScene(new Scene(fxmlLoader.load()));
        window.setTitle(sceneNaam);

    }
}
