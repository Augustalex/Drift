package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;

/**
 * Created by August on 2016-08-08.
 */
public abstract class Movable extends Renderable {
    double speed = 0;
    double rotationMomentum = 0;
    double angle = 0;

    double acceleration = 1;
    double deceleration = 1;
    double rotationSpeed = 10;

    boolean isAccelerating = false;
    boolean isDecelerating = false;
    boolean isTurning = false;
    boolean isTurningLeft = false;

    Movable(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public void move(double delta){
        this.setX(this.getX() + (this.speed * Math.cos(Math.toRadians(this.angle))));
        this.setY(this.getY() + (this.speed * Math.sin(Math.toRadians(this.angle))));
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
        this.angle += this.rotationSpeed * delta;
    }

    public void turnRight(double delta){
        this.angle -= this.rotationSpeed * delta;
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
}