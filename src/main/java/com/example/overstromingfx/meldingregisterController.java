package com.example.overstromingfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;

import java.io.IOException;

public class meldingregisterController {

    @FXML
    public Button startpaginaButton;

    @FXML
    private MenuButton meerInfo;

    @FXML
    void onStartpaginaPress(ActionEvent event) throws IOException {
        System.out.println("Naar startpagina");
        SceneSwitch.setSceneTo("startpagina-admin", startpaginaButton);
    }

}
