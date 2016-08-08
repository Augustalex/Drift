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
        if(this.getImage() != null){
            g.drawImage(this.getImage(), (int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight(), null);
        }
        else{
            System.out.println("ERROR: No picture available.");
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
