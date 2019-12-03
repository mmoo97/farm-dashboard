package farm.dashboard;

import javafx.scene.image.ImageView;

public class Adapter implements SimulatedDrone, PhysicalDrone{

    SimulatedDroneFlight sim_drone;

    PhysicalDroneTello phys_drone;

    boolean is_sym;

    Adapter(PhysicalDroneTello drone){
        this.phys_drone = drone;
        this.is_sym = false;
    }

    Adapter(SimulatedDroneFlight drone) {
        this.sim_drone = drone;
        this.is_sym = true;
    }
    @Override
    public void beginProgram() {

        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.beginProgram();
        }
    }

    @Override
    public void endProgram() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.endProgram();
        }
    }

    @Override
    public void takeoff() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.takeoff();
        }
    }

    @Override
    public void land() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.land();
        }
    }

    @Override
    public void streamOn() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.streamOn();
        }
    }

    @Override
    public void streamOff() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.streamOff();
        }
    }

    @Override
    public void missionPadOn() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.missionPadOn();
        }
    }

    @Override
    public void missionPadOff() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.missionPadOff();
        }
    }

    @Override
    public void missionPadDirection(int param) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.missionPadDirection(param);
        }
    }

    @Override
    public void flyUpward(int up) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyForward(up);
        }
    }

    @Override
    public void flyDown(int down) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyDown(down);
        }
    }

    @Override
    public void flyForward(int front) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyForward(front);
        }
    }

    @Override
    public void flyBackward(int back) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyBackward(back);
        }
    }

    @Override
    public void flyLeft(int left) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyLeft(left);
        }
    }

    @Override
    public void flyRight(int right) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyRight(right);
        }
    }

    @Override
    public void gotoXYZ(int x, int y, int z, int speed) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.gotoXYZ(x, y, z, speed);
        }
    }

    @Override
    public void gotoMissionPadXYZ(int x, int y, int z, int speed, String ID) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.gotoMissionPadXYZ(x, y, z, speed, ID);
        }
    }

    @Override
    public void flyCurve(int x1, int y1, int z1, int x2, int y2, int z2, int speed) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyCurve(x1, y1, z1, x2, y2, z2, speed);
        }
    }

    @Override
    public void flyCurveMissionPad(int x1, int y1, int z1, int x2, int y2, int z2, int speed, String ID) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flyCurveMissionPad(x1, y1, z1, x2, y2, z2, speed,ID);
        }
    }

    @Override
    public void turnCW(int degrees) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.turnCW(degrees);
        }
    }

    @Override
    public void turnCCW(int degrees) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.turnCCW(degrees);
        }
    }

    @Override
    public void flip(String direction) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.flip(direction);
        }
    }

    @Override
    public void jumpMissionPad(int x, int y, int z, int speed, int yaw, String ID1, String ID2) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            jumpMissionPad(x, y, z,speed, yaw, ID1, ID2);
        }
    }

    @Override
    public void hoverInPlace(int seconds) throws InterruptedException {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.hoverInPlace(seconds);
        }
    }

    @Override
    public void stopInPlace() {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.stopInPlace();
        }
    }

    @Override
    public void setSpeed(int speed) {
        if(is_sym) {
            System.out.println("Simulated Drone");
        }else {
            phys_drone.setSpeed(speed);
        }
    }

    @Override
    public double getSpeed() {

        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getSpeed();
        }

    }

    @Override
    public int getBattery() {

        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getBattery();
        }

    }

    @Override
    public int getFlightTime() {

        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getFlightTime();
        }

    }

    @Override
    public int getHeight() {

        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getHeight();
        }

    }

    @Override
    public int getTemp() {

        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getTemp();
        }

    }

    @Override
    public int getAttitudePitch() {

        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getAttitudePitch();
        }

    }

    @Override
    public int getAttitudeRoll() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getAttitudeRoll();
        }

    }

    @Override
    public int getAttitudeYaw() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getAttitudeYaw();
        }

    }

    @Override
    public double getBarometer() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getBarometer();
        }

    }

    @Override
    public double getAccelerationX() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getAccelerationX();
        }

    }

    @Override
    public double getAccelerationY() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getAccelerationY();
        }

    }

    @Override
    public double getAccelerationZ() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getAccelerationZ();
        }

    }

    @Override
    public int getTOF() {
        if(is_sym) {
            return 0;
        }else {
            return phys_drone.getTOF();
        }

    }

    @Override
    public String getWIFI() {
        if(is_sym) {
            return "Simulated Drone";
        }else {
            return phys_drone.getWIFI();
        }

    }

    @Override
    public String getVersionSDK() {
        if(is_sym) {
            return "Simulated Drone";
        }else {
            return phys_drone.getVersionSDK();
        }

    }

    @Override
    public String getSerialNumber() {
        if(is_sym) {
            return "Simulated Drone";
        }else {
            return phys_drone.getSerialNumber();
        }

    }

    @Override
    public void scanFarm(int speed) {
        int length = 390; // orig 480
        int width = 70; // orig 90

        if(is_sym) {
            sim_drone.scanFarm(speed);
        }else {
            phys_drone.getBattery();

            //Forward one rep
            phys_drone.flyUpward(70);
            phys_drone.flyForward(length);
            phys_drone.turnCCW(90);
            phys_drone.flyForward(width);
            phys_drone.turnCCW(90);
            phys_drone.flyForward(length);

            //Backward one rep
            phys_drone.turnCW(90);
            phys_drone.flyForward(width);
            phys_drone.turnCW(90);
            phys_drone.flyForward(length);

            //Forward one rep
            phys_drone.turnCCW(90);
            phys_drone.flyForward(width);
            phys_drone.turnCCW(90);
            phys_drone.flyForward(length);

            //Backward one rep
            phys_drone.turnCW(90);
            phys_drone.flyForward(width);
            phys_drone.turnCW(90);
            phys_drone.flyForward(length);

            //return to base
            phys_drone.turnCW(135);
            phys_drone.flyForward(399);
            //phys_drone.flyForward(101);

        }
    }

    @Override
    public void flytoLocation(int speed) {
        if(is_sym) {
            sim_drone.flytoLocation(speed);
        }else {

        }
    }

    @Override
    public void deleteDrone(ImageView drone) {
        if(is_sym) {
            sim_drone.deleteDrone(drone);
        }else {

        }
    }
}
