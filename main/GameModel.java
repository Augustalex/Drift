package main;

import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

/**
 * Created by josef on 2016-08-08.
 */
public class GameModel implements Updates{

    private GameLogic logic;

    private Map map;
    private Player player;

    GameModel(int screenWidth, int screenHeight){
        this.logic = new GameLogic();

        System.out.println(screenWidth + ", " + screenHeight);
        this.map = new Map(screenWidth, screenHeight);
        this.map.setToCurrentMap();
        this.player = new Player(100, 100, 160, 60);
        this.player.loadImage("res/TheTurtle.png");

        Dialog dialog = new Dialog(300, 100, 200, 100, true);

        Page page = new Page(0, 0, 200, 50);
        page.addTextBox(new TextBox(0, 0, 100, 50));
        dialog.addPage(page);

    }

    @Override
    public void update(InputEvent e) {
        System.out.println("New event: " + e);

        if(e instanceof KeyEvent){
            char key = ((KeyEvent) e).getKeyChar();
            boolean toggleOn = false;

            if(e.getID() == KeyEvent.KEY_PRESSED)
                toggleOn = true;

            System.out.println(e.getID() + " : " + KeyEvent.KEY_PRESSED);

            switch(key){
                case 'w':case 'a':case 's':case 'd':
                    this.logic.movable.togglePlayerMotionKey(this.player, key, toggleOn);
            }
        }
    }

    public void update(double delta){
        this.map.update(delta);
        this.logic.movable.updatePlayerPosition(this.player, this.map, delta);

    }
}
