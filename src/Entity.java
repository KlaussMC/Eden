import processing.core.*;

public abstract class Entity {

    PVector pos;
    PVector vel;
    ID id;

    PApplet p;

    public static int FORWARD, BACKWARD, LEFT, RIGHT;

    Entity(int x, int y, ID id) {
        pos = new PVector(x, y);
        vel = new PVector(0, 0);
        this.id = id;

        p = Main.processing;

        FORWARD = 1;
        BACKWARD = -1;
        LEFT = 2;
        RIGHT = -2;
    }

    void update() {
        this.pos.add(this.vel);
    }

    abstract void show();

    void move (int dir, int speed) {
        vel.mult(0);
        vel.add(1);
        System.out.println(vel.mag());
//        float angle = (dir * 90) * (p.PI/180);
//        vel.rotate(angle);
    }
}
