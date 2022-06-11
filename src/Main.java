import GLOOP.*;

public class Main {

    static GLKamera cam; //shows the screen
    static GLLicht licht; //makes everything visible
    static GLTastatur kb; //reads keyboard input
    static Ship ship; //player character
    static Bullet[][] bullets; //player and enemy ammunition

    public static void main(String[] args) {
        setup();
        GLQuader right = new GLQuader(300, 0, 0, 5, 5, 5);
        GLQuader left = new GLQuader(-300,0,0,5,5,5);
        while (ship.getHP()>0) {
            ship_move();
            if (kb.shift()) ship.shoot(bullets[0]);
            for (Bullet[] magazine : bullets) {
                for (Bullet ammo : magazine) {
                    bullet_move(ammo);
                }
            }
        }
    }

    private static void ship_move() {
        /**
         * depending on the keyboard input the player character moves in the fitting direction
         */

        if (kb.rechts()) ship.verschiebe(5, 0);
        else if (kb.links()) ship.verschiebe(-5, 0);
        else if (kb.oben()) ship.verschiebe(0, 5);
        else if (kb.unten()) ship.verschiebe(0, -5);
        Sys.warte(25); //Magic (for real, the keyboard doesn't work correctly without the wait, it's magic)
    }

    public static void setup() {
        /**
         * initialises all objects to their start values
         */

        cam = new GLKamera();
        cam.setzePosition(0,0,300);
        licht = new GLLicht();

        kb = new GLTastatur();

        ship = new Ship(-250,20,4,3); //ship gets made on the left screen side

        bullets = new Bullet[10][];
        bullets[0] = new Bullet[10]; //player ammunition
        for (int i=0; i<bullets[0].length; i++) bullets[0][i] = new Bullet(-2000, 0, true, false); //fills the player magazine with inactive bullets
        for (int i=1; i<bullets.length; i++) {
            bullets[i] = new Bullet[3]; //a magazine for an enemy is created
            for (int j=0; j<bullets[i].length; j++) bullets[i][j] = new Bullet(-2000, 0, false, false); and then filled with inactive bullets
        }
    }

    public static void bullet_move(Bullet ammo) {
        if (ammo.getActive()) {
            ammo.move();
            System.out.println(ammo.getX());
            if (ammo.getX() > 300 || ammo.getX() < -300) {
                ammo.setzePosition(-2000, 0);
                ammo.setActive(false);
            }
            //TODO: Bullets don't work at all anymore
        }
    }
}
