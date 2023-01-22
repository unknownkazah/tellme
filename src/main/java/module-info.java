module com.example.tellme {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.tellme to javafx.fxml;
    exports com.example.tellme;
}