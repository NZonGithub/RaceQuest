package com.noudzandbergen.hva.tetris.layout;

import processing.core.PApplet;
import processing.core.PVector;

public class Test extends PApplet {

	Renderable layout;

	@Override
	public void settings() {
		fullScreen();
	}

	@Override
	public void setup() {
		layout = new Column(
				new Flex(new ColorBox(0xff2f272f), 5),
				new Flex(
						new Row(
								new Flex(new ColorBox(0xff00ffff), 2),
								new Flex(new ColorBox(0xff1f171f), 1)
						), 11
				)
		);
	}

	@Override
	public void draw() {
		clear();

		layout.render(g, new PVector(width, height));
	}

	public static void main(String[] args) {
		main(Test.class);
	}
}
