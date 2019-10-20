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
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.ContextMenu;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class MainController{
    @FXML
    private Button paintFarm;

    @FXML
    private AnchorPane drawingItems;

    @FXML
    private ItemContainer rootContainer = new ItemContainer();

    @FXML
    private TreeView<FarmComponent> componentTree = new TreeView<FarmComponent>();

    private ContextMenu menu = new ContextMenu();

    @FXML
    public void treeMouseHandler(MouseEvent event){
        MouseButton button = event.getButton();
        if(button==MouseButton.SECONDARY){
            TreeItem<FarmComponent> selected = componentTree.getSelectionModel().getSelectedItem();
            if (selected!=null) {
                openContextMenu(selected, event.getScreenX(), event.getScreenY());
            }
        }else{
            menu.hide();
        }
    }

    private void openContextMenu(TreeItem<FarmComponent> item, double x, double y) {
        menu = item.getValue().getContextMenu();
        menu.show(componentTree, x, y);
    }

    @FXML
    public void drawTree(ActionEvent event){
        TreeItem<FarmComponent> rootItem = buildComponentTree(rootContainer);
        componentTree.setRoot(rootItem);
        componentTree.setShowRoot(false);
    }

    private TreeItem<FarmComponent> buildComponentTree(FarmComponent component){
        TreeItem<FarmComponent> root = new TreeItem<FarmComponent>(component);
        ArrayList<FarmComponent> children = component.getChildren();
        for(int i = 0; i<children.size(); i++){
            root.getChildren().add(buildComponentTree(children.get(i)));
        }
        return root;
    }

    @FXML
    public void addItem(){
        TreeItem<FarmComponent> selected  = componentTree.getSelectionModel().getSelectedItem();
        Item a = new Item("Added Item", 3.00, 100, 400, 30, 50, 20);
        if(selected!=null){
            ItemContainer item = (ItemContainer)(selected.getValue());
            item.add(a);
        } else {
            rootContainer.add(a);
        }
    }

    @FXML
    public void addItemContainer(){
        TreeItem<FarmComponent> selected  = componentTree.getSelectionModel().getSelectedItem();
        ItemContainer a = new ItemContainer("Added Item", 3.00, 100, 400, 30, 50, 20);
        if(selected!=null){
            ItemContainer item = (ItemContainer)(selected.getValue());
            item.add(a);
        } else {
            rootContainer.add(a);
        }
    }

    @FXML
    public void drawFarm(ActionEvent event){
        drawingItems.getChildren().clear();
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

