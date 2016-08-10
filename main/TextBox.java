package main;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-09.
 */
public class TextBox extends Renderable {

    public static int standardSize = 16;
    Font font = new Font("courier new", Font.PLAIN, standardSize);
    private double lineSpacing = 1.2;
    private Color color = Color.WHITE;

    ArrayList<String> lines = new ArrayList<String>();

    TextBox(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.destroy();
    }

    public TextBox(String text, double x, double y, Color color){
        super(x, y, 0, 0);

        this.color = color;
        parseText(text, 0);
    }

    public TextBox(String text, double x, double y, int lineWidth){
        super(x,y,0,0);

        parseText(text, lineWidth);
    }

    public void parseText(String text, int lineWidth){
        if(lineWidth == 0)
            lineWidth = text.length();

        char [] line = new char[lineWidth];

        int linePosition = 0;
        for(int i = 0; i < text.length(); i++){
            if(linePosition >= lineWidth || text.charAt(i) == '\n'){
                String tempString = new String(line);
                this.lines.add(tempString);
                linePosition = 0;
            }

            line[linePosition] = text.charAt(i);
            linePosition++;
        }
        for(int p = linePosition; p < lineWidth; p++){
            line[linePosition++] = ' ';
        }
        this.lines.add(new String(line));
    }

    public void setFont(Font font){
        this.font = font;
    }

    public void setFontTexture(String fontName){
        this.font = new Font(fontName, this.font.getStyle(), this.font.getSize());
    }

    public void setFontStyle(int style){
        this.font = new Font(this.font.getName(), style, this.font.getSize());
    }

    public void setFontSize(int size){
        this.font = new Font(this.font.getName(), this.font.getStyle(), size);
    }

    public Font getFont(){
        return this.font;
    }

    @Override
    public void render(Graphics2D g) {
        g.setFont(this.font);
        g.setColor(this.color);

        double currentX = this.getX();
        double currentY = this.getY() + this.getFont().getSize();
        for(int i = 0; i < lines.size(); i ++){
            if(i > 0){
                currentY += this.getFont().getSize() * lineSpacing;
            }
            g.drawString(lines.get(i), (int)currentX, (int)currentY);
        }
    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {

    }

    @Override
    public void update(double delta) {

    }
}
