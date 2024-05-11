module com.bank {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;

    opens com.bank to javafx.fxml;

    exports com.bank;
}
