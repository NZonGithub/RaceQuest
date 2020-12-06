package com.noudzandbergen.hva.tetris.layout;

import processing.core.PGraphics;
import processing.core.PVector;

import java.util.Arrays;
import java.util.Objects;

public class Stack implements Renderable {

	public final Renderable[] children;

	public Stack(Renderable... children) {
		this.children = Arrays.stream(children).filter(Objects::nonNull).toArray(Renderable[]::new);
	}

	@Override
	public void render(PGraphics g, PVector size) {
		if (children.length == 0) return;

		for (Renderable child : children) {
			g.push();
			child.render(g, size);
			g.pop();
		}
	}
}
