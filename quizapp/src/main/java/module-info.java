module com.ddk.quizapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    requires static lombok;
    requires mysql.connector.j;

    opens com.ddk.quizapp to javafx.fxml;
    exports com.ddk.quizapp;
}
