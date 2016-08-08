package main;

import java.awt.*;

/**
 * Created by josef on 2016-08-08.
 */
public class Map extends Renderable{

    double totalWidth = 1000;
    double totalHeight = 1000;

    double viewWidth;
    double viewHeight;

    Map(double viewWidth, double viewHeight){
        super(0,0,viewWidth,viewHeight);

        this.setWidth(viewWidth);
        this.setHeight(viewHeight);
    }

    @Override
    public void render(Graphics2D g) {
        g.setColor(Color.DARK_GRAY);
        g.fill(new Rectangle(0,0,(int)this.getWidth(),(int)this.getHeight()));
    }

    @Override
    public void update(double delta) {

    }
}
