package _08final.mvc.model;

import _08final.images.SpriteTexLoader;
import _08final.mvc.view.GameFrame;

import java.awt.*;

/**
 * Created by lamont on 11/20/16.
 */
public class Ship extends Sprite {

    private final static Dimension SHIP_DIM = new Dimension(25,39);


    /**
     * Method constructs a Ship object with an initial position
     * @param initPos
     */
    public Ship(Point initPos) {
        super(initPos, SHIP_DIM, SpriteTexLoader.load(SpriteTexLoader.SpriteTex.SHIP));
    }
    public void move(long deltaTime) {

    }

    /**
     * Method move the Ship object's position to left or right
     */
    public void moveLeft() {
        this.mPos.translate(-5,0);
    //    this.mPos = new Point(this.mPos.x + 5, this.mPos.y);
    }
    public void moveRight() {
        this.mPos.translate(5,0);
        //    this.mPos = new Point(this.mPos.x - 5, this.mPos.y);

    }

    public Dimension getShipDim()
    {
        return SHIP_DIM;
    }

}
