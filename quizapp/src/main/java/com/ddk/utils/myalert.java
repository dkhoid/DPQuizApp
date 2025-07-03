
package com.ddk.utils;

import javafx.scene.control.Alert;


public class Myalert {
    private static Myalert instance;
    private final Alert alert;

    private Myalert() {
        this.alert = new Alert(Alert.AlertType.INFORMATION);
        this.alert.setHeaderText("quizapp");
    }

    public static Myalert getInstance() {
        if (instance == null) {
            instance = new Myalert();
        }
        return instance;
    }

    public void showMsg(String msg) {
        this.alert.setContentText(msg);
        this.alert.showAndWait();
    }
}
