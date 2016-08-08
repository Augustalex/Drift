package main;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;

/**
 * Created by August on 2016-08-08.
 */
public class Player extends Movable{
    String name = "Player";

    Player(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.cyan);
        g.fill(new Area(new Arc2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 0.0, 100.0, Arc2D.CHORD)));
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
