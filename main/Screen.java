package main;

import javax.swing.*;
import java.awt.*;

/**
 * Created by August on 2016-08-08.
 */
public class Screen extends JPanel {

    Screen(){

    }

    @Override
    public void paintComponent(Graphics g){
        g.setColor(Color.orange);
        g.fillRect(10,10,60,60);
    }
}
