package com.adaxator.DbConnector;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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

    public static void main(String[] args) {
        connect();
    }
}
