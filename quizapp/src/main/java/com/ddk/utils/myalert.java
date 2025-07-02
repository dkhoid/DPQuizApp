
package com.ddk.utils;

import javafx.scene.control.Alert;


public class myalert {
    private static myalert instance;
    private final Alert alert;

    private myalert() {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.alert.setHeaderText("quizapp");
    }

    public static myalert getInstance() {
        if (instance == null) {
            instance = new myalert();
        }
        return instance;
    }

    public void showMsg(String msg) {
        this.alert.setContentText(msg);
        this.alert.showAndWait();
    }
}
