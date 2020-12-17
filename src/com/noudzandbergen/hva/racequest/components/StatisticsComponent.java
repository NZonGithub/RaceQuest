package com.noudzandbergen.hva.racequest.components;

import com.noudzandbergen.hva.racequest.RaceQuest;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PVector;

public class StatisticsComponent {

	private final RaceQuest game;

	public StatisticsComponent(RaceQuest game) {
		this.game = game;
	}

	public void update(float delta) {

	}

	public void draw(PGraphics g, PVector size, float time) {
		g.push();

		// Fill / Clear background
		g.fill(0xff000000);
		g.rect(0, 0, size.x, size.y);

		float cellWidth = size.x/2f, cellHeight = size.y/3f;

		// Draw some random text
		g.fill(0xffffffff);
		g.textSize(cellHeight/3);
		g.textAlign(PConstants.CENTER, PConstants.CENTER);

		g.text("Current Place:", cellWidth * 0.5f, cellHeight * 0.5f);
		g.text("Current Highscore:", cellWidth * 0.5f, cellHeight * 1.5f);
		g.text("Laps:", cellWidth * 0.5f, cellHeight * 2.5f);

		g.text("1st", cellWidth * 1.5f, cellHeight * 0.5f);
		g.text(game.score, cellWidth * 1.5f, cellHeight * 1.5f);
		g.text("2 / 3", cellWidth * 1.5f, cellHeight * 2.5f);

		g.pop();
	}
}