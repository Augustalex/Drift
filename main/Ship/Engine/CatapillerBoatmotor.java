package main.Ship.Engine;

public class CatapillerBoatmotor extends Engine {
    public CatapillerBoatmotor() {
        super("Caterpiller Ship Engine, 520 kW", 100, 100, 400, 100);

        this.addAvivableFuelTypes("Diesel");
        this.addAvivableFuelTypes("Gasoline");
        this.addAvivableFuelTypes("Kerosene");
    }
}