package main;

import java.awt.*;
import java.awt.geom.Arc2D;

/**
 * Created by August on 2016-08-09.
 */
public class Planet extends Movable {

    Planet(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {
        Color original = g.getColor();
        g.setColor(Color.BLUE);
        g.fill(new Arc2D.Double(this.getX()-xOffset, this.getY()-yOffset, this.getWidth(), this.getWidth(), 0, 360, Arc2D.OPEN));
        g.setColor(original);
    }
}
