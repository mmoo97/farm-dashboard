package farm.dashboard;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class DashboardApp extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("farm.dashboard/MainLayout.fxml"));

        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setTitle("Farm Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
