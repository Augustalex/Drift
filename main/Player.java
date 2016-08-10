package main;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

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

    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {
        if(this.getImage() != null){
            AffineTransform backup = g.getTransform();
            AffineTransform trans = this.getTransformation(xOffset, yOffset);
            g.transform(trans);
            g.drawImage(this.getImage(), (int)(this.getX()-xOffset), (int)(this.getY()-yOffset), null);
            g.setTransform(backup);
        }

        String info = String.format("[ X:%f, Y:%f ] [ CX:%d, CY:%d ] [ SPEED:%f, ROTATION:%f, ANGLE:%f ]", this.getX(), this.getY(), this.getChunkPosition().x, this.getChunkPosition().y, this.getSpeed(), this.getRotationMomentum(), this.getAngle());
        DebugInfo.textBoxes.add(new TextBox(info, 50, 50, Color.green));
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
