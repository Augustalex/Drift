package main.Ship;

import main.DebugInfo;
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
import main.Ship.ShipTypes.TheTurtle;
import main.TextBox;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

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
    private String name;
    public EngineRoom engineRoom;
    public Cockpit cockpit;
    public Auxiliary auxiliary;
    public Interior interior;
    public String path;
    public int masInTon

    public Ship(String name, String path, int width, int height, int masInTon, int engienRoomCapacity, int cockpitCapacaty, int auxiliaryCapacaty, int interiorCapacaty){
        super(0, 0, width, height);
        this.name = name;
        this.path = path;
        this.masInTon = masInTon;
        engineRoom = new EngineRoom(engienRoomCapacity);
        cockpit = new Cockpit(cockpitCapacaty);
        auxiliary = new Auxiliary(auxiliaryCapacaty);
        interior = new Interior(interiorCapacaty);

        this.loadImage(this.path);
    }

    public String getImagePath(){
        return this.path;
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
    public void render(Graphics2D g){

    }

    @Override
    public void render(Graphics2D g, double xOffset, double yOffset) {
        if(this.getImage() != null){
            AffineTransform backup = g.getTransform();
            AffineTransform trans = this.getTransformation(xOffset, yOffset);
            g.transform(trans);
            g.drawImage(this.getImage(), (int)(this.getX()-xOffset), (int)(this.getY()-yOffset), null);
            g.setTransform(backup);
        }

        String info = String.format("[ X:%f, Y:%f ] [ CX:%d, CY:%d ] [ SPEED:%f, ROTATION:%f, ANGLE:%f ]", this.getX(), this.getY(), this.getChunkPosition().x, this.getChunkPosition().y, this.getSpeed(), this.getRotationMomentum(), this.getAngle());
        DebugInfo.textBoxes.add(new TextBox(info, 50, 50, Color.green));
    }

}
