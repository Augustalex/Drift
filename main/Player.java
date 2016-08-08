package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
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
            BufferedImage img = this.getImage();
            AffineTransform at = new AffineTransform();
            at.translate(this.getX(), this.getY());
            at.rotate(Math.toRadians(this.angle));
            double wScale = this.getWidth() / img.getWidth();
            double hScale = this.getHeight() / img.getHeight();
            at.scale(wScale, hScale);
            at.translate(-img.getWidth()/2, img.getHeight());
            g.drawImage(this.getImage(), at, null);
        }
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
