package main;

import java.awt.*;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Created by August on 2016-08-09.
 */
public class Chunk extends Renderable {

    public static double superWidth = 0.0;
    public static double superHeight = 0.0;

    private int chunkX = 0;
    private int chunkY = 0;

    public ArrayList<Renderable> objects = new ArrayList<Renderable>();

    private BufferedImage chunkImage = null;

    Chunk(int chunkXPos, int chunkYPos) {
        super(chunkXPos* superWidth, chunkYPos* superHeight, superWidth, superHeight);
        this.chunkX = chunkXPos;
        this.chunkY = chunkYPos;
    }

    public int getChunkX(){
        return this.chunkX;
    }

    public int getChunkY(){
        return this.chunkY;
    }

    public void setSuperWidth(double superWidth){
        Chunk.superWidth = superWidth;
    }

    public void setSuperHeight(double superHeight){
        Chunk.superHeight = superHeight;
    }

    public double getSuperWidth(){
        return superWidth;
    }

    public double getSuperHeight(){
        return superHeight;
    }

    @Override
    public void render(Graphics2D g) {
        this.chunkImage = this.getChunckImage();
    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {

    }

    @Override
    public void update(double delta) {
        for(int i = 0; i < this.objects.size(); i++){
            this.objects.get(i).update(delta);
        }
    }

    public BufferedImage getChunckImage(){
        BufferedImage chunkImage = new BufferedImage((int) superWidth, (int) superHeight, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = chunkImage.createGraphics();

        for(int i = 0; i < this.objects.size(); i++){
            this.objects.get(i).render(g2d);
        }

        return chunkImage;
    }

    public void addObject(Renderable object){
        this.objects.add(object);
    }

    public void removeObject(Renderable object){
        this.objects.remove(object);
    }

    public void printInfo(){
        System.out.println("\n\nChunk X:" + this.chunkX + " Y:" + this.chunkY);
        System.out.print("Objects: ");
        for(int i = 0; i < this.objects.size(); i++){
            System.out.print(this.objects.get(i).getClass().getName() + ", ");
        }
    }
}
