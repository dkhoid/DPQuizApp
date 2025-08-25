package com.ddk.utils;
import com.ddk.quizapp.App;
import com.ddk.utils.themes.ThemeManager;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MyStage {
    private static MyStage instance;
    private final Stage stage;
    private static Scene scene;
    
    private MyStage() {
        stage = new Stage();
        stage.setTitle("Quiz App");
    }
    
    public static MyStage getInstance() {
        if (instance == null)
            instance = new MyStage();
        return instance;
    }
    
    public void showStage(String fxml) throws IOException {
        if (scene == null)
            scene = new Scene(new FXMLLoader(App.class.getResource(fxml)).load());
        else
            scene.setRoot(new FXMLLoader(App.class.getResource(fxml)).load());
        
        ThemeManager.applyTheme(scene);
        this.stage.setScene(scene);
        this.stage.show();
    }
}