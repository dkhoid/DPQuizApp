package com.ddk.utils;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnector {
    private static JdbcConnector instance;
    private final Connection conn;
    
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(JdbcConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private JdbcConnector() throws SQLException {
        //this.conn = DriverManager.getConnection("jdbc:mysql://localhost/quizdb", "root", "root");
        this.conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quizdb", "root", "khoi2005");
    }
    
    public static JdbcConnector getInstance() throws SQLException {
        if (instance == null)
            instance = new JdbcConnector();
        return instance;
    }
    
    public Connection connect() { return this.conn; }
    
    public void close() throws SQLException {
        if (this.conn != null)
            this.conn.close();
    }
}