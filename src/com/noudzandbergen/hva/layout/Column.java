package com.noudzandbergen.hva.layout;

import processing.core.PGraphics;

import java.util.ArrayList;

public class Column extends Widget {

	private final ArrayList<Widget> children = new ArrayList<>();

	public Column addChild(Widget child) {
		children.add(child);
		return this;
	}

	public Column addChildIf(Widget child, boolean condition) {
		if (condition) children.add(child);
		return this;
	}

	@Override
	public void draw(Context context, PGraphics g) {

	}
}
