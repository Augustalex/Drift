package main.Logic;

import main.*;

import javax.xml.soap.Text;
import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 * Created by August on 2016-08-09.
 */
public class MovableLogic {

    public void togglePlayerMotionKey(Player player, char key, boolean toggleOn){
        switch(key){
            case 'w':
                player.isAccelerating = toggleOn;
                break;
            case 's':
                player.isDecelerating = toggleOn;
                break;
            case 'a':
                player.isTurning = toggleOn;
                player.isTurningLeft = toggleOn;
                break;
            case 'd':
                player.isTurning = toggleOn;
                player.isTurningLeft = !toggleOn;
                break;
        }
    }

    public void updatePlayerPosition(Player player, Map map, double delta){
        Point2D newPos = player.getNewPosition(delta);

        if(map.positionOutOfBounds(newPos))
            return;

        Rectangle2D view = map.getView();

        //Point2D center = new Point2D.Double(view.getX() + (view.getWidth()/2), view.getY() + (view.getHeight()/2));

        //double distance = Math.hypot(center.getX()-newPos.getX(), center.getY()-newPos.getY());
        Chunk currentChunk = map.findChunk(newPos.getX(), newPos.getY());

        TextBox.standardSize = 24;
        //DebugInfo.textBoxes.add(new TextBox(String.format("DISTANCE: %f", distance), 100, 100, Color.WHITE));
        DebugInfo.textBoxes.add(new TextBox(String.format("PLAYER: %f, %f", newPos.getX(), newPos.getY()), 100, 130, Color.RED));
        DebugInfo.textBoxes.add(new TextBox(String.format("VIEW: %f, %f", view.getX(), view.getY()), 100,160, Color.RED));
        DebugInfo.textBoxes.add(new TextBox(String.format("CHUNK: %d, %d", currentChunk.getChunkX(), currentChunk.getChunkY()), 100, 190, Color.RED));
        /*if(distance > 500){
            double xDiff = newPos.getX() - center.getX();
            double yDiff = newPos.getY() - center.getY();
            map.moveView(xDiff, yDiff);
        }*/

        if(map.positionOutOfView(newPos))
            map.moveViewQuadrant(newPos);


        map.updateObjectChunk(player, newPos);
        player.update(delta);
    }

    public void updateMovablePosition(Movable movable, Map map, double delta){
        Point2D newPos = movable.getNewPosition(delta);
        if(newPos.getX() >= map.getWidth() || newPos.getX() <= 0)
            movable.stunMovement();
        else if(newPos.getY() >= map.getHeight() || newPos.getY() <= 0)
            movable.stunMovement();

        movable.update(delta);

    }

    public void movableInView(Movable movable, Map map){
        if(map.getCurrentViewArea().contains(movable.getRectangle()))
            if(!movable.isInView())
                movable.toggleInView();
    }

    public void checkPlayerBounds(Player player, Map map){
    }
}
