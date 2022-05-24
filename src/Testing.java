import GLOOP.*;
public class Testing{
    public static void main(String[] args) {
        GLLicht licht = new GLLicht();
        GLEntwicklerkamera cam = new GLEntwicklerkamera();

        Bullet ammo = new Bullet(0,0, true);
        Bullet ammo1 = new Bullet(0,30,false);
    }
}