package com.noudzandbergen.hva.tetris.layout;

public class Flex {

	public final int flex;
	public final Renderable renderable;

	public Flex(Renderable renderable, int flex) {
		this.renderable = renderable;
		this.flex = flex;
	}

	public Flex(Renderable renderable) {
		this.renderable = renderable;
		this.flex = 1;
	}
}
