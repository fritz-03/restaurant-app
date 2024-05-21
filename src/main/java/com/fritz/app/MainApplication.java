package com.fritz.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * {@code MainApplication} is the entry point for the JavaFX application.
 */
public class MainApplication extends Application {
    /**
     * Starts the JavaFX application.
     * @param stage The primary stage for this application.
     * @throws IOException If an error occurs while loading the FXML file.
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainApplication.class.getResource("main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle("Programming Assignment 2");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    /**
     * The main method, launching the JavaFX application.
     * @param args Command line arguments (ignored).
     */
    public static void main(String[] args) {
        launch();
    }
}