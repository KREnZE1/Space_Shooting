import GLOOP.*;

public class Main {

    static GLKamera cam;
    static GLLicht licht;
    static GLTastatur kb;
    static Ship ship;

    public static void main(String[] args) {
        setup();
        while (ship.getHP()>0) {
            move();
            Sys.warte(25);
            if (kb.shift()) ship.shoot();
        }
    }

    private static void move() {
        if (kb.rechts()) ship.verschiebe(5, 0);
        else if (kb.links()) ship.verschiebe(-5, 0);
        else if (kb.oben()) ship.verschiebe(0, 5);
        else if (kb.unten()) ship.verschiebe(0, -5);
    }

    public static void setup() {
        cam = new GLKamera();
        cam.setzePosition(0,0,300);
        licht = new GLLicht();

        kb = new GLTastatur();
        ship = new Ship(-250,20,4,3);
    }

    //public static void 
}