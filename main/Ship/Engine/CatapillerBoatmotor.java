package main.Ship.Engine;

import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Diesel;
import main.Ship.Fuel.Gasoline;
import main.Ship.Fuel.Kerosene;

public class CatapillerBoatmotor extends Engine {
    public CatapillerBoatmotor() {
        super("Caterpiller Ship Engine, 520 kW", 100, 400, 25);
    }

    public void addAvivableFuels(){
        this.addAvivableFuelTypes(new Diesel(), 0.8);
        this.addAvivableFuelTypes(new Gasoline(), 0.5);
        this.addAvivableFuelTypes(new Kerosene(), 1.0);
    }
}