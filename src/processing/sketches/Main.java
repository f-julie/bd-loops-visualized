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

    /**
     * Draw horizontally lined paper
     * @param leftMargin the number of pixels to the left of the vertical line
     * @param topMargin the number of pixels above the first horizontal line
     * @param gapHeight the number of pixels between each horizontal line
     */
    public void drawLinedPaper(int leftMargin, int topMargin, int gapHeight) {
        stroke(0, 30, 100);
        line(leftMargin, 0, leftMargin, height);

        stroke(240, 30, 100);

        //While loop solution
        /*
        int lineNumber = 0;
        while (topMargin + lineNumber * gapHeight < height) {
            line(0, topMargin + lineNumber * gapHeight, width, topMargin + lineNumber * gapHeight);
            lineNumber++;
        }
        */

        //Another while loop solution
        //Note: In while loop, yCoord is still available outside the loop
        /*
        int yCoord = topMargin;
        while (yCoord < height) {
            line(0, yCoord, width, yCoord);
            yCoord += gapHeight;
        }
        */

        //Note: In for loop, yCoord is local (within curly brackets)
        for ( int yCoord = topMargin; yCoord < height; yCoord += gapHeight) {
            line(0, yCoord, width, yCoord);
        }
    }

    /**
     * Draws graph paper
     * @param boxLength the number of pixels between horizontal and vertical lines
     * @param isEngineer true if every 5th line should be bold, false otherwise
     */
    public void drawGridPaper(int boxLength, boolean isEngineer) {
        // Vertical
        stroke(0, 30, 100);

        int lineNumber = 0;
        for ( int x = boxLength; x < width; x += boxLength) {
            if (lineNumber % 5 == 0) {
                strokeWeight(3);
            } else {
                strokeWeight(1);
            }
            line(x, 0, x, height);
            lineNumber++;
        }

        // Horizontal
        stroke(230, 30, 100);

        lineNumber = 1;
        for ( int y = boxLength; y < height; y += boxLength) {
            if (lineNumber % 5 == 0) {
                strokeWeight(3);
            } else {
                strokeWeight(1);
            }
            line(0, y, width, y);
            lineNumber++;
        }

        // Another solution
        /*
        for (int counter = 1; ; counter++) {
            if (counter % 5 == 1) {
                strokeWeight(3);
            } else {
                strokeWeight(1);
            }
            line(counter * boxLength, 0, counter * boxLength, height);
        }
         */
    }

    /**
     * Draw dots to cover the entire screen with gaps between each
     * @param gap the number of pixels between each dot
     * @param radius the radius of one dot
     */
    public void drawDotPaper(int gap, int radius) {
        stroke(230, 30, 100);

        // Outer loop chooses a value
            // Inner loop then does all of its values, when finished outer loop changes once

        for (int x = 0; x < width; x += gap) {
            for (int y = 0; y < height; y += gap) {
                ellipse(x, y, 2 * radius, 2 * radius);
            }
        }
    }


    public void drawPrettyPaper() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                // Each and every (x, y) combination
                int chosenColor = color((float) x / width * 360, (float) y / height * 100, 100); // x is hue, y is saturation, 100 is brightness
                set(x, y, chosenColor);
            }
        }
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
