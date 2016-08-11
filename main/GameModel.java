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

    private int worldWidth = 100000; //Senaste gränsen: 100 000 000
    private int worldHeight = 100000;

    GameModel(int screenWidth, int screenHeight){
        this.logic = new GameLogic();

        this.map = new Map(worldWidth, worldHeight);
        this.map.setToCurrentMap();
        this.map.setCurrentViewDimensions(screenWidth, screenHeight);

        this.player = new Player(screenWidth/2, screenHeight/2, 50, 20);
        this.player.loadImage("res/TheTurtle.png");
        this.map.add(this.player);

        Planet planet = new Planet(10500,10500, 4000,4000);
        this.map.add(planet);
    }

    @Override
    public void update(InputEvent e) {
        if(e instanceof KeyEvent){
            char key = ((KeyEvent) e).getKeyChar();
            boolean toggleOn = false;

            if(e.getID() == KeyEvent.KEY_PRESSED)
                toggleOn = true;

            //System.out.println(e.getID() + " : " + KeyEvent.KEY_PRESSED);

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
