package main;


import javax.swing.*;
import java.awt.*;

/**
 * Created by August on 2016-08-08.
 */
public class View{

    private JFrame window;
    private Screen screen;

    View(int width, int height){
        window = new JFrame("Drift");
        screen = new Screen();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(screen);
        window.setPreferredSize(new Dimension(width+50,height+50));
        window.setLayout(new GridLayout(1,2));

        screen.setPreferredSize(new Dimension(width,height));
    }

    public void init(){
        screen.setVisible(true);

        window.pack();
        window.setVisible(true);
    }

    public void render(){
        this.screen.render();
    }

    public void setInputHandler(InputHandler inputHandler){
        this.window.addKeyListener(inputHandler);
    }

    public int getScreenWidth(){
        return this.screen.getWidth();
    }

    public int getScreenHeight(){
        return this.screen.getHeight();
    }

}


/*

    x = x + r * cos(a);
    y = y + r * sin(a);


 */