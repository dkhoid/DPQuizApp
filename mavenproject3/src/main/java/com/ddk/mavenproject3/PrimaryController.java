package com.ddk.mavenproject3;

import com.ddk.utils.myalert;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PrimaryController {
    public void HandleQuestionManagement() throws IOException{
        Scene scene = new Scene(new FXMLLoader(App.class.getResource("question.fxml")).load());
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("quizapp");
        stage.show();
        
    }
    public void HandleNewPlay(ActionEvent event){
        myalert.getInstance().showMsg("Coming soon");
    }
    public void HandleSignup(ActionEvent event){
        myalert.getInstance().showMsg("Coming soon");

    }
}
