package main.Ship.Auxiliary;

import main.Ship.Hull;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class AuxiliarieObject extends Hull {
    private int objectSize;
    private String name;

    AuxiliarieObject(String name, int objectSize, int hullPoints){
        super(hullPoints);
        this.name = name;
        this.objectSize = objectSize;
    }

    public int getObjectSize(){
        return objectSize;
    }
    public String getName(){
        return name;
    }
}
