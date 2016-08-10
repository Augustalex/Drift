package main.Ship.Engine;

import java.util.ArrayList;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class EngineRoom {

    private int capacity;
    public ArrayList<Engine> engine;


    public int getAllObjectSize(){
        int tempSize = 0;
        for(int i = 0; i < engine.size(); i ++){
            tempSize += engine.get(i).getEngineSize();
        }

        return tempSize;
    }


}
