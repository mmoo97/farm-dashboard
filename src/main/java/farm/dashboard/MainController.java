package farm.dashboard;

import java.lang.Math;
import java.util.ArrayList;

import javafx.animation.*;
import javafx.geometry.Pos;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.shape.*;
import javafx.scene.text.Text;
import javafx.scene.layout.StackPane;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import static farm.dashboard.AppLauncher.app;
import static farm.dashboard.AppLauncher.getInstance;

public class MainController{
    @FXML
    private VBox thing;

    private Text text = new Text(10, 20,"Purchase Price:");
    private Text text2 = new Text("Current Market Value:");


    @FXML
    private Button droneString;

    @FXML
    private Image droneImage = new Image("file:src/main/java/resources/farm.dashboard/drone.png");

    @FXML
    private ImageView imageView = new ImageView(droneImage);

    @FXML
    private Button paintFarm;

    @FXML
    private AnchorPane textField;

    @FXML
    private AnchorPane drawingItems;

    @FXML
    private ItemContainer rootContainer = new ItemContainer("", 0, 0, 0, 0, 0, 0, "");

    @FXML
    private TreeView<FarmComponent> componentTree = new TreeView<FarmComponent>();

    private ContextMenu menu = new ContextMenu();

    Adapter adapt;

    SimulatedDroneFlight to_item;
    boolean sim_selected = true;

    FarmComponent last_selected;

    @FXML
    public void treeMouseHandler(MouseEvent event) throws ClassNotFoundException {
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

        if( button == MouseButton.PRIMARY){
            thing.getChildren().remove(text);
            thing.getChildren().remove(text2);
            PricingVisitor vis = new PricingVisitor();

            TreeItem<FarmComponent> selected = componentTree.getSelectionModel().getSelectedItem();
            last_selected = selected.getValue();

            to_item = new SimulatedDroneFlight(selected.getValue());

            if( selected.getValue() instanceof ItemContainer ) {
                selected.getValue().accept(vis);
                text.setText("Purchase Price: " + vis.getValue());
                text.setFont(Font.font(" Verdana",20));
                text2.setFont(Font.font("Verdana", 20));
                thing.getChildren().add(text);
                thing.getChildren().add(text2);
            } else{
                selected.getValue().accept(vis);
                text.setText("Purchase Price: " + vis.getValue());
                text.setFont(Font.font("Verdana", 20));
                text2.setText("Market Value: " + vis.getValue());
                text2.setFont(Font.font("Verdana", 20));
                thing.getChildren().add(text);
                thing.getChildren().add(text2);
            }
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
        StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");
        stack.getChildren().clear();
        drawComponents(rootContainer);
    }


    private void drawComponents(FarmComponent component){
        drawComponent(component);
        ArrayList<FarmComponent> children = component.getChildren();
        for(int i = 0; i<children.size(); i++){
            drawComponents(children.get(i));
        }
    }

    private void drawComponent(FarmComponent component) {
        Text text = new Text(component.getName());

        String imageName = component.getImageName() != null ? component.getImageName() : "placeholder.png";
        ImageView vComponent = new ImageView(new Image(getImageURIPath(imageName)));

        vComponent.setFitWidth(component.getWidth());
        vComponent.setFitHeight(component.getHeight());
        vComponent.setX(component.getLocationX());
        vComponent.setY(component.getLocationY());

        // comment these two lines for original creation functionality
        StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");
        stack.getChildren().addAll(vComponent, text);

//        uncomment these lines for original creation functionality
//        StackPane stack = new StackPane();
//        stack.setAlignment(Pos.BOTTOM_CENTER);
//        stack.getChildren().addAll(vComponent, text);
//
//        drawingItems.setTopAnchor(stack, 800 - component.getLocationY());
//        drawingItems.setBottomAnchor(stack, component.getLocationY());
//        drawingItems.setRightAnchor(stack, 600 - component.getLocationX());
//        drawingItems.setLeftAnchor(stack, component.getLocationX());
//        drawingItems.getChildren().add(stack);



    }

    @FXML
    private void animateDrone() {

        if (!sim_selected) {
            PhysicalDroneTello scan = new PhysicalDroneTello();

            PhysicalDroneTello to_location = new PhysicalDroneTello();

        } else {
            SimulatedDroneFlight scan = new SimulatedDroneFlight();

            SimulatedDroneFlight to_location = new SimulatedDroneFlight(0, 0);
        }
    }

    @FXML
    private void scanFarm() {

        if (!sim_selected) {
            PhysicalDroneTello scan = new PhysicalDroneTello();
            Adapter adapter = new Adapter(scan);
            adapter.beginProgram();
            adapter.takeoff();
            adapter.scanFarm(5000);
            adapter.land();

        } else {
            SimulatedDroneFlight scan = new SimulatedDroneFlight();
            Adapter adapter = new Adapter(scan);
            adapter.scanFarm(5000);
        }
    }

    @FXML
    private void visitItem(){


        try {
            if (!sim_selected) {
                PhysicalDroneTello scan = new PhysicalDroneTello();
                scan.beginProgram();
                scan.takeoff();
                scan.gotoXYZ(((int)last_selected.location_x), ((int)last_selected.location_y),
                        0, 55);
                scan.turnCCW(180);
                scan.flyForward(50);
                scan.land();

            } else {
                SimulatedDroneFlight scan = new SimulatedDroneFlight(last_selected);
                Adapter adapter = new Adapter(scan);
                adapter.flytoLocation(3000);
            }
        } catch (NullPointerException e) {
            System.out.println("No previous selection");
        }
    }



    @FXML
    private void physSelected() {
        boolean sim = ((CheckBox) app.getStage().getScene().lookup("#sim")).isSelected();
        boolean phys = ((CheckBox) app.getStage().getScene().lookup("#phys")).isSelected();

        if (sim) {
            ((CheckBox) app.getStage().getScene().lookup("#sim")).setSelected(false);
            ((CheckBox) app.getStage().getScene().lookup("#phys")).setSelected(true);
            sim_selected = false;
        }else {
            ((CheckBox) app.getStage().getScene().lookup("#phys")).setSelected(true);
        }
    }


    @FXML
    private void simSelected() {

        boolean sim = ((CheckBox) app.getStage().getScene().lookup("#sim")).isSelected();
        boolean phys = ((CheckBox) app.getStage().getScene().lookup("#phys")).isSelected();

        if (phys) {
            ((CheckBox) app.getStage().getScene().lookup("#phys")).setSelected(false);
            ((CheckBox) app.getStage().getScene().lookup("#sim")).setSelected(true);
            sim_selected = true;
        }else {
            ((CheckBox) app.getStage().getScene().lookup("#sim")).setSelected(true);
        }

    }

    private String getImageURIPath(String imageName){
        return "file:src/main/resources/farm.dashboard/" + imageName;
    }
    //alright so setX and Y will move the image respectfully
    public void droneConvert(){
        System.out.println("x prop " + imageView.xProperty() + "y prop " + imageView.yProperty());
        imageView.setX(250.0); imageView.setY(300);
    }

}


