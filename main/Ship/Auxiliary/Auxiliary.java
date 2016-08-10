package main.Ship.Auxiliary;

import main.Ship.Hull;

import java.util.ArrayList;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class Auxiliary {

    private int capacity;
    private ArrayList<AuxiliarieObject> auxiliarieObjects;

    Auxiliary(int capacity){
        this.capacity = capacity;

    }

    public boolean addObject(AuxiliarieObject auxiliarieObject){

        if(capacity - this.getAllObjectSize() >= auxiliarieObject.getObjectSize()){
            auxiliarieObjects.add(auxiliarieObject);
            return true;
        }
        else{
            return false;
        }

    }

    public ArrayList<AuxiliarieObject> getFullList(){
        return auxiliarieObjects;
    }

    public int getAllObjectSize(){
        int tempSize = 0;
        for(int i = 0; i < auxiliarieObjects.size(); i ++){
            tempSize += auxiliarieObjects.get(i).getObjectSize();
        }

        return tempSize;
    }


}
