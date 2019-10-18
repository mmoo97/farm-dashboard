package farm.dashboard;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class MainController{
    @FXML
    private Button paintFarm;

    @FXML
    private AnchorPane drawingItems;

    @FXML
    public void drawFarm(ActionEvent event){
        Rectangle farm = new Rectangle();
        farm.setWidth(25.0);
        farm.setHeight(25.0);
        farm.setX(300);
        farm.setY(300);
        farm.setFill(Color.RED);

        drawingItems.setTopAnchor(farm, 20.0);
        drawingItems.getChildren().add(farm);
    }
}

