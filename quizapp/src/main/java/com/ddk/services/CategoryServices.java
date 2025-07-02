package com.ddk.services;

import com.ddk.pojo.Category;
import com.ddk.utils.JdbcConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryServices {
    public List<Category> getAllCategories() {
        List<Category> categories = new ArrayList<>();
        try {
            Connection conn = JdbcConnector.getInstance().getConnection();
            String sql = "SELECT id, name FROM categories";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    categories.add(new Category(id, name));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return categories;
    }
}
