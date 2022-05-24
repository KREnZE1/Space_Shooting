import GLOOP.*;

public class Main {

    static GLKamera cam;
    static GLLicht licht;
    static GLTastatur kb;
    static Ship ship;
    static Bullet[][] bullets;

    public static void main(String[] args) {
        setup();
        GLQuader test = new GLQuader(300, 0, 0, 5, 5, 5);
        while (ship.getHP()>0) {
            ship_move();
            if (kb.shift()) ship.shoot(bullets[0]);
            bullet_move();
        }
    }

    private static void ship_move() {
        if (kb.rechts()) ship.verschiebe(5, 0);
        else if (kb.links()) ship.verschiebe(-5, 0);
        else if (kb.oben()) ship.verschiebe(0, 5);
        else if (kb.unten()) ship.verschiebe(0, -5);
        Sys.warte(25);
    }

    public static void setup() {
        cam = new GLKamera();
        cam.setzePosition(0,0,300);
        licht = new GLLicht();

        kb = new GLTastatur();
        ship = new Ship(-250,20,4,3);

        bullets = new Bullet[10][];
        bullets[0] = new Bullet[10];
        for (int i=1; i<bullets.length; i++) bullets[i] = new Bullet[3];
    }

    public static void bullet_move() {
        for (int i=0; i<bullets.length; i++) {
            if (bullets[i] != null) {
                for (int j=0; j<bullets[i].length; j++) {
                    if (bullets[i][j] != null) {
                        bullets[i][j].move();
                        if (bullets[i][j].getX()>300 || bullets[i][j].getX()<-300) bullets[i][j] = null;
                        //TODO: Bullets aren't getting deleted at all, so the player only has a magazine size of 10
                    }
                }
            }
        }
    }
}