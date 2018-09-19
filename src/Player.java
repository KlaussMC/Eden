public class Player extends Entity {
    Player (int x, int y, ID id) {
        super(x, y, id);
    }

    void show() {
        p.noStroke();
        p.fill(90, 255, 255);
        p.rect(pos.x, pos.y, Main.SCL, Main.SCL);
    }
}
