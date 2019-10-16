package farm.dashboard;

import java.util.ArrayList;
import java.util.Iterator;

public class ItemContainer extends FarmComponent {

    private ArrayList<FarmComponent> items =  new ArrayList<FarmComponent>();

    public ItemContainer(){
    }

    public boolean add(FarmComponent component){
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

}
