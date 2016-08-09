package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Created by August on 2016-08-08.
 */
public abstract class Movable extends Renderable {
    private double speed = 0;
    private double rotationMomentum = 0;
    private double angle = 0;

    private double acceleration = 0.1;
    private double deceleration = 0.2;
    private double rotationSpeed = 1;

    public boolean isAccelerating = false;
    public boolean isDecelerating = false;
    public boolean isTurning = false;
    public boolean isTurningLeft = false;

    Movable(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public void move(double delta){
        /*this.setX(this.getX() + (this.speed * Math.cos(Math.toRadians(this.angle))));
        this.setY(this.getY() + (this.speed * Math.sin(Math.toRadians(this.angle))));*/

        Point2D newPos = getNewPosition(delta);
        this.setX(newPos.getX());
        this.setY(newPos.getY());
    }

    public Point2D getNewPosition(double delta){
        double x = this.getX() + (this.speed * Math.cos(Math.toRadians(this.angle)));
        double y = this.getY() + (this.speed * Math.sin(Math.toRadians(this.angle)));

        return (new Point2D.Double(x, y));
    }

    public void turn(double delta){
        this.angle += this.rotationMomentum * delta;
    }

    public void accelerate(double delta){
        this.speed += this.acceleration * delta;
    }

    public void decelerate(double delta){
        this.speed -= this.deceleration * delta;
    }

    public void turnLeft(double delta){
        this.angle -= this.rotationSpeed * delta;
    }

    public void turnRight(double delta){
        this.angle += this.rotationSpeed * delta;
    }

    public void update(double delta){
        if(this.isTurning)
            if(this.isTurningLeft)
                this.turnLeft(delta);
            else
                this.turnRight(delta);

        if(this.isAccelerating)
            this.accelerate(delta);
        else if(this.isDecelerating)
            this.decelerate(delta);

        if(speed > 0 || speed < 0)
            this.move(delta);
    }

    public void setAngle(){
        this.angle = angle;
    }

    public double getAngle(){
        return this.angle;
    }

    public void stunMovement(){
        this.speed = this.speed * -1 * 0.2;
        this.rotationMomentum = 0;
    }
}