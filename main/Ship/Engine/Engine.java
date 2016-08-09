package main.Ship.Engine;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class Engine {
    private double tankSize;
    private double efficiency;
    private double fuelPercent;
    private String name;

    Engine(String name, double efficiency, double tankSize){
        this.efficiency = efficiency;
        this.name = name;
        this.tankSize = tankSize;
    }

    public double getEfficiency(){
        return efficiency;
    }
    public void setEfficiency(double x){
        efficiency = x;
    }

    public double getFuelPercent(){
        return fuelPercent;
    }

    public void setFuel(double n){
        this.fuelPercent = n;
    }

    public void addFuel(double n){
        this.fuelPercent += n;
        if(fuelPercent > 1.0){
            fuelPercent = 1.0;
        }
    }

    public void removeFuel(double n){
        this.fuelPercent -= n;
        if(fuelPercent < 0){
            fuelPercent = 0;
        }
    }

    public boolean tankEmpty(){
        if (fuelPercent > 0) {
            return false;
        } else {
            return true;
        }
    }

    public String getName(){
        return name;
    }

    public double getTankSize(){
        return tankSize;
    }

    public void setTankSize(double n){
        tankSize = n;
    }


}
