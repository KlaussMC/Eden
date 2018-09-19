import processing.core.*;

import java.util.ArrayList;

public class Main extends PApplet {

    public static PApplet processing;
    public static int SCL;

    public boolean w, a, s, d;

    public static void main(String[] args) {
        PApplet.main("Main");
    }

    public static ArrayList<Entity> entities = new ArrayList<>();
    public static Player p;

    public void setup() {
        this.processing = this;

        p = new Player(0, 0, ID.player);

        colorMode(HSB);

        SCL = 12;
    }

    public void settings() {
        fullScreen();
    }

    public void draw() {
        background(0);

        p.show();
        p.update();
        for (Entity e : entities) {
            e.show();
            e.update();
        }

        if (w) p.move(Entity.FORWARD, 12);
        if (s) p.move(Entity.BACKWARD, 12);
        if (a) p.move(Entity.LEFT, 12);
        if (d)  p.move(Entity.RIGHT, 12);
    }

    public void keyPressed() {
        if (key == 'w') {
            w = true;
        } else if (key == 's') {
            s = true;
        } else if (key == 'a') {
            a = true;
        } else if (key == 'd') {
            d = true;
        }
    }

    public void keyReleased () {
        if (key == 'w') {
            w = false;
        } else if (key == 's') {
            s = false;
        } else if (key == 'a') {
            a = false;
        } else if (key == 'd') {
            d = false;
        }
    }
}
