package main.Logic;

import main.Ship.Engine.Engine;
import main.Ship.Engine.Tank.Tank;
import main.Ship.Ship;

import java.security.spec.ECGenParameterSpec;

public class ShipLogic {
    public ShipLogic(){

    }

    public double usageProcent = 0.05;

    public double fuleToAcceleration(Ship ship){
        double acceleration;

        for (int i = 0; i < ship.engineRoom.getEnginesArray().size(); i ++){
            Engine engine = ship.engineRoom.getEnginesArray().get(i);

            for(int e = 0; e < ship.engineRoom.getTanksArray().size(); e ++){
                Tank tank = ship.engineRoom.getTanksArray().get(e);
                if(engine.canUseFuel(tank.fuelType.name)){
                    useFuel(engine, tank);
                }
            }
        }
    }

    private double useFuel(Engine engine, Tank tank){

    }

}
