module farm.dashboard.main {
    requires javafx.controls;
    requires javafx.fxml;

    opens farm.dashboard to javafx.fxml;
    exports farm.dashboard;
}