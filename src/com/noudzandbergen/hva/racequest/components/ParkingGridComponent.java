package com.noudzandbergen.hva.racequest.components;

import com.noudzandbergen.hva.racequest.Car;
import com.noudzandbergen.hva.racequest.ParkingGrid;
import processing.core.PGraphics;
import processing.core.PVector;

public class ParkingGridComponent extends ParkingGrid {

	public ParkingGridComponent(int columns, int rows) {
		super(columns, rows);
	}

	public void update(float delta) {

	}

	public void draw(PGraphics g, PVector size, float time) {

		float cellWidth = size.x/columns;
		float cellHeight = size.y/rows;

		g.fill(0xff2f1f27);
		g.rect(0, 0, size.x, size.y);

		// Render tetris car grid
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				Car car = get(x, y);

				if (car == null) continue;

				g.pushMatrix();
				g.translate((x + .5f) * cellWidth, (y + .5f) * cellHeight);
				g.scale(cellWidth/6, cellHeight/6);

				car.draw(g);

				g.popMatrix();
			}
		}
	}

}
