package main.Ship.ShipTypes;

import main.Ship.Engine.CatapillerBoatmotor;
import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Diesel;
import main.Ship.Ship;

public class TheTurtle extends Ship{
    //Name, Image Path, Width, Height, EngienRoomCapacity, CockpitCapacaty, AuxiliaryCapacaty, InteriorCapacaty
    protected TheTurtle(){
        super("The Turtle", "res/TheTurtle.png", 100, 100, 50, 50, 100, 50);

        CatapillerBoatmotor catapillerBoatmotor = new CatapillerBoatmotor();
        if(!this.addEngineObject(catapillerBoatmotor))
            System.out.println("ERROR: Can not add Catapiller Boat Motor to The Turtle");

        catapillerBoatmotor.addAvivableFuels();

        Tank tank = new Tank(300, 100);
        if(!this.addTank(tank))
            System.out.println("ERROR: Can not add a tank to The Turtle");

        Diesel disel = new Diesel();
        this.engineRoom.tanks.get(0).changeFuel(disel);
        int tempFuel = this.addFuel(disel);
        if(tempFuel == -3){
            System.out.println("ERROR: No tanks in The Turtle");
        }
        else if(tempFuel == -2){
            System.out.println("ERROR: No tanks with Disel in The Turtle");
        }
        else if(tempFuel == - 1){
            System.out.println("ERROR: Disel tank full in The Turtle");
        }


    }
}