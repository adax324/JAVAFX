package com.adaxator.DbConnector;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.*;

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
    public static boolean queryLogIn(TextField textField,PasswordField passwordField){
        Connection connection=connect();
        Statement statement=null;
        try {
            statement=connection.createStatement();
            ResultSet resultSet=
                    statement.executeQuery(String.format
                            ("select * from users where userName=\"%s\"" +
                                    "and userpassword=PASSWORD(\"%s\") limit 1",
                                    textField.getCharacters(),passwordField.getCharacters()));
           if(resultSet.next()){
               System.out.println("User Match");
               return true;
           }


        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;

    }

    public static void main(String[] args) {
        connect();
    }
}
