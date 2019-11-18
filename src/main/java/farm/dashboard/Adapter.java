package farm.dashboard;

import javafx.scene.image.ImageView;

public class Adapter implements SimulatedDrone, PhysicalDrone{

    private SimulatedDroneFlight simdrone;

    private PhysicalDroneTello physdrone;

    boolean is_sim;

    public Adapter(){

    }

    public Adapter(PhysicalDroneTello drone) {
        this.physdrone = drone;
        this.is_sim = false;
    }

    public Adapter(SimulatedDroneFlight drone){
        this.simdrone = drone;
        this.is_sim = true;
    }

    @Override
    public void beginProgram() {

    }

    @Override
    public void endProgram() {

    }

    @Override
    public void takeoff() {
        if (is_sim) {
            // do sim takeoff
            simdrone.takeoff();
        } else {
            // do phys takeoff
        }
    }

    @Override
    public void land() {
        physdrone.land();
        //no need to add simdrone land function... it is virtual

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


    //no need to add simdrone to directional functions

    @Override
    public void flyUpward(int up) {
        physdrone.flyUpward(up);
    }

    @Override
    public void flyDown(int down) {
        physdrone.flyDown(down);
    }

    @Override
    public void flyForward(int front) {
        physdrone.flyForward(front);
    }

    @Override
    public void flyBackward(int back) {
        physdrone.flyBackward(back);
    }

    @Override
    public void flyLeft(int left) {
        physdrone.flyLeft(left);
    }

    @Override
    public void flyRight(int right) {
        physdrone.flyRight(right);
    }

    @Override
    public void gotoXYZ(int x, int y, int z, int speed) {
        physdrone.gotoXYZ(x, y, z, 4000);
        simdrone.gotoXYZ(x, y, z, 4000);
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
        physdrone.flip(direction);
    }

    @Override
    public void jumpMissionPad(int x, int y, int z, int speed, int yaw, String ID1, String ID2) {

    }

    @Override
    public void hoverInPlace(int seconds) throws InterruptedException {
        physdrone.hoverInPlace(5);
    }

    @Override
    public void stopInPlace() {
        physdrone.stopInPlace();
    }

    @Override
    public void setSpeed(int speed) {
        physdrone.setSpeed(5000);
    }

    @Override
    public double getSpeed() {
        return physdrone.getSpeed();
    }

    @Override
    public int getBattery() {
        return physdrone.getBattery();
    }

    @Override
    public int getFlightTime() {
        return physdrone.getFlightTime();
    }

    @Override
    public int getHeight() {
        return physdrone.getHeight();
    }

    @Override
    public int getTemp() {
        return physdrone.getTemp();
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
        return physdrone.getBarometer();
    }

    @Override
    public double getAccelerationX() {
        return physdrone.getAccelerationX();
    }

    @Override
    public double getAccelerationY() {
        return physdrone.getAccelerationY();
    }

    @Override
    public double getAccelerationZ() {
        return physdrone.getAccelerationZ();
    }

    @Override
    public int getTOF() {
        return physdrone.getTOF();
    }

    @Override
    public String getWIFI() {
        return physdrone.getWIFI();
    }

    @Override
    public String getVersionSDK() {
        return physdrone.getVersionSDK();
    }

    @Override
    public String getSerialNumber() {
        return physdrone.getSerialNumber();
    }

    @Override
    public void deleteDrone(ImageView drone) {

    }
}
