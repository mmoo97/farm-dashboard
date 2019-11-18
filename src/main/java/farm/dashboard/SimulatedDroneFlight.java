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
    public void beginProgram() {
        // Not necessary to implement
    }

    @Override
    public void endProgram() {
        // Not necessary to implement
    }

    @Override
    public void takeoff() {
        // Not necessary to implement
    }

    @Override @FXML
    public void land() {
        // Not necessary to implement
    }

    @Override
    public void streamOn() {
        // Not necessary to implement
    }

    @Override
    public void streamOff() {
        // Not necessary to implement
    }

    @Override
    public void missionPadOn() {
        // Not necessary to implement
    }

    @Override
    public void missionPadOff() {
        // Not necessary to implement
    }

    @Override @FXML
    public void missionPadDirection(int param) {

    }

    @Override
    public void flyUpward(int up) {
        // Not necessary to implement
    }

    @Override
    public void flyDown(int down) {
        // Not necessary to implement
    }

    @Override @FXML
    public void flyForward(int front) {

    }

    @Override @FXML
    public void flyBackward(int back) {

    }

    @Override @FXML
    public void flyLeft(int left) {

    }

    @Override @FXML
    public void flyRight(int right) {

    }

    @Override @FXML
    public void gotoXYZ(int x, int y, int z, int speed) {

    }

    @Override @FXML
    public void gotoMissionPadXYZ(int x, int y, int z, int speed, String ID) {

    }

    @Override @FXML
    public void flyCurve(int x1, int y1, int z1, int x2, int y2, int z2, int speed) {

    }

    @Override @FXML
    public void flyCurveMissionPad(int x1, int y1, int z1, int x2, int y2, int z2, int speed, String ID) {

    }

    @Override @FXML
    public void turnCW(int degrees) {

    }

    @Override @FXML
    public void turnCCW(int degrees) {

    }

    @Override
    public void flip(String direction) {
        // Not necessary to implement
    }

    @Override
    public void jumpMissionPad(int x, int y, int z, int speed, int yaw, String ID1, String ID2) {
        // Not necessary to implement
    }

    @Override
    public void hoverInPlace(int seconds) throws InterruptedException {
        // Not necessary to implement
    }

    @Override @FXML
    public void stopInPlace() {

    }

    @Override
    public void setSpeed(int speed) {
        // Not necessary to implement
    }

    @Override
    public double getSpeed() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getBattery() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getFlightTime() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getHeight() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getTemp() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getAttitudePitch() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getAttitudeRoll() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getAttitudeYaw() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public double getBarometer() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public double getAccelerationX() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public double getAccelerationY() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public double getAccelerationZ() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public int getTOF() {
        // Not necessary to implement
        return 0;
    }

    @Override
    public String getWIFI() {
        // Not necessary to implement
        return null;
    }

    @Override
    public String getVersionSDK() {
        // Not necessary to implement
        return null;
    }

    @Override
    public String getSerialNumber() {
        // Not necessary to implement
        return null;
    }

    @Override
    public void deleteDrone(ImageView drone) {
        stack.getChildren().remove(drone);
    }
}
