package main.Ship.Cockpit;

import java.util.ArrayList;

public class Cockpit {
    private int capacity;
    private ArrayList<CockpitObject> cockpitObjectsobjects;

    public Cockpit(int capacity){
        this.capacity = capacity;
    }

    public boolean addObject(CockpitObject cockpitObject){
        if(capacity - this.getAllObjectSize() >= cockpitObject.getObjectSize()){
            cockpitObjectsobjects.add(cockpitObject);
            return true;
        }
        else
            return false;
    }

    public int getAllObjectSize(){
        int tempSize = 0;
        if(cockpitObjectsobjects.size() > 0){
            for(int i = 0; i < cockpitObjectsobjects.size(); i ++){
                tempSize += cockpitObjectsobjects.get(i).getObjectSize();
            }
        }
        return tempSize;
    }
}
