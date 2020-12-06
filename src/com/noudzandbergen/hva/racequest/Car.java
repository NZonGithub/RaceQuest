package com.noudzandbergen.hva.racequest;

import processing.core.PGraphics;
import processing.core.PImage;

public class Car {

	public final PImage sprite;
	private final float pixelRate;

	protected Car(PImage sprite, float pixelsPerMeter) {
		this.sprite = sprite;
		this.pixelRate = 1/pixelsPerMeter;
	}

	public void draw(PGraphics g) {
		if (sprite == null) return;

		g.pushMatrix();
		g.scale(pixelRate, pixelRate);
		g.image(sprite, 0, 0);
		g.popMatrix();
	}

}
