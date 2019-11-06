package farm.dashboard;

import java.util.ArrayList;
import javafx.scene.control.ContextMenu;

public abstract class FarmComponent {
    FarmComponent parent;
    public String name;
    public double price;
    public double market_value;
    public double location_x;
    public double location_y;
    public int length;
    public int width;
    public int height;
    protected String imageName;
    protected ContextMenu contextMenu;

    public void delete(){
        // parent.remove(this);
        throw new UnsupportedOperationException("Cannot delete from within an item");
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

    public void setMarketValue(double market_value){
        this.market_value = market_value;
    }

    public void setLocationX(double x){
        this.location_x = x;
    }

    public void setLocationY(double y){
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

    public ArrayList<FarmComponent> getChildren(){
        return new ArrayList<FarmComponent>();
    }

    public double getMarketValue(){
        return this.market_value;
    }

    public String getName(){return name;}

    public double getPrice(){return price;}

    public double getLocationX(){return location_x;}

    public double getLocationY(){return location_y;}

    public int getLength(){return length;}

    public int getWidth(){return width;}

    public int getHeight(){return height;}

    public String getImageName(){return imageName;}

    public ContextMenu getContextMenu(){
        return contextMenu;
    }

    @Override
    public String toString() {
        return this.name;
    }

    public abstract void accept(Visitor v);


    /*
    @Override
    public boolean equals(Object obj){
        if(obj == null || obj.getClass()!= this.getClass()){
            return false;
        }

        FarmComponent c = (FarmComponent) obj;
        if (name.equals(c.name)){
            return true;
        }
        return false;
    }
    */

}
