package main.Ship.Engine;

/**
 * Created by DAW 28 on 2016-08-10.
 */
public class CatapillerBoatmotor extends Engine{
    CatapillerBoatmotor(String name, double efficiency, double tankSize, int hullValue, int engineSize) {
        super(name, efficiency, tankSize, hullValue, engineSize);
    }
/*
    CatapillerBoatmotor(){
        //super("Caterpiller Ship Engine, 520 kW", 100, 100, 400);
        this.addAvivableFuelTypes("Disel");
        this.addAvivableFuelTypes("Gasoline");
        this.addAvivableFuelTypes("Kerosene");
    }*/
}
