package main;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-09.
 */
public class Page extends Renderable {

    ArrayList<TextBox> textBoxes = new ArrayList<TextBox>();
    ArrayList<ImageContainer> imageContainers = new ArrayList<ImageContainer>();

    Page(double posX, double posY, double width, double height){
        super(posX, posY, width, height);
    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public void update(double delta) {

    }

    public void addTextBox(TextBox box){
        box.setX(this.getX() + box.getX());
        box.setY(this.getY() + box.getY());

        this.textBoxes.add(box);
    }

    public void addImage(BufferedImage bufferedImage, double x, double y){
        x += this.getX();
        y += this.getY();

        this.imageContainers.add(new ImageContainer(bufferedImage, x, y));
    }





}
