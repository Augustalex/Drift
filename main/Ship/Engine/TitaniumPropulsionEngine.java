package main.Ship.Engine;


public class TitaniumPropulsionEngine extends Engine{

    public TitaniumPropulsionEngine() {
        super("Titanium Propulsion Engine", 500, 10000, 500, 1000);
    }

    public void addAvivableFuels(){
        addAvivableFuelTypes("Disel");
        addAvivableFuelTypes("Kerosene");
    }
}
