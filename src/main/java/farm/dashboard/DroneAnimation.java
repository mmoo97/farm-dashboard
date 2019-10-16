package farm.dashboard;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class DroneAnimation extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("MainLayout.fxml"));

        Scene scene = new Scene(root, 1200, 800);

        primaryStage.setTitle("Farm Dashboard");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}
