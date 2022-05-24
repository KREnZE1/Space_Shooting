import GLOOP.*;

public class Main {

    static GLEntwicklerkamera cam;
    static GLLicht licht;
    static GLTastatur kb;
    static Ship ship;

    public static void main(String[] args) {
        setup();
        while (ship.getHP()>0) {

        }
    }

    public static void setup() {
        cam = new GLEntwicklerkamera();
        cam.setzePosition(0,0,300);
        licht = new GLLicht();

        kb = new GLTastatur();
        ship = new Ship(-30,20,4,3);
    }

    //public static void 
}