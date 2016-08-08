package main;

import java.awt.event.InputEvent;

/**
 * Created by josef on 2016-08-08.
 */
public class GameModel implements Updates{

    private GameLogic logic;

    private Map map;
    private Player player;

    GameModel(){
        this.logic = new GameLogic();

        this.map = new Map();
        this.player = new Player(10, 10, 50, 50);



    }

    @Override
    public void update(InputEvent e) {

    }
}
