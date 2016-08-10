package main;

import javax.xml.soap.Text;
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
        this.destroy();
    }

    @Override
    public void render(Graphics2D g) {
        for(int i = 0; i < textBoxes.size(); i ++){

            TextBox box = textBoxes.get(i);
            double boxX = box.getX();
            double boxY = box.getY();

            if(i > 0) {
                box.setPosition(this.getX() + boxX, this.getY() + textBoxes.get(i - 1).getY() + textBoxes.get(i - 1).getFont().getSize());
            }
            else{
                box.setPosition(this.getX() + boxX, this.getY() + boxY);
            }

            /*if(i > 0){
                textBoxes.get(i).setY(textBoxes.get(i - 1).getY() + textBoxes.get(i - 1).getHeight());
            } */

            box.render(g);
            box.setPosition(boxX, boxY);
        }
    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {

    }

    @Override
    public void update(double delta) {

    }

    public void addTextBox(TextBox box){
        this.textBoxes.add(box);
    }

    public void addImage(BufferedImage bufferedImage, double x, double y){
        x += this.getX();
        y += this.getY();

        this.imageContainers.add(new ImageContainer(bufferedImage, x, y));
    }





}
