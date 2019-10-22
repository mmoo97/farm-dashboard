package farm.dashboard;

import java.lang.Math;
import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.SequentialTransition;
import javafx.animation.Timeline;
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
import javafx.util.Duration;

import static farm.dashboard.AppLauncher.app;
import static farm.dashboard.AppLauncher.getInstance;

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

        //StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");
        StackPane stack = new StackPane();
        stack.setAlignment(Pos.BOTTOM_CENTER);
        stack.getChildren().addAll(vComponent, text);

        drawingItems.setTopAnchor(stack, 800 - component.getLocationY());
        drawingItems.setBottomAnchor(stack, component.getLocationY());
        drawingItems.setRightAnchor(stack, 600 - component.getLocationX());
        drawingItems.setLeftAnchor(stack, component.getLocationX());
        drawingItems.getChildren().add(stack);
    }

    private void animateItem(Item item, double x, double y){
        double startX = item.location_x;
        double startY = item.location_y;
        double endX = x;
        double endY = y;

        // Create the Timelines
        Timeline rotate = new Timeline();
        Timeline moveDiagonal = new Timeline();
        Timeline moveUp = new Timeline();
        Timeline rotateNext = new Timeline();
        Timeline rotateLast = new Timeline();
        Timeline moveLeft = new Timeline();
        SequentialTransition sequence = new SequentialTransition();

        ImageView drone = new ImageView(new Image("farm.dashboard/drone.png"));

        // Get the Scene width and height along with image width
        double sceneWidth = item.getWidth();
        double sceneHeight = item.getHeight();
        double droneWidth = drone.getLayoutBounds().getWidth();

        // Define the Durations
        Duration startDuration = Duration.ZERO;
        Duration endDuration = Duration.seconds(5);
        Duration endDuration2 = Duration.seconds(2);

        // Create Key Frames
        KeyValue startKeyValue = new KeyValue(drone.translateXProperty(), 0);
        KeyFrame startKeyFrameDiagonal = new KeyFrame(startDuration, startKeyValue);
        KeyValue endKeyValueX = new KeyValue(drone.translateXProperty(), sceneWidth - droneWidth*1.5);
        KeyValue endKeyValueY = new KeyValue(drone.translateYProperty(), sceneHeight - droneWidth*2.375);
        KeyFrame endKeyFrameDiagonal = new KeyFrame(endDuration, endKeyValueX, endKeyValueY);


        KeyValue endKeyValueRotate = new KeyValue(drone.rotateProperty(), drone.getRotate() - 90);
        KeyFrame endKeyFrameRotate = new KeyFrame(endDuration2, endKeyValueRotate);

        KeyValue endKeyValueMoveUp = new KeyValue(drone.translateYProperty(), 0);
        KeyFrame endKeyFrameMoveUp = new KeyFrame(endDuration, endKeyValueMoveUp);

        KeyValue endKeyValueRotateNext = new KeyValue(drone.rotateProperty(),  drone.getRotate() - 180);
        KeyFrame endKeyFrameRotateNext = new KeyFrame(endDuration2, endKeyValueRotateNext);

        KeyValue endKeyValueMoveLeft = new KeyValue(drone.translateXProperty(), 0);
        KeyFrame endKeyFrameMoveLeft = new KeyFrame(endDuration, endKeyValueMoveLeft);

        KeyValue endKeyValueRotateLast = new KeyValue(drone.rotateProperty(),  drone.getRotate() - 360);
        KeyFrame endKeyFrameRotateLast = new KeyFrame(endDuration2, endKeyValueRotateLast);

        // Create Timelines
        rotate = new Timeline(endKeyFrameRotate);
        rotateNext = new Timeline(endKeyFrameRotateNext);
        moveDiagonal = new Timeline(startKeyFrameDiagonal, endKeyFrameDiagonal);
        moveUp = new Timeline(endKeyFrameMoveUp);
        moveLeft = new Timeline(endKeyFrameMoveLeft);
        rotateLast = new Timeline(endKeyFrameRotateLast);

        // Create Sequence
        sequence = new SequentialTransition(moveDiagonal, rotate, moveUp, rotateNext, moveLeft, rotateLast);
        // Let the animation run forever
        sequence.setCycleCount(Timeline.INDEFINITE);
    }

    private String getImageURIPath(String imageName){
        return "file:src/main/resources/farm.dashboard/" + imageName;
    }

}

