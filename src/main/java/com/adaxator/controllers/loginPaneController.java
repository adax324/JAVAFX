package com.adaxator.controllers;

import com.adaxator.DbConnector.DbConnector;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class loginPaneController {
    @FXML
    private TextField loginField;
    @FXML
    private PasswordField passwordField;
    private PrimaryStackController primaryStackController;

    public void setprimaryStackController(PrimaryStackController primaryStackController){
        this.primaryStackController=primaryStackController;
    }
    @FXML
    private void initialize(){
        System.out.println("Zainicjalizowane logInPaneV2");

    }
    @FXML
    private void menuAction(){
        primaryStackController.setMenu();
    }
    @FXML
    private void logInAcction(){
    if (DbConnector.queryLogIn(loginField,passwordField)){
        System.out.println("SIEMANO");
    }

    }


}
