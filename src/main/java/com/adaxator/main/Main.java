package com.adaxator.main;

import com.adaxator.controllers.PrimaryStackController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader= new FXMLLoader();
        loader.setLocation(this.getClass().getResource("/fxmls/primaryStack.fxml"));

        StackPane primaryStackPane=loader.load();
        PrimaryStackController primaryStackController=loader.getController();
        primaryStackController.setMenu();

        Scene primaryScene=new Scene(primaryStackPane);
        primaryStage.setScene(primaryScene);
        primaryStage.setTitle("Adaxator indev 0.1");
        primaryStage.show();

    }
}
