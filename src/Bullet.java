import GLOOP.GLKegel;
import GLOOP.GLZylinder;

public class Bullet {

    float x, y;
    GLZylinder body;
    GLKegel tip;
    boolean owner, active;

    public Bullet(float pX, float pY, boolean pOwner, boolean pActive) {
        //owner = true -> Your shot
        //owner = false -> enemy shot
        this.x = pX;
        this.y = pY;
        this.owner = pOwner;
        this.active = pActive;

        body = new GLZylinder(x, y, 0, 2, 8);
        tip = new GLKegel(x+6.5, y,0,2,5);

        body.drehe(0,270,0);
        tip.drehe(0,270,0);

        colour();

    }

    private void colour() {
        if (this.getOwner()) {
            this.body.setzeFarbe(255, 22, 12);
            this.tip.setzeFarbe(255,22,12);
        }
        else {
            this.body.setzeFarbe(57,255,20);
            this.tip.setzeFarbe(57, 255, 20);
        }
        //TODO: Correct colors, not applied correctly at the moment
    }

    public void move() {
        if (this.getOwner()) this.verschiebe(5);
        else this.verschiebe(-5);
    }

    public float getX() {return this.x;}
    public boolean getOwner() {return this.owner;}
    public boolean getActive() {return this.active;}
    public void setActive(boolean pActive) {this.active = pActive;}

    public void verschiebe(float pX) {
        body.verschiebe(pX, 0, 0);
        tip.verschiebe(pX, 0, 0);
    }

    public void setzePosition(float pX, float pY) {
        body.setzePosition(pX, pY, 0);
        tip.setzePosition(pX, pY,0);
    }
}