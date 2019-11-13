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

    }

    @Override
    public void endProgram() {

    }

    @Override
    public void takeoff() {

    }

    @Override
    public void land() {

    }

    @Override
    public void streamOn() {

    }

    @Override
    public void streamOff() {

    }

    @Override
    public void missionPadOn() {

    }

    @Override
    public void missionPadOff() {

    }

    @Override
    public void missionPadDirection(int param) {

    }

    @Override
    public void flyUpward(int up) {

    }

    @Override
    public void flyDown(int down) {

    }

    @Override
    public void flyForward(int front) {

    }

    @Override
    public void flyBackward(int back) {

    }

    @Override
    public void flyLeft(int left) {

    }

    @Override
    public void flyRight(int right) {

    }

    @Override
    public void gotoXYZ(int x, int y, int z, int speed) {

    }

    @Override
    public void gotoMissionPadXYZ(int x, int y, int z, int speed, String ID) {

    }

    @Override
    public void flyCurve(int x1, int y1, int z1, int x2, int y2, int z2, int speed) {

    }

    @Override
    public void flyCurveMissionPad(int x1, int y1, int z1, int x2, int y2, int z2, int speed, String ID) {

    }

    @Override
    public void turnCW(int degrees) {

    }

    @Override
    public void turnCCW(int degrees) {

    }

    @Override
    public void flip(String direction) {

    }

    @Override
    public void jumpMissionPad(int x, int y, int z, int speed, int yaw, String ID1, String ID2) {

    }

    @Override
    public void hoverInPlace(int seconds) throws InterruptedException {

    }

    @Override
    public void stopInPlace() {

    }

    @Override
    public void setSpeed(int speed) {

    }

    @Override
    public double getSpeed() {
        return 0;
    }

    @Override
    public int getBattery() {
        return 0;
    }

    @Override
    public int getFlightTime() {
        return 0;
    }

    @Override
    public int getHeight() {
        return 0;
    }

    @Override
    public int getTemp() {
        return 0;
    }

    @Override
    public int getAttitudePitch() {
        return 0;
    }

    @Override
    public int getAttitudeRoll() {
        return 0;
    }

    @Override
    public int getAttitudeYaw() {
        return 0;
    }

    @Override
    public double getBarometer() {
        return 0;
    }

    @Override
    public double getAccelerationX() {
        return 0;
    }

    @Override
    public double getAccelerationY() {
        return 0;
    }

    @Override
    public double getAccelerationZ() {
        return 0;
    }

    @Override
    public int getTOF() {
        return 0;
    }

    @Override
    public String getWIFI() {
        return null;
    }

    @Override
    public String getVersionSDK() {
        return null;
    }

    @Override
    public String getSerialNumber() {
        return null;
    }
}
