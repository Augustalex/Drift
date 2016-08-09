package main;

import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;

/**
 * Created by josef on 2016-08-08.
 */
public class Map{

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
    //public ArrayList<Renderable> inView = new ArrayList<Renderable>();

    Map(int totalWidth, int totalHeight){
        this.totalWidth = totalWidth;
        this.totalHeight = totalHeight;

        this.nXChunks = 3;
        this.nYChunks = 3;
        Chunk.superWidth = totalWidth/this.nXChunks;
        Chunk.superHeight = totalHeight/this.nYChunks;

        for(int i = 0; i < this.nYChunks; i++){
            this.chunks.add(new ArrayList<Chunk>());
            for(int j = 0; j < this.nXChunks; j++){
                this.chunks.get(i).add(new Chunk(j, i));
            }
        }
    }

    public void setToCurrentMap(){
        Map.currentMap = this;

    }

    public void setCurrentViewDimensions(double width, double height){
        this.viewWidth = width;
        this.viewHeight = height;
    }

    public void moveView(double newX, double newY){
        this.viewX = newX;
        this.viewY = newY;
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
        g.clearRect(0,0,(int)this.viewWidth, (int) this.viewHeight);
        g.setColor(Color.BLACK);
        g.fillRect(0,0, (int) this.viewWidth, (int)this.viewHeight);
        ArrayList<Chunk> chunksInView = getChunksInView();
        for(int i = 0; i < chunksInView.size(); i++){
            g.drawImage(chunksInView.get(i).getChunckImage(), (int)(chunksInView.get(i).getX() - this.viewX), (int)(chunksInView.get(i).getY() - this.viewY), null);
            chunksInView.get(i).printInfo();
            System.out.println("View: " + this.viewX + ", " + this.viewY);
        }

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
        int xChunk = (int)Math.floor(this.viewX / (this.totalWidth/nXChunks));
        int yChunk = (int)Math.floor(this.viewY / (this.totalHeight/nYChunks));
        return this.chunks.get(yChunk).get(xChunk);
    }

    public Chunk findChunk(double x, double y){
        int xChunk = (int)Math.floor(x / (this.totalWidth/nXChunks));
        int yChunk = (int)Math.floor(y / (this.totalHeight/nYChunks));
        return this.chunks.get(yChunk).get(xChunk);
    }

    public ArrayList<Chunk> getChunksInView(){
        ArrayList<Chunk> chunksInView = new ArrayList<>();
        Chunk cornerChunk = getCurrentChunk();
        Point corner = new Point(cornerChunk.getChunkX(), cornerChunk.getChunkY());

        chunksInView.add(cornerChunk);

        Point[] others = {new Point(corner.x+1, corner.y), new Point(corner.x, corner.y+1), new Point(corner.x+1, corner.y+1)};

        for(int i = 0; i < others.length; i++){
            if(this.getCurrentViewArea().contains(others[i]))
                chunksInView.add(this.chunks.get(others[i].y).get(others[i].x));
        }

        return chunksInView;
    }

    public void add(Renderable object){
        findChunk(object.getX(), object.getY()).addObject(object);
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

}
