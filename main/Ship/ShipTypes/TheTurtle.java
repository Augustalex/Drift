package main.Ship.ShipTypes;

import main.Ship.Engine.CatapillerBoatmotor;
import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Diesel;
import main.Ship.Ship;

public class TheTurtle extends Ship{
    //Name, Image Path, Width, Height, EngienRoomCapacity, CockpitCapacaty, AuxiliaryCapacaty, InteriorCapacaty
    TheTurtle(){
        super("The Turtle", "res/TheTurtle.png", 100, 100, 50, 50, 100, 50);

        CatapillerBoatmotor catapillerBoatmotor = new CatapillerBoatmotor();
        if(!this.addEngineObject(catapillerBoatmotor))
            System.out.println("ERROR: Can not add Catapiller Boat Motor to The Turtle");

        Diesel disel = new Diesel();
        Tank tank = new Tank(disel, 300, 100);
        if(!this.addTank(tank))
            System.out.println("ERROR: Can not add a tank with diesel to The Turtle");

    }
}