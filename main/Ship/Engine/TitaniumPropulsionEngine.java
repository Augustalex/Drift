package main.Ship.Engine;


import main.Ship.Fuel.Diesel;
import main.Ship.Fuel.Kerosene;

public class TitaniumPropulsionEngine extends Engine{

    public TitaniumPropulsionEngine() {
        super("Titanium Propulsion Engine", 500, 500, 1000);
    }

    public void addAvivableFuels(){
        addAvivableFuelTypes(new Diesel(), 2.0);
        addAvivableFuelTypes(new Kerosene(), 3.0);
    }
}
