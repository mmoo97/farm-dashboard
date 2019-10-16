package farm.dashboard;

public abstract class FarmComponent {
    FarmComponent parent;
    public String name;
    public double price;
    public int location_x;
    public int location_y;
    public int length;
    public int width;
    public int height;

    public void delete(){
        parent.remove(this);
    };

    public boolean remove(FarmComponent component){
        return true;
    }

    public void setPosition(int x, int y){
        setLocationX(x);
        setLocationY(y);
    }

    public void setParent(FarmComponent parent){
        this.parent = parent;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public void setLocationX(int x){
        this.location_x = x;
    }

    public void setLocationY(int y){
        this.location_y = y;
    }

    public void setLength(int length){
        this.length = length;
    }

    public void setWidth(int width){
        this.width = width;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public FarmComponent getParent(){return parent;}
    public String getName(){return name;}

    public double getPrice(){return price;}

    public int getLocationX(){return location_x;}

    public int getLocationY(){return location_y;}

    public int getLength(){return length;}

    public int getWidth(){return width;}

    public int getHeight(){return height;}
}
