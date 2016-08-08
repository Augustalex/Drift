package main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-09.
 */
public abstract class ActionCall extends Movable {

    public static ArrayList<ActionCall> actionCalls;

    ActionCall(double posX, double posY, double width, double height){
        super(posX, posY, width, height);

    }

    void openActionCalls(){
        ActionCall.actionCalls.add(this);
    }
    void closeActionCalls(){
        ActionCall.actionCalls.remove(this);
    }

}
