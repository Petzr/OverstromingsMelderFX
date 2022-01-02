package com.example.overstromingfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.io.IOException;
import java.sql.SQLException;

public class startpaginaController {

    @FXML
    public Button startpaginaButton;

    @FXML
    private TextField locatie;

    @FXML
    private Text waarschuwingsniveauLocatie;

    @FXML
    void onAanvragenStatusPress(ActionEvent event) throws SQLException {
        String gemeente = locatie.getText();
        String waterniveau = Database.getGemeente(gemeente);

        waarschuwingsniveauLocatie.setText(waterniveau);
    }

    @FXML
    void onAdminLoginPress(ActionEvent event) throws IOException {
        System.out.println("ga naar Admin Login pagina");
        SceneSwitch.setSceneTo("login-admin", startpaginaButton);
    }

    @FXML
    void onContactPress(ActionEvent event) throws IOException {
        System.out.println("ga naar Contact pagina");
        SceneSwitch.setSceneTo("contactpagina", startpaginaButton);
    }

    @FXML
    void onFAQPress(ActionEvent event) throws IOException {
        System.out.println("ga naar FAQ pagina");
        SceneSwitch.setSceneTo("faqpagina", startpaginaButton);
    }

    @FXML
    void onOverOnsPress(ActionEvent event) throws IOException {
        System.out.println("ga naar Over Ons pagina");
        SceneSwitch.setSceneTo("overOnspagina", startpaginaButton);

    }

    @FXML
    void onStartpaginaPress(ActionEvent event) throws IOException {
        System.out.println("ga naar startpagina");
        SceneSwitch.setSceneTo("startpagina", startpaginaButton);
    }

}
