module com.bank {
    requires javafx.controls;
    requires javafx.graphics;
    requires javafx.fxml;
    requires atlantafx.base;

    opens com.bank to javafx.fxml;

    exports com.bank;
}
