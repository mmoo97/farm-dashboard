package farm.dashboard;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.util.Duration;

import static farm.dashboard.AppLauncher.app;

public class SimulatedDroneFlight implements SimulatedDrone {

    @FXML
    private void animateItem(){
        //Todo: Expand animation functionality beyond just scanning
//        double startX = item.location_x;
//        double startY = item.location_y;
//        double endX = 600.0; //x;
//        double endY = 600.0; //y;

        StackPane stack = (StackPane) app.getStage().getScene().lookup("#stack");

        ImageView car = new ImageView();
        car.setImage(new Image("farm.dashboard/drone.png"));
        car.setX(0);
        car.setY(0);
        car.setTranslateX(0.00);
        car.setTranslateY(0.00);
        car.setRotate(90);

        PathElement[] path =
                {
                        new MoveTo(0,0),
                        new LineTo(0,-100),
                        new ArcTo(100,100,0, -100, -200, false, false),
                        new LineTo(-200,-200),
                        new ArcTo(100,100,0, -250, -100, false, false),
                        new LineTo(-250,150),
                        new ArcTo(100,100,0, -150, 250, false, false),
                        new LineTo(300,250),
                        new ArcTo(100,100,0, 400, 100, false, false),
                        new LineTo(400, -200),
                        new ClosePath()
                };

        Path road = new Path();
        road.setStroke(Color.WHITE);
        road.setStrokeWidth(75);
        road.getElements().addAll(path);

        PathTransition anim = new PathTransition();
        anim.setNode(car);
        anim.setPath(road);
        anim.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        anim.setInterpolator(Interpolator.LINEAR);
        anim.setDuration(new Duration(6000));
        anim.setCycleCount(Timeline.INDEFINITE);

        Group root = new Group();
        root.getChildren().addAll(road, car);
        root.setTranslateX(50);
        root.setTranslateY(50);
        stack.getChildren().addAll(car);
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
    public void missionPadDirection(int param){

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
}
