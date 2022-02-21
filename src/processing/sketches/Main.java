package processing.sketches;

import processing.core.PApplet;

public class Main extends PApplet {
    public static PApplet sketch;
    private PaperStyle paperMode = PaperStyle.NONE;

    public enum PaperStyle {
        NONE,
        LINED,
        GRID,
        DOT,
        PRETTY
    }

    public void settings() {
        sketch = this;
        size(640, 960);
    }

    public void setup() {
        colorMode(HSB, 360, 100, 100);
    }

    public void draw() {
        background(360);

        switch(paperMode) {
            case LINED:
                drawLinedPaper(80, 100, 30);
                break;
            case GRID:
                drawGridPaper(24, true);
                break;
            case DOT:
                drawDotPaper(16, 3);
                break;
            case PRETTY:
                drawPrettyPaper();
                break;
        }

        menu();
    }

    public void drawLinedPaper(int leftMargin, int topMargin, int gapHeight) {
        // TODO: Finish this method.
    }

    public void drawGridPaper(int boxLength, boolean isEngineer) {
        // TODO: Finish this method.
    }

    public void drawDotPaper(int gap, int radius) {
        // TODO: Finish this method.
    }

    public void drawPrettyPaper() {
        // TODO: Finish this method.
    }



    // Below here should be left alone. //

    public void menu() {
        int radius = 20;
        int spacer = width / 6;
        int startY = radius / 2 + 10;

        noStroke();
        PaperStyle[] styles = PaperStyle.values();
        for (int item = 1; item < 6; item++) {
            fill(item * 50, 100, 100);
            ellipse(spacer * item, startY, radius, radius);

            if (dist(mouseX, mouseY, spacer * item, startY) < radius) {
                paperMode = styles[item - 1];
            }
        }
    }

    public static void main(String... args) {
        PApplet.main("processing.sketches.Main");
    }
}
