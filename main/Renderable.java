package main;

import javafx.scene.transform.Affine;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.*;
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

    private boolean inView = false;

    BufferedImage img = null;

    //public static int nLayers = 2;
    //public static ArrayList<ArrayList<Renderable>> list = new ArrayList<ArrayList<Renderable>>();
    //public static boolean isInstantiated = false;

    public static ArrayList<Renderable> list = new ArrayList<Renderable>();

    Renderable(double x, double y, double width, double height) {
        this.posX = x;
        this.posY = y;
        this.width = width;
        this.height = height;

        /*if(!Renderable.isInstantiated){
            for(int i = 0; i < Renderable.nLayers; i++){
                Renderable.list.add(new ArrayList<Renderable>());
            }
            Renderable.isInstantiated = true;
        }

        if(this instanceof Map)
            Renderable.list.get(0).add(this);
        else
            Renderable.list.get(1).add(this);*/

        Renderable.list.add(this);
    }

    public abstract void render(Graphics2D g);

    public abstract void render(Graphics2D g, double xOffset, double yOffset);

    public abstract void update(double delta);

    public void loadImage(String path) {
        BufferedImage img;

        try {
            System.out.println(this.getClass() + "." + this.getClass().getResource(path));
            img = ImageIO.read(this.getClass().getResource(path));
            System.out.println("Trying to print image2.");
            this.img = img;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public BufferedImage getImage() {
        return this.img;
    }

    public double getX() {
        return this.posX;
    }

    public double getY() {
        return this.posY;
    }

    public double getHeight() {
        return height;
    }

    public double getWidth() {
        return width;
    }

    public void setX(double X) {
        this.posX = X;
    }

    public void setY(double Y) {
        this.posY = Y;
    }

    public void setHeight(double tempHeight) {
        this.height = tempHeight;
    }

    public void setWidth(double tempWidth) {
        this.width = tempWidth;
    }

    public void setPosition(double x, double y) {
        this.posY = y;
        this.posX = x;
    }

    public Point2D getPosition(){
        return (new Point2D.Double(this.getX(), this.getY()));
    }

    public void destroy() {
        Renderable.list.remove(this);
    }

    public Area getRectangleArea() {
        return (new Area(new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight())));
    }

    public Area getCircleArea() {
        return (new Area(new Arc2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight(), 0, 360, Arc2D.OPEN)));
    }

    public Rectangle2D getRectangle() {
        return (new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight()));

    }

    public Rectangle2D getRectangle(double xOffset, double yOffset){
        return (new Rectangle2D.Double(this.getX()-xOffset, this.getY()-yOffset, this.getWidth(), this.getHeight()));
    }

    public Shape getShape(double xOffset, double yOffset){
        return this.getRectangle();
    }

    public void toggleInView(){
        this.inView = !(this.inView);
    }

    public boolean isInView(){
        return this.inView;
    }
}