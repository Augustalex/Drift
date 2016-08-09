package main.Logic;

import main.Map;
import main.Movable;
import main.Player;

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
        //map.moveViewToChunk(player.getNewPosition(delta));
        /*Point2D newPos = player.getNewPosition(delta);
        Rectangle2D view = map.getView();
        map.moveView(newPos.getX() + (newPos.getX()-view.getX()), newPos.getY() + (newPos.getY()-view.getY()));*/
        /*
        Point2D newPos = player.getNewPosition(delta);
        if(newPos.getX() >= map.getWidth() || newPos.getX() <= 0)
            map.moveView(newPos.getX(), newPos.getY());
        else if(newPos.getY() >= map.getHeight() || newPos.getY() <= 0)
            map.moveView(newPos.getX(), newPos.getY());
*/
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
