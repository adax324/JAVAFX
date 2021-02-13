package com.adaxator.controllers;

import com.adaxator.DbConnector.DbConnector;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class RegisterController {
    @FXML
    private TextField loginField;
    @FXML
    PasswordField passwordField;

    private PrimaryStackController primaryStackController;

    public void setPrimaryStackController(PrimaryStackController primaryStackController) {
        this.primaryStackController = primaryStackController;
    }

    @FXML
    void menuAction(){
        primaryStackController.setMenu();
    }
    @FXML
    void actionLogin(){
    }
    @FXML
    void actionPassword(){
    }
    @FXML
    void logInAction(){
        DbConnector.queryNewUser(loginField,passwordField);


    }
    @FXML
    private void initialize(){
        System.out.println("Inicjalizacja RegisterPane");
    }
}
