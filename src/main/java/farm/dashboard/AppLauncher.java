package farm.dashboard;

public class Singleton {
    private static Singleton instance;

    Singleton(){

    }

    public static Singleton getInstance(){
        if(instance==null){
            instance = new Singleton();
        }
        return instance;
    }

    public static void main(String[] args) {
        Singleton runApp = new Singleton();

        if(runApp.getInstance() == null) {
            DroneAnimation.main(args);
        }
    }
}

/*
singleton example
public class Singleton{
    private Singleton instance;

    private Singleton()   {

    }
    public static Singleton getInstance()   {
        if(instance==null)      {
            instance = new Singleton();
        }
        return instance;
    }
}
 */

