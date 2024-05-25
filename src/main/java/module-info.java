module com.example.homepage {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires com.jfoenix;
    requires java.sql;

    opens com.example.homepage to javafx.fxml;
    exports com.example.homepage;
    exports Classes;
    opens Classes to javafx.fxml;
}