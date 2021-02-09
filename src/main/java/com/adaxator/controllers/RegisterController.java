package com.adaxator.controllers;

import com.adaxator.DbConnector.DbConnector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.beans.EventHandler;

public class RegisterController {
    @FXML
    private TextField loginField;
    @FXML
    PasswordField passwordField;

    primaryStackController primaryStackController;

    public void setPrimaryStackController(com.adaxator.controllers.primaryStackController primaryStackController) {
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
}
