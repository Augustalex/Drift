package main;

/**
 * Created by August on 2016-08-08.
 */
public class Player {
    String name = "Player";

    Player(double x, double y, double width, double height){
        super(x, y, width, height);
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
}
