package main.Ship.Interior;

import main.Ship.Hull;

/**
 * Created by josef on 2016-08-11.
 */
public class InteriorObject extends Hull{
    private String name;
    private int objectSize;

    InteriorObject(String name, int objectSize, int hullPoints){
        this.name = name;
        this.objectSize = objectSize;
        this.setHullPoints(hullPoints);
    }

    public String getName(){
        return name;
    }

    public int getObjectSize(){
        return objectSize;
    }

}
