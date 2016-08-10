package main.Ship;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class Hull {

    private int hullPoints = 100;
    private int origHullPoints;

    public Hull(){
        this.origHullPoints = hullPoints;
    }

    public Hull(int hullPoints){
        this.hullPoints = hullPoints;
        this.origHullPoints = hullPoints;
    }

    public void removeHullPoints(int points){
        this.hullPoints -= points;
        if(this.hullPoints <= 0){
            this.hullPoints = 0;
        }
    }

    public int getHullPoints(){
        return hullPoints;
    }

    public void setHullPoints(int hullPoints){
        this.hullPoints = hullPoints;
    }

    public boolean isEmpty(){
        if(this.hullPoints <= 0)
            return true;

        else
            return false;
    }

}
