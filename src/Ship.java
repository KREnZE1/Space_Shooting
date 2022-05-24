import GLOOP.*;

public class Ship {

    Integer x, y, z, hp;
    GLZylinder body, cannon1, cannon2, cannonholder1, cannonholder2;
    GLKegel tip;

    public static void main(String[] args) {
        GLLicht licht = new GLLicht();
        GLEntwicklerkamera cam = new GLEntwicklerkamera();

    }
    public Ship(int pX, int pY, int pZ, int pHp) {
        this.x = pX;
        this.y = pY;
        this.z = pZ;
        this.hp = pHp;

        body = new GLZylinder(pX,pY,pZ,10,50);
        tip = new GLKegel(40+pX,pY,pZ,10,30);
        body.drehe(0,270,0);
        tip.drehe(0,270,0);

        cannon1 = new GLZylinder(-10+pX,16.5+pY,pZ,3,20);
        cannonholder1 = new GLZylinder(-10+pX,10+pY,pZ,1,10);
        cannon1.drehe(0,90,0);
        cannonholder1.drehe(90,0,0);

        cannon2 = new GLZylinder(-10+pX,-16.5+pY,pZ,3,20);
        cannonholder2 = new GLZylinder(-10+pX,-10+pY,pZ,1,10);
        cannon2.drehe(0,90,0);
        cannonholder2.drehe(90,0,0);
    }

    public void verschiebe(int x, int y) {
        body.verschiebe(x, y, 0);
        tip.verschiebe(x, y, 0);
        cannon1.verschiebe(x, y, 0);
        cannonholder1.verschiebe(x, y, 0);
        cannon2.verschiebe(x, y, 0);
        cannonholder2.verschiebe(x, y, 0);
    }

    public int getHP() {return this.hp;}
    public void setHP(int value) {this.hp = value;}
    public int getX() {return this.x;}
    public int getY() {return this.y;}
    public int getZ() {return this.z;}
    public int getHigh() {return getY()+19;}
    public int getLow() {return getY()-19;}
    public int getLeft() {return getX()-26;}
    public int getRight() {return getX()+56;}
}