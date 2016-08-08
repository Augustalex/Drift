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
        Graphics2D g2d = (Graphics2D) g;

        for(int i = 0; i < Renderable.list.size(); i++){
            Renderable.list.get(i).render(g2d);
            System.out.println("Here");
            System.out.println(((Player)Renderable.list.get(i)).getName());
        }
    }

    public void render(){
        repaint();
    }
}
