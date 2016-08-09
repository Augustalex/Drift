package main;

import java.awt.*;

/**
 * Created by josef on 2016-08-09.
 */
public class TextBox extends Renderable {

    Font font = new Font("courier new", Font.PLAIN, 12);

    TextBox(double x, double y, double width, double height) {
        super(x, y, width, height);
        this.destroy();
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
        g.drawString("Hej August", (int)this.getX(), (int)this.getY() + this.getFont().getSize());
    }

    @Override
    public void update(double delta) {

    }
}
