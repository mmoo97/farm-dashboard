package farm.dashboard;

import java.lang.Math;
import java.util.ArrayList;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
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
//        drawingItems.getChildren().clear();
//        drawComponents(rootContainer);
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
        StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");
        stack.setAlignment(Pos.BOTTOM_CENTER);
        stack.getChildren().addAll(vComponent, text);

//        drawingItems.setTopAnchor(stack, 800 - component.getLocationY());
//        drawingItems.setBottomAnchor(stack, component.getLocationY());
//        drawingItems.setRightAnchor(stack, 600 - component.getLocationX());
//        drawingItems.setLeftAnchor(stack, component.getLocationX());
//        drawingItems.getChildren().add(stack);
    }
    @FXML
    private void animateItem(){
        //Todo: Expand animation functionality beyond just scanning
//        double startX = item.location_x;
//        double startY = item.location_y;
//        double endX = 600.0; //x;
//        double endY = 600.0; //y;

        StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");

        ImageView car = new ImageView();
        car.setImage(new Image("farm.dashboard/drone.png"));
        car.setX(0);
        car.setY(0);
        car.setTranslateX(0.00);
        car.setTranslateY(0.00);
        car.setRotate(90);

        PathElement[] path =
                {
//                        new MoveTo(0, 300),
//                        new ArcTo(100, 100, 0, 100, 400, false, false),
//                        new LineTo(300, 400),
//                        new ArcTo(100, 100, 0, 400, 300, false, false),
//                        new LineTo(400, 100),
//                        new ArcTo(100, 100, 0, 300, 0, false, false),
//                        new LineTo(100, 0),
//                        new ArcTo(100, 100, 0, 0, 100, false, false),
//                        new LineTo(0, 300),
                        new MoveTo(0,0),
                        new LineTo(0,-100),
                        new ArcTo(100,100,0, -100, -200, false, false),
                        new LineTo(-200,-200),
                        new ArcTo(100,100,0, -250, -100, false, false),
                        new LineTo(-250,150),
                        new ArcTo(100,100,0, -150, 250, false, false),
                        new LineTo(300,250),
                        new ArcTo(100,100,0, 400, 100, false, false),
                        new LineTo(400, -200),
                        new ClosePath()
                };

        Path road = new Path();
        road.setStroke(Color.WHITE);
        road.setStrokeWidth(75);
        road.getElements().addAll(path);

        PathTransition anim = new PathTransition();
        anim.setNode(car);
        anim.setPath(road);
        anim.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        anim.setInterpolator(Interpolator.LINEAR);
        anim.setDuration(new Duration(6000));
        anim.setCycleCount(Timeline.INDEFINITE);

        Group root = new Group();
        root.getChildren().addAll(road, car);
        root.setTranslateX(50);
        root.setTranslateY(50);
        stack.getChildren().addAll(car);
        anim.play();
//        root.setOnMouseClicked(me ->
//        {
//            Animation.Status status = anim.getStatus();
//            if (status == Animation.Status.RUNNING &&
//                    status != Animation.Status.PAUSED)
//                anim.pause();
//            else
//                anim.play();
//        });

    }

    private String getImageURIPath(String imageName){
        return "file:src/main/resources/farm.dashboard/" + imageName;
    }

}

