module com.fritz.app {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fritz.app to javafx.fxml;
    exports com.fritz.app;
}