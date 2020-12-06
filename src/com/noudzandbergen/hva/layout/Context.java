package com.noudzandbergen.hva.layout;

import processing.core.PApplet;
import processing.core.PVector;

public class Context {

	private PVector size;
	private final PApplet applet;

	public Context(PApplet applet) {
		this.applet = applet;
	}

	public PApplet getApplet() {
		return applet;
	}

	public float getWidth() {
		return size.x;
	}

	public float getHeight() {
		return size.y;
	}
}
