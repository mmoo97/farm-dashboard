package farm.dashboard;

import javafx.scene.image.ImageView;
import javafx.scene.shape.PathElement;

public interface SimulatedDrone {
    private void setup(PathElement[] path, int speed, boolean deleteOnFinish) {

    }

    public void scanFarm(int speed);

    public void flytoLocation(int speed);

    public void deleteDrone(ImageView drone);

}
