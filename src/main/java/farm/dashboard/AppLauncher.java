package farm.dashboard;

public class AppLauncher {
    private static AppLauncher instance;
    static DashboardApp app;

    AppLauncher(){
        this.app = new DashboardApp();

    }

    public static AppLauncher getInstance(){
        if(instance==null){
            instance = new AppLauncher();
        }
        return instance;
    }

    public static void main(String[] args) {
        AppLauncher runApp = new AppLauncher();

        if(runApp.getInstance() != null) {
            app.main(args);
        }
        else
            System.out.println("already have an instance running");
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


