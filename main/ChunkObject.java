package main;

import java.awt.*;

/**
 * Created by August on 2016-08-10.
 */
public abstract class ChunkObject extends Renderable {

    private int chunkPosX;
    private int chunkPosY;

    ChunkObject(double x, double y, double width, double height) {
        super(x, y, width, height);
    }

    public void setChunkPosition(int x, int y){
        this.chunkPosX = x;
        this.chunkPosY = y;
    }

    public Point getChunkPosition(){
        return (new Point(this.chunkPosX, this.chunkPosY));
    }


}
