package main;

/**
 * Created by August on 2016-08-08.
 */
public class GameController{

    private boolean gameOn = true;
    private View view;

    GameController(){
        view = new View();


    }

    public void update(double delta){
//.
    }


    public void render(){
        this.view.render();
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
                Thread.sleep((lastLoopTime-System.nanoTime() + OPTIMAL_TIME)/1000000);
            }
            catch(Exception e){
                System.out.println(e);
            }

        }
    }
}
