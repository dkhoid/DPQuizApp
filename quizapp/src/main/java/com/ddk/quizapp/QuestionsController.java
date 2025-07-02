package com.ddk.quizapp;

import com.ddk.pojo.Category;
import com.ddk.services.CategoryServices;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

import java.net.URL;
import java.util.ResourceBundle;

public class QuestionsController implements Initializable {
    @FXML
    private ComboBox<Category> categoryComboBox;
    private static final CategoryServices categoryServices = new CategoryServices();
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            this.categoryComboBox.setItems(FXCollections.observableList(categoryServices.getAllCategories()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
