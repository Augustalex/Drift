package main;

import javafx.scene.transform.Affine;
import org.w3c.dom.css.Rect;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-08.
 */
public class Map{

    private static final int X_CHUNK = 1000;
    private static final int Y_CHUNK = 1000;
    private int totalWidth = 1000;
    private int totalHeight = 1000;

    private double viewWidth = 800;
    private double viewHeight = 600;
    private double viewX = 0;
    private double viewY = 0;

    public static Map currentMap = null;

    private int nXChunks = 0;
    private int nYChunks = 0;
    public ArrayList<ArrayList<Chunk>> chunks = new ArrayList<>();

    public Chunk[][] allChunks;
    //public ArrayList<Renderable> inView = new ArrayList<Renderable>();

    Map(int totalWidth, int totalHeight){
        this.totalWidth = totalWidth;
        this.totalHeight = totalHeight;

        this.nXChunks = totalWidth/X_CHUNK;
        this.nYChunks = totalHeight/Y_CHUNK;
        Chunk.superWidth = totalWidth/this.nXChunks;
        Chunk.superHeight = totalHeight/this.nYChunks;

        this.allChunks = new Chunk[this.nXChunks][this.nYChunks];

        for(int i = 0; i < this.nYChunks; i++){
            for(int j = 0; j < this.nXChunks; j++){
                this.allChunks[j][i] = new Chunk(j, i);
            }
        }
        System.out.println("Made it");
    }

    public void setToCurrentMap(){
        Map.currentMap = this;

    }

    public void setCurrentViewDimensions(double width, double height){
        this.viewWidth = width;
        this.viewHeight = height;
    }

    public void moveView(double x, double y){
        double newX = x - this.viewWidth / 2;
        double newY = y - this.viewHeight / 2;
        if(newX > 0 && newY > 0 && newX < this.totalWidth && newY < this.totalHeight){
            this.viewX = newX;
            this.viewY = newY;
        }
    }

    public void moveViewQuadrant(Point2D position){
        if(position.getX() > this.viewX+this.viewWidth)
            this.viewX += this.viewWidth;
        else if(position.getX() < this.viewX)
            this.viewX -= this.viewWidth;
        else if(position.getY() > this.viewY + this.viewHeight)
            this.viewY += this.viewHeight;
        else if(position.getY() < this.viewY)
            this.viewY -= this.viewHeight;
    }

    public void moveViewToChunk(Point2D point){
        Chunk chunk = this.findChunk(point.getX(), point.getY());
        this.viewX = chunk.getX();
        this.viewY = chunk.getY();
    }

    public Area getCurrentViewArea(){
        return (new Area(new Rectangle2D.Double(this.viewX, this.viewY, this.viewWidth, this.viewHeight)));
    }

    public Rectangle2D getView(){
        return (new Rectangle2D.Double(this.viewX, this.viewY, this.viewWidth, this.viewHeight));
    }
    public void render(Graphics2D g) {
        //g.clearRect(0,0,(int)this.viewWidth, (int) this.viewHeight);
        g.setColor(Color.BLACK);
        g.fillRect(0,0, (int) this.viewWidth, (int)this.viewHeight);

        ArrayList<Chunk> chunksInView = getChunksInView(30);

        g.setColor(Color.YELLOW);
        g.setStroke(new BasicStroke(3));
        for(int i = 0; i < chunksInView.size(); i++){
            for(int j = 0; j < chunksInView.get(i).objects.size(); j++) {
                Renderable object = chunksInView.get(i).objects.get(j);
                object.render(g, this.viewX, this.viewY);

                /*          DEBUG OUTLINES          */
                /*
                if(object instanceof Movable) {
                    AffineTransform backup = g.getTransform();
                    AffineTransform trans = ((Movable) object).getTransformation(this.viewX, this.viewY);
                    g.transform(trans);
                    g.draw(object.getRectangle(this.viewX, this.viewY));
                    g.setTransform(backup);
                }
                else
                    g.draw(object.getRectangle(this.viewX, this.viewY));*/

            }

            //          Debug Chunk Outlines
            g.draw(chunksInView.get(i).getRectangle(this.viewX, this.viewY));
            Rectangle2D rect = chunksInView.get(i).getRectangle();

            //          Debug Center Points
            /*Rectangle2D newRect = new Rectangle2D.Double((rect.getX()-this.viewX)+Chunk.superWidth/2, (rect.getY()-this.viewY)+Chunk.superHeight/2, 5, 5);
            g.fill(newRect);*/
        }


        //      Debug View Center Point
        /*g.setColor(Color.RED);
        g.fill(new Rectangle2D.Double(this.viewX+this.viewWidth/2, this.viewY+this.viewHeight/2, 10, 10));
        */

    }

