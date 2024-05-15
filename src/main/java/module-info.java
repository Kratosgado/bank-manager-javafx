module com.bank {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires atlantafx.base;

    opens com.bank to javafx.fxml;
    opens com.bank.auth to javafx.fxml;

    exports com.bank;
}
