package main;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by josef on 2016-08-09.
 */
public class ImageContainer extends Renderable {

    ImageContainer(BufferedImage bufferedImage, double x, double y) {
        super(x, y, bufferedImage.getWidth(), bufferedImage.getHeight());
        this.img = bufferedImage;
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(this.img, (int)this.getX(), (int)this.getY(), null);
    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {

    }

    @Override
    public void update(double delta) {

    }
}
