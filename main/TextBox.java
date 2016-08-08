package main;

import java.awt.*;

/**
 * Created by josef on 2016-08-09.
 */
public class TextBox extends ActionCall {

    Font font = new Font("courier new", Font.PLAIN, 12);

    TextBox(double posX, double posY, double width, double height) {
        super(posX, posY, width, height);
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

    }
}
