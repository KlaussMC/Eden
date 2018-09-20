import processing.core.*;

import java.awt.*;
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

    private int[][] terrain;

    public void setup() {
        this.processing = this;

        colorMode(HSB);

        SCL = 12;

        terrain = Terrain.generateTerrain(displayWidth / 12, displayHeight / 12, processing);

        int x = floor((width / 2) / 12) * 12, y = floor((height / 2) / 12) * 12;

        System.out.println(x);
        System.out.println(y);
        p = new Player(x, y, ID.player);

        colorMode(RGB);

    }

    public void settings() {
        fullScreen();
    }

    public void draw() {
        background(0);
        noStroke();

        for (int i = 0; i < terrain.length; i++) {
            for (int j = 0; j < terrain[i].length; j++) {
                Color c = Terrain.getBackground(terrain[i][j]);
                fill(c.getRed(), c.getGreen(), c.getBlue());
//                System.out.println(String.format("{ r: %S, g: %S, b: %S }", c.getRed(), c.getGreen(), c.getBlue()));
                rect(i * 12, j * 12, 12, 12);
            }
        }

        colorMode(HSB);
        p.show();
        p.refresh();
        for (Entity e : entities) {
            e.show();
            e.refresh();
        }
        colorMode(RGB);

        int speed = floor(map(p.health, 0, 100, 0, 6));

        if (w) p.move(Entity.FORWARD, speed);
        if (s) p.move(Entity.BACKWARD, speed);
        if (a) p.move(Entity.LEFT, speed);
        if (d) p.move(Entity.RIGHT, speed);

        if (w && s) p.move(0, 0);
        if (a && d) p.move(0, 0);

        if (w && d) p.move(1.5f, speed);
        if (d && s) p.move(2.5f, speed);
        if (s && a) p.move(3.5f, speed);
        if (a && w) p.move(4.5f, speed);

        if (!w && !s && !a && !d) p.move(0, 0); // reset movement
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
