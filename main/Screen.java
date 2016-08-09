package main;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

/**
 * Created by August on 2016-08-08.
 */
public class Screen extends Canvas {

    private BufferedImage bufferedScreen;
    public BufferStrategy bufferStrategy = null;

    Screen(){
        this.createBufferStrategy(2);
        this.bufferStrategy = this.getBufferStrategy();
        this.bufferedScreen = new BufferedImage(this.getWidth(), getHeight(), BufferedImage.TYPE_INT_ARGB);
    }

    public void render(){
        if(this.bufferStrategy == null)
            return;

        Graphics g = null;
        try{
            g = this.bufferStrategy.getDrawGraphics();

            Graphics2D g2d = (Graphics2D) g;
            for(int i = 0; i < Renderable.list.size(); i++){
                if(Map.currentMap != null)
                    Map.currentMap.render(g2d);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        finally{
            g.dispose();
        }

        this.bufferStrategy.show();
        Toolkit.getDefaultToolkit().sync();
    }

}
