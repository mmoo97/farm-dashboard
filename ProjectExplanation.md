##Project Explanation of Design

Part one of our design implementation consists of nine classes: `DashboardApp.java`, `Item.java`, `ItemContainer.java`, `FarmComponent.java`, `MainController.java`, `ComponentContextMenu.java`, `PropertiesPrompt.java`, `DroneAnimation.java`, and `AppLauncher.java`.  Each of these classes work together to achieve the initial representation of our farm dashboard:
 
* `DashboardApp.java` loads the `javafx` main layout:  `farm.dashboard/MainLayout.fxml`.
* `FarmComponent` defines get and set functions for the dashboard.
* `Item.java` and `ItemContainer.java` define certain attributes about the dashboard.  
* `MainController.java` contains the backend work of the GUI.
* `ComponentContextMenu.java` contains the commands for changing items and item containers.
* `PropertiesPrompt.java` creates the pop-up prompt for adding new items and/or item containers.
* `DroneAnimation.java` simulates drone movement to items on farm in the GUI.
* `AppLauncher.java` contains the main method and calls `DashboardApp.java`.

***
*Please see our `README.md` on `Gitlab` for more information.*
***