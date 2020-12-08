package com.noudzandbergen.hva.racequest.components;

import com.noudzandbergen.hva.racequest.RaceQuest;
import processing.core.PGraphics;
import processing.core.PVector;

public class RaceVisualizerComponent {

	private final RaceQuest game;

	public RaceVisualizerComponent(RaceQuest game) {
		this.game = game;
	}

	public void update(float delta) {

	}

	public void draw(PGraphics g, PVector size, float time) {
		g.fill(0xff00ffff);
		g.rect(0, 0, size.x, size.y);
	}
}
