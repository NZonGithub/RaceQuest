package com.noudzandbergen.hva.tetris.layout;

import processing.core.PGraphics;
import processing.core.PVector;

public class ColorBox implements Renderable {

	public final int color;

	public ColorBox(int color) {
		this.color = color;
	}

	@Override
	public void render(PGraphics g, PVector size) {

		g.noStroke();
		g.fill(color);
		g.rect(0, 0, size.x, size.y);
	}
}
