package main;

import main.Ship.ShipTypes.TheTurtle;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Created by August on 2016-08-08.
 */
public class Player extends TheTurtle{
    String name = "Player";

    Player(double x, double y, double width, double height){
        super();
        setPosition(x, y);
        setWidth(width);
        setHeight(height);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
