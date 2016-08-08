package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by August on 2016-08-08.
 */
public class Player extends Movable{
    String name = "Player";

    Player(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g){
        g.setColor(Color.orange);
        g.fill(new Area(new Arc2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 0.0, 100.0, Arc2D.CHORD)));

        BufferedImage img = null;
        try {
            img = ImageIO.read(new File("../images/Penguin.png"));
        }
        catch(IOException e){
            System.out.println(e);
        }


    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
