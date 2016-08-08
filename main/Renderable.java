package main;

import javafx.scene.transform.Affine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-08.
 */
public abstract class Renderable {
    private double posX;
    private double posY;
    private double height;
    private double width;

    BufferedImage img = null;

    public static ArrayList<Renderable> list = new ArrayList<Renderable>();

    Renderable(double x, double y, double width, double height){
        this.posX = x;
        this.posY = y;
        this.width = width;
        this.height = height;

        Renderable.list.add(this);
    }

    public abstract void render(Graphics2D g);

    public BufferedImage loadImage(String path){

        try {
            img = ImageIO.read(this.getClass().getResource("Penguin.png"));
            System.out.println("Trying to print image2.");
        }
        catch(IOException e){
            System.out.println(e);
        }

        return this.img;
    }

    public BufferedImage getImage(){
        return this.img;
    }

    public double getX(){
        return this.posX;
    }

    public double getY(){
        return this.posY;
    }

    public double getHeight(){
        return height;
    }

    public double getWidth(){
        return width;
    }

    public void setX(double X){
        this.posX = X;
    }

    public void setY(double Y){
        this.posY = Y;
    }

    public void setHeight(double tempHeight){
        this.height = tempHeight;
    }

    public void setWidth(double tempWidth){
        this.width = tempWidth;
    }

    public void setPosition(double x, double y){
        this.posY = y;
        this.posX = x;
    }

}
