package main.Ship.Engine;

import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Fuel;
import main.Ship.Hull;

import java.util.ArrayList;

public class Engine extends Hull {
    private double engineEfficiency;
    private String name;
    private ArrayList<Fuel> avivableFuelTypes = new ArrayList<>();
    private int engineSize;

    Engine(String name, double efficiency, int hullValue, int engineSize) {
        super(hullValue);
        this.engineEfficiency = efficiency;
        this.name = name;
        this.engineSize = engineSize;
    }

    public double getEngineEfficiency() {
        return engineEfficiency;
    }

    public void setEngineEfficiency(double x) {
        engineEfficiency = x;
    }


    public String getName() {
        return name;
    }

    public boolean addAvivableFuelTypes(Fuel fuel) {
        if (canUseFuel(fuel.name)) {
            avivableFuelTypes.add(fuel);
            return true;
        } else
            return false;
    }

    public ArrayList<Fuel> getAvivableFuelTypes(){
        return avivableFuelTypes;
    }

    public boolean addAvivableFuelTypes(Fuel fuel, double index){
        if (canUseFuel(fuel.name)) {
            fuel.index = index;
            avivableFuelTypes.add(fuel);
            return true;
        } else
            return false;
    }

    public boolean canUseFuel(String name) {
        if (avivableFuelTypes.size() > 0) {
            for (int i = 0; i < avivableFuelTypes.size(); i++) {
                if (avivableFuelTypes.get(i).name == name) {
                    return true;
                }
            }

            return false;
        } else
            return false;
    }

    public int getEngineSize() {
        return engineSize;
    }
}

