package main;

import javafx.scene.transform.Affine;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

/**
 * Created by josef on 2016-08-08.
 */
public abstract class Renderable {
    private double posX;
    private double posY;
    private double height;
    private double width;

    public abstract void render(Graphics2D g);

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

}
