package farm.dashboard;

import java.util.Optional;

import java.util.ArrayList;
import java.util.Iterator;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextInputDialog;

public class ItemContainer extends FarmComponent {

    private ArrayList<FarmComponent> items =  new ArrayList<FarmComponent>();
    private double marketValue;

    public ItemContainer(){
    }

    public ItemContainer(String name, double price, double x, double y, int length, int width, int height){
        this.name = name;
        this.price = price;
        this.location_x = x;
        this.location_y = y;
        this.length = length;
        this.width = width;
        this.height = height;
        this.contextMenu = new ComponentContextMenu(this);
        MenuItem item6 = new MenuItem("Add Item");
        item6.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                Item temp;
                new PropertiesPrompt(temp = new Item("name", 0.00, 1, 1, 1, 1, 1),
                "Add Item Container", "Edit Container Properties");
                add(temp);
            }
        });
        MenuItem item7 = new MenuItem("Add Item Container");
        item7.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                ItemContainer temp;
                new PropertiesPrompt(temp = new ItemContainer("name", 0.00, 1, 1, 1, 1, 1),
                "Add Item Container", "Edit Container Properties");
                add(temp);
            }
        });
        this.contextMenu.getItems().addAll(item6, item7);

    }
    public ItemContainer(String name, double price, double x, double y, int length, int width, int height, double market_value){
        this(name, price, x, y, length, width, height);
        this.market_value = market_value;
    }
    public ItemContainer(String name, double price, double x, double y, int length, int width, int height, double market_value, String imageName){
        this(name, price, x, y, length, width, height, imageName);
        this.market_value = market_value;
    }
    public ItemContainer(String name, double price, double x, double y, int length, int width, int height, String imageName){
        this(name, price, x, y, length, width, height);
        this.imageName = imageName;
    }

    public boolean add(FarmComponent component){
        component.setParent(this);
        return items.add(component);
    }

    public FarmComponent remove(int index){
        return items.remove(index);
    }

    public boolean remove(FarmComponent component){
        component.setParent(null);
        return items.remove(component);
    }

    public void delete(){
        // Probably just zero out all the values and wait for garbage collection
        return;
    }

    public ArrayList<FarmComponent> getChildren(){
        return items;
    }

    public double getNetPrice(){
        double price = 0;
        for (int i = 0; i<items.size();i++){
            price += items.get(i).price;
        }
        return price;
    }

    public void accept(Visitor v){
        v.visitItemContainer(this);
    }


}
