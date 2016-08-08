package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

/**
 * Created by August on 2016-08-08.
 */
public class Movable extends Renderable {
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

    public void move(){
        this.setX(this.getX() + (this.speed * Math.cos(Math.toRadians(this.angle))));
        this.setY(this.getY() + (this.speed * Math.sin(Math.toRadians(this.angle))));
    }

    public void turn(){
        this.angle += this.rotationMomentum;
    }

    public void accelerate(){
        this.speed += this.acceleration;
    }

    public void decelerate(){
        this.speed -= this.deceleration;
    }

    public void turnLeft(){
        this.angle += this.rotationSpeed;
    }

    public void turnRight(){
        this.angle -= this.rotationSpeed;
    }

    public void update(){
        if(this.isTurning)
            if(this.isTurningLeft)
                this.turnLeft();
            else
                this.turnRight();

        if(this.isAccelerating)
            this.accelerate();
        else if(this.isDecelerating)
            this.decelerate();

        if(speed > 0 || speed < 0)
            this.move();
    }

    public void setAngle(double angle){
        this.angle = angle;
    }

    public double getAngle(double angle){
        return this.angle;
    }



    @Override
    public void render(Graphics2D g) {

    }
}