package com.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.TextField;

import java.io.IOException;

public class wachtwoordWijzigenController {

    @FXML
    public MenuButton meerInfo;

    @FXML
    public Label wijzigenStatus;

    @FXML
    public Button startpaginaButton;

    @FXML
    private TextField code;

    @FXML
    private TextField email;

    @FXML
    private TextField wachtwoord;

    @FXML
    private TextField wachtwoordOpniew;

    @FXML
    void onStartpaginaPress(ActionEvent event) throws IOException {
        System.out.println("Naar startpagina");
        SceneSwitch.setSceneTo("startpagina", startpaginaButton);
    }

    @FXML
    void onWachtwoordWijzigenPress(ActionEvent event) throws IOException {
        String mail = email.getText();
        String cd = code.getText();
        String ww = wachtwoord.getText();
        String wwcheck = wachtwoordOpniew.getText();

        if (ww.equals(wwcheck) && !(mail.equals("") || cd.equals("") || ww.equals(""))) {
            System.out.println("wachtwoord is gewijzigd");

            SceneSwitch.setSceneTo("login-admin", startpaginaButton);
        } else {
            System.out.println("er is niks ingevuld of wachtwoorden zijn niet vergelijkbaaar");
            wijzigenStatus.setText("FOUT, probeer het opnieuw");
        }

    }

}

