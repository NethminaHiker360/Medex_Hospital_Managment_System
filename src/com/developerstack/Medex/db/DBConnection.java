package com.developerstack.Medex.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static DBConnection dbConnection;
    private Connection connection;

    private  DBConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nedex", "root", "1234");
    }
    public static DBConnection getInstance() throws SQLException, ClassNotFoundException {
        return null==dbConnection? (dbConnection=new DBConnection()):dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
