import processing.core.PApplet;

import java.awt.*;

public class Terrain {

    public static Color[] colors = {
            new Color(142, 78, 5),
            new Color(142, 78, 5),
            new Color(28, 142, 5),
            new Color(28, 142, 5),
            new Color(5, 84, 142),
            new Color(198, 182, 14),
            new Color(198, 182, 14),
            new Color(56, 58, 71),
            new Color(56, 58, 71)
    };

    public static boolean[] solids = {true, true, false, true};

    public static int[][] generateTerrain(int width, int height, PApplet p) {

        int[][] terrain = new int[width][height];

        float increment = 0.01f; // this number is variation. the bigger it is, the more change in terrain.
        float xoff = 0.0f;

        for (int i = 0; i < width; i++) {
            xoff += increment;
            float yoff = 0.0f;

            for (int j = 0; j < height; j++) {
                yoff += increment;
                float n = p.noise(xoff, yoff);
                int number = p.floor(n * colors.length);
                terrain[i][j] = number;
            }
        }

        return terrain;
    }

    public static Color getBackground(int key) {
        return colors[key];
    }

    public static boolean solid (int key) {
        return solids[key];

    }
}
