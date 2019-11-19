package farm.dashboard;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.beans.EventHandler;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static farm.dashboard.AppLauncher.app;

public class SimulatedDroneFlight implements SimulatedDrone {

    private double x_destination;
    private double y_destination;
    private FarmComponent component;

    @FXML
    private StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");
    private ImageView car;


    public SimulatedDroneFlight(){

    }

    public SimulatedDroneFlight(double x_destination, double y_destination) {
        this.x_destination = x_destination;
        this.y_destination = y_destination;

    }

    public SimulatedDroneFlight(FarmComponent component){

        this.component = component;
        this.x_destination = component.getLocationX();
        this.y_destination = component.getLocationY();
    }

    private void setup(PathElement[] path, int speed, boolean deleteOnFinish){

        Path road = new Path();
        road.setStroke(Color.BLACK);
        road.setStrokeWidth(75);
        road.getElements().addAll(path);

        PathTransition anim = new PathTransition();
        anim.setNode(car);
        anim.setPath(road);
        anim.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        anim.setInterpolator(Interpolator.LINEAR);
        anim.setDuration(new Duration(speed));
        anim.setCycleCount(1);

        stack.getChildren().addAll(car);
        if (deleteOnFinish)
            anim.setOnFinished(event -> deleteDrone(car));
        anim.play();
//        root.setOnMouseClicked(me ->
//        {
//            Animation.Status status = anim.getStatus();
//            if (status == Animation.Status.RUNNING &&
//                    status != Animation.Status.PAUSED)
//                anim.pause();
//            else
//                anim.play();
//        });

    }

    @FXML
    public void scanFarm(int speed){

        car = new ImageView();
        car.setImage(new Image("farm.dashboard/drone.png"));

        PathElement[] path =
                {
                        new MoveTo(-350,300),
                        new LineTo(400,300),
                        new LineTo(400,250),
                        new LineTo(-350,250),

                        new LineTo(-350,200),
                        new LineTo(400,200),
                        new LineTo(400,150),
                        new LineTo(-350,150),

                        new LineTo(-350,100),
                        new LineTo(400,100),
                        new LineTo(400,50),
                        new LineTo(-350,50),

                        new LineTo(-350,0),
                        new LineTo(400,0),
                        new LineTo(400,-50),
                        new LineTo(-350,-50),

                        new LineTo(-350,-100),
                        new LineTo(400,-100),
                        new LineTo(400,-150),
                        new LineTo(-350,-150),

                        new LineTo(-350,-200),
                        new LineTo(400,-200),

                        new ClosePath()
                };

        setup(path, speed, true);

    }

    public void flytoLocation(int speed){

        car = new ImageView();
        car.setImage(new Image("farm.dashboard/drone.png"));

        PathElement[] path =
                {       new MoveTo(-350, 300),
                        new LineTo(x_destination,y_destination),
                        new ClosePath()
                };

            setup(path, speed, false);

    }

    @Override
    public void deleteDrone(ImageView drone) {
        stack.getChildren().remove(drone);
    }
}
