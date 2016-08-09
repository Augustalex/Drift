package main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-09.
 */
public class TextBox extends Renderable {

    Font font = new Font("courier new", Font.PLAIN, 12);
    private double lineSpacing = 1.2;

    ArrayList<String> lines = new ArrayList<String>();

    TextBox(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.destroy();
    }

    TextBox(String text, double x, double y, int lineWidth){
        super(0,0,0,0);

        char [] line = new char[lineWidth+1];

        int linePosition = 0;
        System.out.println(text);
        for(int i = 0; i < text.length(); i++){
            System.out.print(text.charAt(i) + ", ");
            if(linePosition >= lineWidth || text.charAt(i) == '\n'){
                String tempString = new String(line);
                this.lines.add(tempString);
                linePosition = 0;
                System.out.println(tempString);
            }

            if(text.charAt(i) == '\n'){
                System.out.println("\\n");
            }

            line[linePosition] = text.charAt(i);
            linePosition++;
        }
        this.lines.add(new String(line));

        System.out.println("Lines: ");

        for(int i = 0; i < lines.size(); i ++){
            System.out.print(lines.get(i) + " ");
        }
        System.out.println("");

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
        g.setColor(Color.black);

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
    public void update(double delta) {

    }
}
