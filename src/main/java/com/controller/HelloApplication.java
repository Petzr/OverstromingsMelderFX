package com.controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("startpagina.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Overstroming Melder Limburg");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("trying connection with MicroBit");
        ComPortSendReceive.startConnectionMicroBit();
        System.out.println("STARING PROGRAM...");
        Database.showGemeentes();
        launch();
    }
}