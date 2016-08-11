package main.Ship.Engine;

import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Fuel;

import java.util.ArrayList;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class EngineRoom {

    private int capacity;
    public ArrayList<Engine> engine;
    public ArrayList<Tank> tanks;

    public EngineRoom(int capacity){
        this.capacity = capacity;
    }

    public int getAllObjectSize(){
        int tempSize = 0;
        for(int i = 0; i < engine.size(); i ++){
            tempSize += engine.get(i).getEngineSize();
        }
        for(int i = 0; i < tanks.size(); i ++){
            tempSize += tanks.get(i).tankSize;
        }

        return tempSize;
    }

    public boolean addEngine(Engine engine){
        if(capacity - this.getAllObjectSize() >= engine.getEngineSize()){
            this.engine.add(engine);
            return true;
        }
        else
            return false;

    }

    public boolean addTank(Tank tank){
        if(capacity - this.getAllObjectSize() >= tank.getTankSize()){
            this.tanks.add(tank);
            return true;
        }
        else
            return false;
    }

    public int addFuel(Fuel fuel){
        if(tanks.size() < 1)
            return -3;
        for(int i = 0; i < tanks.size(); i ++){
            if(tanks.get(i).fuelType.name == fuel.name){
                if(tanks.get(i).fuelType.index < 1) {
                    tanks.get(i).addFuel(fuel);
                    return 1;
                }
                else
                    return -1;
            }
        }

        return -2;
    }


}
