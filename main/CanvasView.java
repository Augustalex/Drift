package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by August on 2016-08-09.
 */
public class CanvasView extends Canvas {

    private BufferStrategy bufferStrategy = null;
    private JFrame frame;

    CanvasView(double width, double height){
        setPreferredSize(new Dimension((int)width, (int)height));
        this.frame = new JFrame();
        frame.setResizable(false);
        frame.setTitle("CanvasView");
        frame.add(this);
        frame.pack();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        createBufferStrategy(3);
        this.bufferStrategy = getBufferStrategy();
    }

    public void render(){
        //System.out.println("Rendering canvas");
        if(this.bufferStrategy == null){
            System.out.println("Creating new buffer strategy.");
            createBufferStrategy(3);
            return;
        }

        Graphics g = this.bufferStrategy.getDrawGraphics();

        Graphics2D g2d = (Graphics2D) g;
        for(int i = 0; i < Renderable.list.size(); i++){
            if(Map.currentMap != null)
                Map.currentMap.render(g2d);
        }

        g.dispose();
        this.bufferStrategy.show();
    }

    public void setInputHandler(InputHandler inputHandler){
        this.addKeyListener(inputHandler);
        this.setFocusable(true);

    }

}
