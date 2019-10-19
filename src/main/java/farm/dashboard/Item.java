package farm.dashboard;

public class Item extends FarmComponent {

    public Item(){
    }

    public Item(String name, double price, double x, double y, int length, int width, int height){
        this.name = name;
        this.price = price;
        this.location_x = x;
        this.location_y = y;
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public void delete(){
        // Probably just zero out all the values and wait for garbage collection
        return;
    }

}
