package main.Ship;

import main.Movable;
import main.Ship.Auxiliary.AuxiliarieObject;
import main.Ship.Auxiliary.Auxiliary;
import main.Ship.Cockpit.Cockpit;
import main.Ship.Cockpit.CockpitObject;
import main.Ship.Engine.Engine;
import main.Ship.Engine.EngineRoom;
import main.Ship.Engine.Tank.Tank;
import main.Ship.Fuel.Fuel;
import main.Ship.Interior.Interior;
import main.Ship.Interior.InteriorObject;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by DAW 28 on 2016-08-10.
 */

 /*  Engine object
            Engine typer
            Tank object
        capacity

        auxiliary
            Vapen
            cargo hold
            Solceller/Mörkerceller

        interior
            cryo chamber
            mat generering

        cocpit
            ?


        Hull som alla ärver ifrån

      cargo hold array
     */


public class Ship extends Movable{
    String name;
    EngineRoom engineRoom;
    Cockpit cockpit;
    Auxiliary auxiliary;
    Interior interior;

    public Ship(String name, String imgPath, int width, int height, int engienRoomCapacity, int cockpitCapacaty, int auxiliaryCapacaty, int interiorCapacaty){
        super(0, 0, width, height);
        this.name = name;
        engineRoom = new EngineRoom(engienRoomCapacity);
        cockpit = new Cockpit(cockpitCapacaty);
        auxiliary = new Auxiliary(auxiliaryCapacaty);
        interior = new Interior(interiorCapacaty);

        this.loadImage(imgPath);

    }

    public boolean addEngineObject(Engine engine){
        return engineRoom.addEngine(engine);
    }

    public boolean addCockpitObject(CockpitObject cockpitObject){
        return cockpit.addObject(cockpitObject);
    }

    public boolean addAuxiliaryObject(AuxiliarieObject auxiliarieObject){
        return auxiliary.addObject(auxiliarieObject);
    }

    public boolean addInteriorObject(InteriorObject interiorObject){
        return interior.addObject(interiorObject);
    }

    public boolean addTank(Tank tank){
        return engineRoom.addTank(tank);
    }

    public int addFuel(Fuel fuel){
        return engineRoom.addFuel(fuel);
    }

    @Override
    public void render(Graphics2D g) {

    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {

    }
}
