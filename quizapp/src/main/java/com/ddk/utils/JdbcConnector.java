package com.ddk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class JdbcConnector {
    private static JdbcConnector instance;
    private Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            Logger.getLogger(JdbcConnector.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    // Private constructor
    private JdbcConnector() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("db.properties")) {
            props.load(input);

            String url = props.getProperty("db.url");
            String user = props.getProperty("db.user");
            String pass = props.getProperty("db.password");

            conn = DriverManager.getConnection(url, user, pass);

        } catch (IOException | SQLException ex) {
            Logger.getLogger(JdbcConnector.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Singleton: chỉ tạo 1 instance duy nhất
    public static JdbcConnector getInstance() {
        if (instance == null) {
            instance = new JdbcConnector();
        }
        return instance;
    }

    public Connection getConnection() {
        return conn;
    }

    public void closeConnection() {
        try {
            if (conn != null && !conn.isClosed())
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
