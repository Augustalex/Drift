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
            for(int j = 0; j < Renderable.list.get(i).size(); j++){
                System.out.println(i + "->" + j + ": " +Renderable.list.get(i).get(j));
                Renderable.list.get(i).get(j).render(g2d);
            }
        }
    }

    public void render(){
        repaint();
    }
}
