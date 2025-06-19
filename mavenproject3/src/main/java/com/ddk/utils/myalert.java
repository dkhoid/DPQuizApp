/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ddk.utils;
import javafx.scene.control.Alert;

/**
 *
 * @author admin
 */
public class myalert {
    private static myalert instance;
    private final Alert alert;
    private myalert(){
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.alert.setHeaderText("quizapp");
    }
    public static myalert getInstance(){
        if(instance==null){
            instance = new myalert();
        }
        return instance;
    }
    public void showMsg(String msg){
        this.alert.setContentText(msg);
        this.alert.showAndWait();
    }
}
