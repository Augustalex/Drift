package main;


import javax.swing.*;
import java.awt.*;

/**
 * Created by August on 2016-08-08.
 */
public class View{

    private JFrame window;
    private Screen screen;

    View(){
        window = new JFrame("Drift");
        screen = new Screen();

        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setContentPane(screen);
        window.setPreferredSize(new Dimension(500,500));
        window.setLayout(new GridLayout(1,2));
        window.setBackground(Color.cyan);

        screen.setPreferredSize(new Dimension(500,500));
        screen.setVisible(true);

        window.pack();
        window.setVisible(true);
    }

    public void render(){
        this.screen.render();
    }

}


/*

    x = x + r * cos(a);
    y = y + r * sin(a);


 */