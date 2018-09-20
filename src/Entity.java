import processing.core.*;

public abstract class Entity {

    PVector pos;
    PVector vel;
    ID id;

    PApplet p;

    int health;

    public static int FORWARD, BACKWARD, LEFT, RIGHT;

    Entity(int x, int y, ID id) {
        pos = new PVector(x, y);
        vel = new PVector(0, 0);
        this.id = id;

        health = 100;

        p = Main.processing;

        FORWARD = 1;
        BACKWARD = 3;
        LEFT = 4;
        RIGHT = 2;
    }

    abstract void update();

    void refresh() {
        this.update();

        this.pos.add(this.vel);
    }

    abstract void show();

    void move (float dir, int speed) {
        this.vel.x = speed;
        this.vel.y = speed;
        vel.rotate(p.QUARTER_PI + (p.HALF_PI * (dir + 1)));
        vel.setMag(speed);
    }
}
