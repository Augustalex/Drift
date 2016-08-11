package main.Ship.Engine.Tank;

import main.Ship.Fuel.Fuel;
import main.Ship.Hull;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class Tank extends Hull{
    public Fuel fuelType;
    public int tankSize;
    public int tankCapacity;

    public Tank(Fuel fuelType, int tankCapacity, int hullValue){
        this.setHullPoints(hullValue);
        this.fuelType = fuelType;
        this.tankCapacity = tankCapacity;
        this.addFuel(fuelType);
    }

    public int getTankSize(){
        return tankSize;
    }

    public String getFuelType(){
        return fuelType.name;
    }

    public boolean addFuel(Fuel fuel){
        if(this.fuelType.name == fuel.name && this.fuelType.index < 1.0){
            this.fuelType.index = 1.0;
            return true;
        }
        else
            return false;
    }

    public void changeFuel(Fuel fuel){
        this.fuelType = fuel;
        addFuel(fuel);
    }
}
