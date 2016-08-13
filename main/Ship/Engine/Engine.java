package main.Ship.Engine;

import main.Ship.Fuel.Fuel;
import main.Ship.Hull;

import java.util.ArrayList;

public class Engine extends Hull{
    private double tankSize;
    private double engineEfficiency;
    private double fuelPercent;
    private String name;
    private ArrayList<String> avivableFuelTypes;
    private int engineSize;

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
        return fuelPercent <= 0;
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

    public boolean addAvivableFuelTypes(String fuel){
        if(canUseFuel(fuel)) {
            avivableFuelTypes.add(fuel);
            return true;
        }
        else
            return false;
    }

    public boolean canUseFuel(String name){
        if(avivableFuelTypes.size() > 0){
            for(int i = 0; i < avivableFuelTypes.size(); i ++){
                if(avivableFuelTypes.get(i) == name){
                    return true;
                }
            }

            return false;
        }
        else
            return false;
    }

    public int getEngineSize(){
        return engineSize;
    }

    public void setAvivableFuelTypes(ArrayList<String> fuels){
        this.avivableFuelTypes = fuels;
    }

}
