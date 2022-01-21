package processing.sketches;

import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet sketch;

    final int TILESIZE = 50;

    public void settings() {
        sketch = this;
        size(600, 600);
    }

    public void setup() {
        //noStroke();
        colorMode(HSB);
    }

    public void draw() {
        background(0);

    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
