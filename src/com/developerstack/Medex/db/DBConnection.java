package com.developerstack.Medex.db;

public class DBConnection {
    private  DBConnection() throws ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
    }
}
