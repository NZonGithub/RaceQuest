package com.noudzandbergen.hva.tetris.layout;


import processing.core.PGraphics;
import processing.core.PVector;

import java.util.Arrays;

public class Row implements Renderable {

	public final Flex[] children;
	private final float totalFlexInv;

	public Row(Flex... children) {
		this.children = Arrays.stream(children).filter(flex -> flex != null && flex.flex != 0).toArray(Flex[]::new);

		int totalFlex = 0;
		for (Flex child : children) totalFlex += child.flex;
		this.totalFlexInv = 1f/totalFlex;
	}

	@Override
	public void render(PGraphics g, PVector size) {
		if (children.length == 0) return;

		g.pushMatrix();
		for (Flex child : children) {
			PVector childSize = new PVector(
					size.x,
					child.flex*totalFlexInv*size.y
			);

			g.push();
			child.renderable.render(g, size);
			g.pop();

			g.translate(0, childSize.y);
		}
		g.popMatrix();
	}
}
