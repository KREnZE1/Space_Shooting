import GLOOP.*;

public class Testing{
    public static void main(String[] args) {
        GLLicht licht = new GLLicht();
        GLEntwicklerkamera cam = new GLEntwicklerkamera();

        Bullet ammo = new Bullet(0,0, true, true);
        Bullet ammo1 = new Bullet(0,30,false, false);
        GLQuader right = new GLQuader(300, 0, 0, 5, 5, 5);
        GLQuader left = new GLQuader(-300,0,0,5,5,5);

        Sys.warte(5000);
        while (true) {
            Main.bullet_move(ammo);
            Main.bullet_move(ammo1);
        }
    }
}