package main.Ship.Interior;

import main.ActionCall;
import main.Ship.Cockpit.CockpitObject;

import java.util.ArrayList;

public class Interior {
    private int capacity;
    private ArrayList<InteriorObject> interiorObjects;

    public Interior(int capacity){
        this.capacity = capacity;
    }

    public boolean addObject(InteriorObject interiorObject){
        if(capacity - this.getAllObjectSize() >= interiorObject.getObjectSize()){
            interiorObjects.add(interiorObject);
            return true;
        }
        else
            return false;
    }

    public int getAllObjectSize(){
        int tempSize = 0;
        if(interiorObjects.size() > 0){
            for(int i = 0; i < interiorObjects.size(); i ++){
                tempSize += interiorObjects.get(i).getObjectSize();
            }
        }
        return tempSize;
    }
}
