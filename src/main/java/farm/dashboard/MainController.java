package farm.dashboard;

import java.lang.Math;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;

public class MainController{
    @FXML
    private Button paintFarm;

    @FXML
    private AnchorPane drawingItems;

    @FXML
    private ItemContainer rootContainer = new ItemContainer();

    @FXML
    public void drawFarm(ActionEvent event){
        ItemContainer temp = new ItemContainer("test", 2.00, 100, 500, 50, 70, 30);
        temp.add(new Item("test2", 3.00, 100, 400, 30, 50, 20));
        rootContainer.add(temp);
        drawComponents(rootContainer);
    }

    private void drawComponents(FarmComponent component){
        drawComponent(component);
        ArrayList<FarmComponent> children = component.getChildren();
        for(int i = 0; i<children.size(); i++){
            drawComponents(children.get(i));
        }
    }

    private void drawComponent(FarmComponent component){
        Text text = new Text(component.getName());
        Rectangle vComponent = new Rectangle(); // Visual Component
        vComponent.setWidth(component.getWidth());
        vComponent.setHeight(component.getHeight());
        vComponent.setX(component.getLocationX());
        vComponent.setY(component.getLocationY());
        vComponent.setFill(Color.color(Math.random(), Math.random(), Math.random()));

        StackPane stack = new StackPane();
        stack.getChildren().addAll(vComponent, text);

        drawingItems.setTopAnchor(stack, 800 - component.getLocationY());
        drawingItems.setBottomAnchor(stack, component.getLocationY());
        drawingItems.setRightAnchor(stack, component.getLocationX());
        drawingItems.setLeftAnchor(stack, 600 - component.getLocationX());
        drawingItems.getChildren().add(stack);
    }
}

