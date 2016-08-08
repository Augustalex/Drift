package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;

/**
 * Created by August on 2016-08-08.
 */
public class Movable extends Renderable {
    double speed;
    double rotationMomentum;
    double angle;

    double acceleration;
    double deceleration;
    double rotationSpeed;

    boolean isAccelerating;
    boolean isDecelerating;
    boolean isTurning;
    boolean isTurningLeft;

    public void move(){
        this.setX(this.getX() + (this.speed * Math.cos(Math.toRadians(this.angle))));
        this.setY(this.getY() + (this.speed * Math.sin(Math.toRadians(this.angle)));
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

    @Override
    public void render(Graphics2D g) {

    }
}