    public void update(double delta) {
        /*for(int i = 0; i < Map.inView.size(); i++){
            Map.inView.get(i).update(delta);
        }*/
        for(int i = 0; i < Renderable.list.size(); i++){
            Renderable.list.get(i).update(delta);
        }
    }

    public Chunk getCurrentChunk(){
        try {
            int xChunk = (int) Math.floor(this.viewX / (this.totalWidth / nXChunks));
            int yChunk = (int) Math.floor(this.viewY / (this.totalHeight / nYChunks));
            return this.allChunks[xChunk][yChunk];
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }

    public Chunk findChunk(double x, double y){
        int xChunk = (int)Math.floor(x / (this.totalWidth/nXChunks));
        int yChunk = (int)Math.floor(y / (this.totalHeight/nYChunks));
        return this.allChunks[xChunk][yChunk];
    }

    public ArrayList<Chunk> getChunksInView(){
        ArrayList<Chunk> chunksInView = new ArrayList<>();

        StringBuilder newString = new StringBuilder();
        for(int i = 0; i < this.chunks.size(); i++){
            for(int j = 0; j < this.chunks.size(); j++){
                if(this.getCurrentViewArea().intersects(this.chunks.get(i).get(j).getRectangle())){
                    Chunk chunk = this.chunks.get(i).get(j);
                    chunksInView.add(chunk);
                    newString.append(String.format("CHUNK[%d, %d], ", chunk.getChunkX(), chunk.getChunkY()));
                }
            }
        }

        String finalString = newString.toString();
        DebugInfo.textBoxes.add(new TextBox(finalString, 100, this.viewHeight-50, Color.RED));
        return chunksInView;
    }

    public ArrayList<Chunk> getChunksInView(int depth){
        Chunk currentChunk = this.getCurrentChunk();
        int x = currentChunk.getChunkX();
        int y = currentChunk.getChunkY();

        ArrayList<Chunk> chunksInView = new ArrayList<>();

        for(int i = y - depth; i < y + depth; i++){
            while(i < 0 || i > this.nYChunks)
                i++;
            for(int j = x - depth; j < x + depth; j++){
                while(j < 0 ||j > this.nXChunks)
                    j++;
                chunksInView.add(this.allChunks[j][i]);
            }
        }

        return chunksInView;
    }

    public void add(Renderable object){
        Chunk chunk = findChunk(object.getX(), object.getY());
        if(object instanceof ChunkObject)
            ((ChunkObject) object).setChunkPosition(chunk.getChunkX(), chunk.getChunkY());

        chunk.objects.add(object);
    }

    public void remove(Renderable object){
        findChunk(object.getX(), object.getY()).removeObject(object);
    }

    public double getWidth(){
        return this.viewWidth;
    }

    public double getHeight(){
        return this.viewHeight;
    }

    public void updateObjectChunk(Renderable object, Point2D newPosition){
        if(!(object instanceof ChunkObject))
            return;

        int x = ((ChunkObject) object).getChunkPosition().x;
        int y = ((ChunkObject) object).getChunkPosition().y;

        /*
        int x = (int)Math.floor(object.getX()/X_CHUNK);
        int y = (int)Math.floor(object.getY()/Y_CHUNK);
        */

        int newX = (int)Math.floor(newPosition.getX()/X_CHUNK);
        int newY = (int)Math.floor(newPosition.getY()/Y_CHUNK);

        if(newX != x || newY != y){
            this.allChunks[x][y].objects.remove(object);
            this.allChunks[newX][newY].objects.add(object);
            ((ChunkObject) object).setChunkPosition(newX, newY);
        }
    }

    public boolean positionOutOfBounds(Point2D position){
        if(position.getX() < 0 || position.getY() < 0 || position.getX() > this.totalWidth || position.getY() > this.totalHeight)
            return true;
        else
            return false;

    }

    public boolean objectOutOfBoundsChunk(Renderable object, Point2D position){
        int x = (int)Math.floor(object.getX()/X_CHUNK);
        int y = (int)Math.floor(object.getY()/Y_CHUNK);

        int newX = (int)Math.floor(position.getX()/X_CHUNK);
        int newY = (int)Math.floor(position.getY()/Y_CHUNK);

        if(newX != x || newY != y)
            return true;
        else
            return false;
    }

    public boolean positionOutOfView(Point2D position){
        if(position.getX() < this.viewX || position.getX() > this.viewX+this.viewWidth || position.getY() < this.viewY || position.getY() > this.viewY + this.viewHeight)
            return true;
        else
            return false;
    }

}
