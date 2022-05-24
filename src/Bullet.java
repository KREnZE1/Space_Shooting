import GLOOP.GLKegel;
import GLOOP.GLZylinder;

public class Bullet {

    float x, y;
    GLZylinder body;
    GLKegel tip;
    boolean ship;

    public Bullet(float pX, float pY, boolean pShip) {
        //ship = true -> Your shot
        //ship = false -> enemy shot
        this.x = pX;
        this.y = pY;
        this.ship = pShip;

        body = new GLZylinder(x, y, 0, 2, 8);
        tip = new GLKegel(x+6.5, y,0,2,5);

        body.drehe(0,270,0);
        tip.drehe(0,270,0);

        colour(ship);

    }

    private void colour(boolean ship) {
        if (ship) {
            this.body.setzeFarbe(255, 22, 12);
            this.tip.setzeFarbe(255,22,12);
        }
        else {
            this.body.setzeFarbe(57,255,20);
            this.tip.setzeFarbe(57, 255, 20);
        }
        //TODO: Correct colors, not applied correctly at the moment
    }
}