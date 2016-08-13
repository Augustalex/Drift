package main.Ship;

import main.Ship.ShipTypes.Barrel;
import main.Ship.ShipTypes.TheTurtle;
import main.Ship.ShipTypes.Truckmania;

/**
 * Created by josef on 2016-08-13.
 */
public class ShipFactory {
    public ShipFactory(){

    }

    public Ship newShip(String shipName){
        switch (shipName){
            case "The Turtle":
                return new TheTurtle();
            case "Truckmania":
                return new Truckmania();
            default:
                System.out.println("No such ship: " + shipName);
                return new Barrel();

        }
    }
}
