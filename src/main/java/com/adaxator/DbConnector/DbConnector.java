package com.adaxator.DbConnector;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnector {
    public static Connection connect(){
        String url="jdbc:mysql://localhost/sklep";
        String user="root";
        String password="";
        Connection connection=null;
        try{
            connection= DriverManager.getConnection(url,user,password);
            System.out.println("Połączono z bazą danych");
        }catch (SQLException e){
            System.out.println("Błąd połączenia z bazą danych");
            e.printStackTrace();
        }
        return connection;
    }
    //query non select
    public static void queryNewUser(TextField textField,PasswordField passwordField){
        Connection connection=connect();
        Statement statement=null;

        try {
            statement= connection.createStatement();
            statement.execute(String.format
                    ("insert into users values(\"%s\",PASSWORD(\"%s\"))",
                            textField.getCharacters(),passwordField.getCharacters()));
                    connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        connect();
    }
}
