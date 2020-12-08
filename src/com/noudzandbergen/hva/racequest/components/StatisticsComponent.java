package com.noudzandbergen.hva.racequest.components;

import com.noudzandbergen.hva.racequest.RaceQuest;
import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PVector;

public class StatisticsComponent {
	private int row1 = 100;
	private int row2 = 200;
	private int row3 = 300;
	private int rowAnwsers = 400;

	private final RaceQuest game;

	public StatisticsComponent(RaceQuest game) {
		this.game = game;
	}

	public void update(float delta) {

	}

	public void draw(PGraphics g, PVector size, float time) {

		g.push();

		// Fill background
		g.fill(0xff000000);
		g.rect(0, 0, size.x, size.y);

		// Draw some random text
		g.fill(0xffffffff);
		g.textSize(30);
		g.textAlign(PConstants.CORNER, PConstants.CENTER);
		g.text("Current Place:", 0, row1);
		g.text("Current Highscore:", 0, row2);
		g.text("Laps:", 0, row3);
		g.text("highscore.place", rowAnwsers, row1);
		g.text("highscore", rowAnwsers, row2);
		g.text("laps.remaing, /3", rowAnwsers, row3);
		g.pop();

	}
}