package farm.dashboard;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemContainer extends FarmComponent {

    private ArrayList<FarmComponent> items =  new ArrayList<FarmComponent>();

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
    }

    public boolean add(FarmComponent component){
        component.setParent(this);
        return items.add(component);
    }

    public FarmComponent remove(int index){
        return items.remove(index);
    }

    public boolean remove(FarmComponent component){
        return items.remove(component);
    }

    public void delete(){
        // Probably just zero out all the values and wait for garbage collection
        return;
    }

    public ArrayList<FarmComponent> getChildren(){
        return items;
    }


}
