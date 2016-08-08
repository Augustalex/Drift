package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by josef on 2016-08-08.
 */
public class InputHandler implements KeyListener {

    Updates actor;

    InputHandler(Updates actor){
        this.actor = actor;
        System.out.println("New input handler.");
        System.out.println(this.actor);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("Input!");
        actor.update(e);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        actor.update(e);
    }
}
