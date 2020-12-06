package com.noudzandbergen.hva.racequest.components;

import processing.core.PGraphics;
import processing.core.PVector;

public class StatisticsComponent {

	public void update(float delta) {

	}

	public void draw(PGraphics g, PVector size, float time) {
		g.fill(0xffffffff);
		g.rect(0, 0, size.x, size.y);
	}
}