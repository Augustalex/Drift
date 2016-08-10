package main.Ship.Engine;

import main.Ship.Hull;

import java.util.ArrayList;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class Engine extends Hull{
    private double tankSize;
    private double engineEfficiency;
    private double fuelPercent;
    private String name;
    private ArrayList<String> avivableFuelTypes;
    int engineSize;

    Engine(String name, double efficiency, double tankSize, int hullValue, int engineSize){
        super(hullValue);
        this.engineEfficiency = efficiency;
        this.name = name;
        this.tankSize = tankSize;
        this.engineSize = engineSize;
    }

    public double getEngineEfficiency(){
        return engineEfficiency;
    }
    public void setEngineEfficiency(double x){
        engineEfficiency = x;
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

    public void addAvivableFuelTypes(String fuel){
        avivableFuelTypes.add(fuel);
    }

    public boolean canUseFuel(String name){
        for(int i = 0; i < avivableFuelTypes.size(); i ++){
            if(avivableFuelTypes.get(i) == name){
                return true;
            }
        }

        return false;
    }

    public int getEngineSize(){
        return engineSize;
    }

}
