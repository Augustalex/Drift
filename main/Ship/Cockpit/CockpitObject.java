package main.Ship.Cockpit;

import main.Ship.Hull;

/**
 * Created by josef on 2016-08-11.
 */
public class CockpitObject extends Hull {
    private int objectSize;

    CockpitObject(int objectSize, int hullPoints){
        this.setHullPoints(hullPoints);
        this.objectSize = objectSize;
    }

    public int getObjectSize(){
        return objectSize;
    }
}
