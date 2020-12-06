package com.noudzandbergen.hva.tetris.layout;

import processing.core.PGraphics;
import processing.core.PVector;

import java.util.Arrays;

public class Column implements Renderable {

	public final Flex[] children;
	private final float totalFlexInv;

	public Column(Flex... children) {
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
					child.flex*totalFlexInv*size.x,
					size.y
			);

			g.push();
			child.renderable.render(g, size);
			g.pop();

			g.translate(childSize.x, 0);
		}
		g.popMatrix();
	}
}
