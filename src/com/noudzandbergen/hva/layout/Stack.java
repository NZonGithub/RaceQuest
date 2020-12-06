package com.noudzandbergen.hva.layout;

import processing.core.PGraphics;

import java.util.ArrayList;

public class Stack extends Widget {

	private final ArrayList<Widget> children = new ArrayList<>();

	public Stack addChild(Widget child) {
		children.add(child);
		return this;
	}

	public Stack addChildIf(Widget child, boolean condition) {
		if (condition) children.add(child);
		return this;
	}
}
