package com.noudzandbergen.hva.tetris;

import processing.core.PApplet;
import processing.event.KeyEvent;

public class Tetris extends PApplet {

    private final BlockGrid grid = new BlockGrid(12, 24);
    private ShapeController shape = new ShapeController(grid);

    private long previousFrameTime = 0;
    private float time = 0;

    @Override
    public void setup() {
        this.previousFrameTime = frameRateLastNanos;
        noStroke();
    }

    @Override
    public void draw() {

//        Do updating

        float delta = (frameRateLastNanos - previousFrameTime)*1e-9f;
        if (delta > 0.5) delta = 0.16f;

        time += delta;

        previousFrameTime = frameRateLastNanos;

        shape.update(delta);

//        Do drawing



//        background(45, 42, 46);
//
//        fill(255, 0);
//        drawGrid(width*5/16f, height, time, true);
//        translate(width*5/16f, 0);
//
//        textSize(height/2f);
//        fill(0xFF221F22);
//
//        drawStats(width*11/16f, height, time);
    }

    public void drawGrid(float width, float height, float time, boolean fit) {

        if (fit) {
            Rectangle container = Util.fit(grid.width, grid.height, width, height, true);

            width = container.width;
            height = container.height;

            pushMatrix();
            translate(container.x, container.y);
        }

        float blockSize = height / grid.height;

        for (int y = 0; y < grid.height; y++) {
            for (int x = 0; x < grid.width; x++) {
                grid.get(x, y).draw(
                        g,
                        x*width/grid.width,
                        y*height/grid.height,
                        blockSize,
                        time
                );
            }
        }

        shape.draw(g, blockSize, time);

        if (fit) popMatrix();
    }

    public void drawStats(float width, float height, float time) {

        rect(0, 0, width, height);
        text(String.format("%d", grid.removedLines), width*.75f, height*.75f);

    }

    @Override
    public void settings() {
        fullScreen();
    }

    @Override
    public void keyPressed(KeyEvent event) {
        switch (event.getKey()) {
            case 'a':
                shape.moveBy(-1, 0);
                break;
            case 'w':
                shape.moveBy(0, -1);
                break;
            case 'd':
                shape.moveBy(1, 0);
                break;
            case 's':
                shape.moveBy(0, 1);
                break;
            case 'e':
                shape.rotate(false);
                break;
            case 'q':
                shape.rotate(true);
                break;
        }
    }

    public static void main(String[] args) {
	// write your code here
        Tetris.main(Tetris.class);
    }
}
