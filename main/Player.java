package main;

import main.Ship.Ship;
import main.Ship.ShipFactory;
import main.Ship.ShipTypes.TheTurtle;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Created by August on 2016-08-08.
 */
public class Player{
    ShipFactory shipYard = new ShipFactory();
    public Ship playerShip;
    private String name;

    Player(double x, double y){
        playerShip = shipYard.newShip("The Turtle");
        playerShip.setPosition(x, y);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
