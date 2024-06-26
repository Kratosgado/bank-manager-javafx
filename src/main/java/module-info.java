module com.bank {
    requires javafx.controls;
    requires transitive javafx.graphics;
    requires javafx.fxml;
    requires atlantafx.base;
    requires java.sql;
    // requires sqlite.jdbc;

    opens com.bank to javafx.fxml;
    opens com.bank.auth to javafx.fxml;
    opens com.bank.dashboard to javafx.fxml;
    opens com.bank.accounts to javafx.base;

    exports com.bank;
}
