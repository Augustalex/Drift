package main.Logic;

import main.Map;
import main.Player;

import java.awt.geom.Point2D;

/**
 * Created by August on 2016-08-09.
 */
public class MovableLogic {

    public void togglePlayerMotionKey(Player player, char key, boolean toggleOn){
        System.out.println("Player: " + key + ", " + toggleOn);
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
        if(newPos.getX() >= map.getWidth() || newPos.getX() <= 0)
            player.stunMovement();
        else if(newPos.getY() >= map.getHeight() || newPos.getY() <= 0)
            player.stunMovement();

        player.update(delta);
    }

    public void checkPlayerBounds(Player player, Map map){
    }
}
