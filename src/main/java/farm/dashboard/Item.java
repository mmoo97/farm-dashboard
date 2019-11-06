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
        this.contextMenu = new ComponentContextMenu(this);
    }

    public Item(String name, double price, double x, double y, int length, int width, int height, double market_value){
        this(name, price, x, y, length, width, height);
        this.market_value = market_value;
    }

    public Item(String name, double price, double x, double y, int length, int width, int height, double market_value, String imageName){
        this(name, price, x, y, length, width, height, imageName);
        this.market_value = market_value;
    }

    public Item(String name, double price, double x, double y, int length, int width, int height, String imageName){
        this(name, price, x, y, length, width, height);
        this.imageName = imageName;
    }

    public void delete(){
        // Probably just zero out all the values and wait for garbage collection
        return;
    }

    public double getPrice(){ return this.price;}

    public void accept(Visitor v){
        v.visitItem(this);
    }

}
