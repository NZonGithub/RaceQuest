package com.noudzandbergen.hva.racequest.components;

import com.noudzandbergen.hva.racequest.Car;
import com.noudzandbergen.hva.racequest.ParkingGrid;
import com.noudzandbergen.hva.racequest.RaceQuest;
import com.noudzandbergen.hva.racequest.util.Util;
import processing.core.PGraphics;
import processing.core.PVector;

public class ParkingGridComponent extends ParkingGrid {

	private final RaceQuest game;

	public ParkingGridComponent(RaceQuest game, int columns, int rows) {
		super(columns, rows);
		this.game = game;

		// Fill up this grid to test rendering.
		for (int y = 0; y < rows; y++) {
			for (int x = 0; x < columns; x++) {
				set(x, y, Util.getRandomItem(game.cars));
			}
		}
	}

	public void update(float delta) {

	}

	public void draw(PGraphics g, PVector size, float time) {

		g.pushMatrix();

		// Flip the coordinate system so positive y values go upwards.
		g.translate(0, size.y);
		g.scale(1, -1);

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

		g.popMatrix();
	}

}
