package main.Ship.ShipTypes;

import main.Ship.Engine.Tank.Tank;
import main.Ship.Engine.TitaniumPropulsionEngine;
import main.Ship.Fuel.Fuel;
import main.Ship.Fuel.Kerosene;
import main.Ship.Ship;


public class Truckmania extends Ship {
    public Truckmania(){
        super("Truckmania", "../../res/Truckmania.png", 500, 100, 200, 100, 1000, 100);

        TitaniumPropulsionEngine titaniumPropulsionEngine = new TitaniumPropulsionEngine();
        if(!this.addEngineObject(titaniumPropulsionEngine))
            System.out.println("ERROR: Can not add Titanium Propulsion Engine to Truckmania");

        titaniumPropulsionEngine.addAvivableFuels();

        Kerosene kerosene = new Kerosene();
        Tank tank = new Tank(10000, 200, kerosene);
        int tempFuel = this.addFuel(kerosene);
        if(tempFuel == -3)
            System.out.println("ERROR: No tanks in Truckmania");
        else if(tempFuel == -2)
            System.out.println("ERROR: No tanks with Kerosene in Truckmania");
        else if(tempFuel == -1)
            System.out.println("ERROR: Kerosene tank full in Truckmania");





    }
}
