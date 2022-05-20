module com.szekalski.michal.mysnake {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.szekalski.michal.mysnake to javafx.fxml;
    exports com.szekalski.michal.mysnake;
}