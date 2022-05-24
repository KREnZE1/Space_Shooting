import GLOOP.*;

public class Ship {

    float x, y, z, hp;
    boolean up;
    GLZylinder body, cannon1, cannon2, cannonarm_1, cannonarm_2;
    GLKegel tip;

    public static void main(String[] args) {
        GLLicht licht = new GLLicht();
        GLEntwicklerkamera cam = new GLEntwicklerkamera();

    }
    public Ship(float pX, float pY, float pZ, int pHP) {
        this.x = pX;
        this.y = pY;
        this.z = pZ;
        this.hp = pHP;

        body = new GLZylinder(pX,pY,pZ,10,50);
        tip = new GLKegel(40+pX,pY,pZ,10,30);
        body.drehe(0,270,0);
        tip.drehe(0,270,0);

        cannon1 = new GLZylinder(-10+pX,16.5+pY,pZ,3,20);
        cannonarm_1 = new GLZylinder(-10+pX,10+pY,pZ,1,10);
        cannon1.drehe(0,90,0);
        cannonarm_1.drehe(90,0,0);

        cannon2 = new GLZylinder(-10+pX,-16.5+pY,pZ,3,20);
        cannonarm_2 = new GLZylinder(-10+pX,-10+pY,pZ,1,10);
        cannon2.drehe(0,90,0);
        cannonarm_2.drehe(90,0,0);
    }

    public void verschiebe(int x, int y) {
        body.verschiebe(x, y, 0);
        tip.verschiebe(x, y, 0);
        cannon1.verschiebe(x, y, 0);
        cannonarm_1.verschiebe(x, y, 0);
        cannon2.verschiebe(x, y, 0);
        cannonarm_2.verschiebe(x, y, 0);
    }

    public float getHP() {return this.hp;}
    public void setHP(int value) {this.hp = value;}
    public float getX() {return this.x;}
    public float getY() {return this.y;}
    public float getZ() {return this.z;}
    public float getHigh() {return getY()+19;}
    public float getLow() {return getY()-19;}
    public float getLeft() {return getX()-26;}
    public float getRight() {return getX()+56;}

    public void shoot(Bullet[] ammo) {
        for (int i=0; i<ammo.length; i++) {
            if (ammo[i] == null) {
                if (up) ammo[i] = new Bullet(cannon1.gibX(), cannon1.gibY(), true);
                else ammo[i] = new Bullet(cannon2.gibX(), cannon2.gibY(), true);
                Sys.warte(50);
                up = !up;
                return;
            }
        }
    }
}