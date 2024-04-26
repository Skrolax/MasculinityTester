module com.zyzz {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires eu.hansolo.tilesfx;
    requires javafx.media;

    opens com.zyzz to javafx.fxml;
    exports com.zyzz;
}