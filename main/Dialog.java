package main;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-09.
 */
public class Dialog extends ActionCall{

    ArrayList<Page> pages = new ArrayList<Page>();
    protected int currentPage = 0;
    protected float thickness = 5;
    protected double lineX;
    protected double lineY;
    protected double lineWidth;
    protected double lineHeight;
    protected boolean boarderInsideBody;

    Dialog(double posX, double posY, double width, double height, boolean boarderInsideBody) {
        super(posX, posY, width, height);
        this.boarderInsideBody = boarderInsideBody;

        thickness = ((int)thickness / 2) * 2;

        if(this.boarderInsideBody) {

            this.lineX = posX;
            this.lineY = posY;
            this.lineWidth = width;
            this.lineHeight = height;

            this.setX(posX + (thickness / 2));
            this.setY(posY + (thickness / 2));
            this.setWidth(width - thickness);
            this.setHeight(height - thickness);

        }
        else{
            this.lineX = posX - (thickness / 2);
            this.lineY = posY - (thickness / 2);
            this.lineWidth = width + thickness;
            this.lineHeight = height + thickness;
        }

    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.black);
        g.setStroke(new BasicStroke(thickness));
        g.draw(new Rectangle((int)this.lineX, (int)this.lineY, (int)this.lineWidth, (int)this.lineHeight));

        g.setColor(Color.white);
        g.fill(new Rectangle((int)this.getX(), (int)this.getY(), (int)this.getWidth(), (int)this.getHeight()));

        if(this.pages.size() > 0 ) {

            Page page = this.pages.get(this.currentPage);
            double pageX = page.getX();
            double pageY = page.getY();

            page.setPosition(this.getX() + pageX, this.getY() + pageY);

            page.render(g);
            page.setPosition(pageX, pageY);
        }
        else{
            System.out.println("ERROR: No pages in page Array.");
        }
    }

    public void addPage(Page pageOb){
        pages.add(pageOb);
    }

    public void nextPage(){
        if(currentPage < pages.size()){
            currentPage ++;
        }
        else{
            this.destroy();
        }
    }
}
