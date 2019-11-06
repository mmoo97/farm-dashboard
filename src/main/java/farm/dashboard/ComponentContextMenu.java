package farm.dashboard;

import java.util.Optional;

import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

public class ComponentContextMenu extends ContextMenu {
    FarmComponent component;


    public ComponentContextMenu(FarmComponent c){
        super();
        this.component = c;
        MenuItem item1 = new MenuItem("Rename");
        item1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog(component.getName());

                dialog.setTitle("Rename");
                dialog.setHeaderText("Enter new name:");
                dialog.setContentText("Name:");

                Optional<String> result = dialog.showAndWait();

                result.ifPresent(name -> {
                    component.setName(name);
                });
            }
        });
        MenuItem item2 = new MenuItem("Change Location");
        item2.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog(String.valueOf(component.getLocationX()));

                dialog.setTitle("Change Location");
                dialog.setHeaderText("Enter new X:");
                dialog.setContentText("X:");

                Optional<String> result = dialog.showAndWait();

                result.ifPresent(X -> {
                    component.setLocationX(Double.valueOf(X));
                });
                dialog = new TextInputDialog(String.valueOf(component.getLocationY()));
                dialog.setTitle("Change Location");
                dialog.setHeaderText("Enter new Y:");
                dialog.setContentText("Y:");

                result = dialog.showAndWait();

                result.ifPresent(Y -> {
                    component.setLocationY(Double.valueOf(Y));
                });
            }
        });
        MenuItem item3 = new MenuItem("Change Price");
        item3.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog(String.valueOf(component.getPrice()));

                dialog.setTitle("Change Price");
                dialog.setHeaderText("Enter new price:");
                dialog.setContentText("price:");

                Optional<String> result = dialog.showAndWait();

                result.ifPresent(price -> {
                    component.setPrice(Double.valueOf(price));
                });
            }
        });
        MenuItem item4 = new MenuItem("Change Dimensions");
        item4.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog(String.valueOf(component.getLength()));

                dialog.setTitle("Change Length");
                dialog.setHeaderText("Enter new length:");
                dialog.setContentText("Length:");

                Optional<String> result = dialog.showAndWait();

                result.ifPresent(length -> {
                    component.setLength(Integer.valueOf(length));
                });
                dialog = new TextInputDialog(String.valueOf(component.getWidth()));
                dialog.setTitle("Change Width");
                dialog.setHeaderText("Enter new width:");
                dialog.setContentText("Width:");

                result = dialog.showAndWait();

                result.ifPresent(width -> {
                    component.setWidth(Integer.valueOf(width));
                });
                dialog = new TextInputDialog(String.valueOf(component.getHeight()));
                dialog.setTitle("Change Height");
                dialog.setHeaderText("Enter new height:");
                dialog.setContentText("Height:");

                result = dialog.showAndWait();

                result.ifPresent(height -> {
                    component.setHeight(Integer.valueOf(height));
                });
            }
        });
        MenuItem item5 = new MenuItem("Delete");
        item5.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                FarmComponent parent = component.getParent();
                if (parent!=null){
                    ItemContainer c = (ItemContainer)parent;
                    c.remove(component);
                }
            }
        });
        MenuItem item8 = new MenuItem("Change Market Value");
        item8.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                TextInputDialog dialog = new TextInputDialog(String.valueOf(component.getMarketValue()));

                dialog.setTitle("Change Market Value");
                dialog.setHeaderText("Enter new Market Value:");
                dialog.setContentText("Value:");

                Optional<String> result = dialog.showAndWait();

                result.ifPresent(marketValue -> {
                    component.setMarketValue(Double.valueOf(marketValue));
                });
            }
        });

        this.getItems().addAll(item1, item2, item3, item4, item5, item8);

    }
}
