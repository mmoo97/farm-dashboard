package farm.dashboard;

import java.lang.Math;
import java.util.ArrayList;
import javafx.geometry.Pos;
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class MainController{
    @FXML
    private Button paintFarm;

    @FXML
    private AnchorPane drawingItems;

    @FXML
    private ItemContainer rootContainer = new ItemContainer("", 0, 0, 0, 0, 0, 0, "");

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
            } else {
                openContextMenu(componentTree.getRoot(), event.getScreenX(), event.getScreenY());
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
    public void refreshComponents(){
        drawTree();
        drawFarm();
    }

    @FXML
    public void drawTree(ActionEvent event){
        TreeItem<FarmComponent> rootItem = buildComponentTree(rootContainer);
        componentTree.setRoot(rootItem);
        componentTree.setShowRoot(false);
    }

    public void drawTree(){
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
        if(!root.isLeaf()){
            root.setExpanded(true);
        }
        return root;
    }

    @FXML
    public void addItem(){
        TreeItem<FarmComponent> selected  = componentTree.getSelectionModel().getSelectedItem();
        Item a;
        new PropertiesPrompt(a = new Item("name", 0.00, 1, 1, 1, 1, 1),
                "Add Item", "Edit Item Properties");

        if(selected!=null){
            ItemContainer item = (ItemContainer)(selected.getValue());
            item.add(a);
        } else {
            rootContainer.add(a);
        }
        refreshComponents();
    }

    @FXML
    public void addItemContainer(){
        TreeItem<FarmComponent> selected  = componentTree.getSelectionModel().getSelectedItem();
        ItemContainer a;
        //Todo: Potentially add methods for prompt later
        new PropertiesPrompt(a = new ItemContainer("name", 0.00, 1, 1, 1, 1, 1),
                "Add Item Container", "Edit Container Properties");

        if(selected!=null){
            ItemContainer item = (ItemContainer)(selected.getValue());
            item.add(a);
        } else {
            rootContainer.add(a);
        }
        refreshComponents();
    }

    public void drawFarm(){
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

        String imageName = component.getImageName()!=null ? component.getImageName() : "placeholder.png";
        ImageView vComponent = new ImageView(new Image(getImageURIPath(imageName)));

        vComponent.setFitWidth(component.getWidth());
        vComponent.setFitHeight(component.getHeight());
        vComponent.setX(component.getLocationX());
        vComponent.setY(component.getLocationY());

        StackPane stack = new StackPane();
        stack.setAlignment(Pos.BOTTOM_CENTER);
        stack.getChildren().addAll(vComponent, text);

        drawingItems.setTopAnchor(stack, 800 - component.getLocationY());
        drawingItems.setBottomAnchor(stack, component.getLocationY());
        drawingItems.setRightAnchor(stack, 600 - component.getLocationX());
        drawingItems.setLeftAnchor(stack, component.getLocationX());
        drawingItems.getChildren().add(stack);
    }

    private String getImageURIPath(String imageName){
        return "file:src/main/resources/farm.dashboard/" + imageName;
    }

}

