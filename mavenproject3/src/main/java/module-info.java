module com.ddk.mavenproject3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.ddk.mavenproject3 to javafx.fxml;
    exports com.ddk.mavenproject3;
}
