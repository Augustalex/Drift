package main.Ship.ShipTypes;

import main.Ship.Engine.CatapillerBoatmotor;
import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Diesel;
import main.Ship.Fuel.Fuel;
import main.Ship.Ship;

public class TheTurtle extends Ship{
    //Name, Image Path, Width, Height, Mass in Ton, EngienRoomCapacity, CockpitCapacaty, AuxiliaryCapacaty, InteriorCapacaty
    public TheTurtle() {
        super("The Turtle", "../../res/TheTurtle.png", 100, 40, 22, 50, 50, 100, 50);

        CatapillerBoatmotor catapillerBoatmotor = new CatapillerBoatmotor();
        if (!this.addEngineObject(catapillerBoatmotor))
            System.out.println("ERROR: Can not add Catapiller Boat Motor to The Turtle");

        catapillerBoatmotor.addAvivableFuels();

        Diesel diesel = new Diesel();
        Tank tank = new Tank(300, 100, diesel);
        if (!this.addTank(tank))
            System.out.println("ERROR: Can not add a tank to The Turtle");
    }
}