package main;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-08.
 */
public class Map extends Renderable{

    double totalWidth = 1000;
    double totalHeight = 1000;

    double viewWidth;
    double viewHeight;

    public static Map currentMap = null;
    public static ArrayList<Renderable> inView = new ArrayList<Renderable>();

    Map(double viewWidth, double viewHeight){
        super(0,0,viewWidth,viewHeight);

        this.setWidth(viewWidth);
        this.setHeight(viewHeight);
    }

    public void setToCurrentMap(){
        Map.currentMap = this;
    }

    public Area getCurrentViewArea(){
        return (new Area(new Rectangle2D.Double(this.getX(), this.getY(), this.getWidth(), this.getHeight())));
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fill(new Rectangle(0,0,(int)this.getWidth(),(int)this.getHeight()));

        for(int i = 0; i < Map.inView.size(); i++){
            Map.inView.get(i).render(g);
        }
    }

    @Override
    public void update(double delta) {
        for(int i = 0; i < Renderable.list.size(); i++){
            if(this.getCurrentViewArea().contains(Renderable.list.get(i).getRectangle())) {
                Map.inView.add(Renderable.list.get(i));
            }
        }
    }
}
