package main;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;

/**
 * Created by josef on 2016-08-08.
 */
public class GameModel implements Updates{

    private GameLogic logic;

    private Map map;
    private Player player;
    private Dialog dialog;
    GameModel(int screenWidth, int screenHeight){
        this.logic = new GameLogic();

        System.out.println(screenWidth + ", " + screenHeight);
        this.map = new Map(screenWidth, screenHeight);
        this.map.setToCurrentMap();
        this.player = new Player(100, 100, 160, 60);
        this.player.loadImage("res/TheTurtle.png");

        dialog = new Dialog(300, 100, 200, 100, true);

        Page page = new Page(0, 0, 200, 50);
        page.addTextBox(new TextBox("Hej August\nHär är en sträng", 0, 0, 5));
        dialog.addPage(page);
        Page page2 =  new Page(0, 0, 200, 50);
        page.addImage();
        dialog.addPage(page2);

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
                    break;
                case 'e':
                    dialog.nextPage();
            }
        }
    }

    public void update(double delta){
        this.map.update(delta);
        this.logic.movable.updatePlayerPosition(this.player, this.map, delta);

    }
}
