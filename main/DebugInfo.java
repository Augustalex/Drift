package main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by August on 2016-08-10.
 */
public class DebugInfo extends Renderable{

    public static ArrayList<TextBox> textBoxes = new ArrayList<>();

    DebugInfo(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public static void renderAll(Graphics2D g){
        for(TextBox box : textBoxes){
            box.render(g);
        }

        textBoxes = new ArrayList<>();
    }

    @Override
    public void render(Graphics2D g) {
        renderAll(g);
    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {

    }

    @Override
    public void update(double delta) {

    }
}
