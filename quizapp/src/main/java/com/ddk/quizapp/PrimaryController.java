package com.ddk.quizapp;

import com.ddk.themes.Themes;
import com.ddk.utils.MyStage;
import com.ddk.utils.Myalert;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

public class PrimaryController implements Initializable{
    @FXML ComboBox<Themes> cbThemes;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.cbThemes.setItems(FXCollections.observableArrayList(Themes.values()));
    }
    public void HandleChangeThemes(ActionEvent event){
        this.cbThemes.getSelectionModel().getSelectedItem().updateTheme(this.cbThemes.getScene());
    }
    public void HandleQuestionManagement() throws IOException {
        MyStage.getInstance().showStage("questions.fxml");
    }

    public void HandleNewPlay(ActionEvent event) {
        Myalert.getInstance().showMsg("Coming soon");
    }

    public void HandleSignin(ActionEvent event) {
        Myalert.getInstance().showMsg("Coming soon");

    }

    public void HandleSignup(ActionEvent event) {
        Myalert.getInstance().showMsg("Coming soon");

    }

    public void HandleNewPractice(ActionEvent event) {
        Myalert.getInstance().showMsg("Coming soon");

    }
}
