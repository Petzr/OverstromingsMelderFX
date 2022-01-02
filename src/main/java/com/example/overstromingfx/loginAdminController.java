package com.example.overstromingfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.io.IOException;
import java.sql.SQLException;

public class loginAdminController {

    @FXML
    public Button startpaginaButton;

    @FXML
    public Label inlogStatus;

    @FXML
    public CheckBox betrouwbareApparaat;

    @FXML
    private TextField email;

    @FXML
    private MenuButton meerInfo;

    @FXML
    private TextField wachtwoord;

    @FXML
    void onLoginPress(ActionEvent event) throws IOException, SQLException {
        String mail = email.getText();
        String ww = wachtwoord.getText();

        if (Database.getAdmin(mail, ww)){
            System.out.println("INGELOGD");
            SceneSwitch.setSceneTo("startpagina-admin", startpaginaButton);
        }
        else {
            inlogStatus.setText("gegevens zijn incorrect");
        }

    }

    @FXML
    void onStartpaginaPress(ActionEvent event) throws Exception {
        System.out.println("Naar startpagina");

        SceneSwitch.setSceneTo("startpagina", startpaginaButton);
    }

    @FXML
    void onWachtwoordVergetenPress(ActionEvent event) throws IOException {
        System.out.println("naar wachtwoord vergeten pagina");

        SceneSwitch.setSceneTo("wachtwoord-wijzigen", startpaginaButton);
    }

    @FXML
    public void onMeerInfoPress(ActionEvent event) {
        System.out.println(meerInfo.getItems());
    }
}
