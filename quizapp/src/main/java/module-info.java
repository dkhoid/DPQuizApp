module com.ddk.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires mysql.connector.j;

    opens com.ddk.quizapp to javafx.fxml;
    opens com.ddk.pojo to javafx.base;
    exports com.ddk.quizapp;
}