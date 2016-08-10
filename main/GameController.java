package main;

import java.awt.event.InputEvent;

/**
 * Created by August on 2016-08-08.
 */
public class GameController{

    private boolean gameOn = true;
    private GameModel model;
    private CanvasView canvas;
    private InputHandler inputHandler;

    GameController(){
        int width = 3000;
        int height = 2000;

        this.canvas = new CanvasView(width, height);
        model = new GameModel(width, height);
        inputHandler = new InputHandler(this.model);
        this.canvas.setInputHandler(inputHandler);
        gameLoop();
    }

    public void update(double delta){

        /*for(int i = 0; i < Renderable.list.size(); i++){
            for(int j = 0; j < Renderable.list.get(i).size(); j++){
                Renderable.list.get(i).get(j).update(delta);
            }
        }*/

        this.model.update(delta);
    }

    public void render(){
        this.canvas.render();
    }

    public void gameLoop(){
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        long lastFpsTime = 0;
        long fps = 0;
        while(this.gameOn){

            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);

            lastFpsTime += updateLength;
            fps++;

            if(lastFpsTime >= 100000000){
                //System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }

            update(delta);

            render();

            try{
                Thread.sleep((System.nanoTime()-lastLoopTime + OPTIMAL_TIME)/1000000);
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
    }
}
