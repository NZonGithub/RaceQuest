package com.noudzandbergen.hva.tetris;

import processing.core.PGraphics;

import java.util.ArrayList;

/**
 * @author Noud Zandbergen (http://www.NoudZandbergen.com/)
 */
public class Block {

	private static final ArrayList<Block> blocks = new ArrayList<>();

//	Standard blocks


	public static final Block EMPTY = new Block(0xff221f22, false) {

		private static final float scale = .8f;
		private static final float scaleNegHalf = (1-scale)/2;

		@Override
		public void draw(PGraphics graphics, float x, float y, float size, float time) {
			super.draw(graphics, x+size*scaleNegHalf, y+size*scaleNegHalf, size*scale, time);
		}

	};
//	public static final Block EMPTY = new Block(0xFF221F22, false) {
//
//		private static final float scaleBase = .55f;
//		private static final float scaleOffset = .45f;
//		private static final int secondaryColor = 0xFF221F22;
//
//		@Override
//		public void draw(PGraphics graphics, float x, float y, float size, float time) {
//	//			float offset = (x + y)*0.01f + Tetris.getInstance().frameCount/60f;
//			float offset = 0;
//			offset += (x + y) * 1e-3f;
//			offset += (x/size - y/size);
//			offset += time*2;
//			float scale = scaleBase + PApplet.sin(offset * PConstants.PI) * scaleOffset;
//	//			if (scale < 0) return;
//			float scaleNegHalf = (1 - scale) / 2;
//
////			graphics.fill(graphics.lerpColor(super.color, 0xffffffff, scale));
//			super.draw(graphics, x+size*scaleNegHalf, y+size*scaleNegHalf, size*scale, time);
////			graphics.fill(1, 0);
//		}
//
//	};
	public static final Block ROAD = new Block(0xff221f22, false) {

		private static final float scale = .8f;
		private static final float scaleNegHalf = (1-scale)/2;

		@Override
		public void draw(PGraphics graphics, float x, float y, float size, float time) {
			super.draw(graphics, x+size*scaleNegHalf, y+size*scaleNegHalf, size*scale, time);
		}

	};

	public static final Block WALL = new Block(0xffffffff, true);
	public static final Block RED = new Block(0xFFF94144, true);
	public static final Block ORANGE_RED = new Block(0xFFF3722C, true);
	public static final Block ORANGE = new Block(0xFFF8961E, true);
	public static final Block YELLOW = new Block(0xFFF9C74F, true);
	public static final Block GREEN = new Block(0xFF90BE6D, true);
	public static final Block CYAN = new Block(0xFF43AA8B, true);
	public static final Block BLUE = new Block(0xFF577590, true);

	public final int color;
	public final boolean doesCollide;
	public final int ID;

	public Block(int color, boolean doesCollide) {
		this.color = color;
		this.doesCollide = doesCollide;

		ID = blocks.size();
		blocks.add(this);
	}

	public boolean collide() {
		return doesCollide;
	}

	public void draw(PGraphics graphics, float x, float y, float size, float time) {

		int fillColor = (graphics.fillColor & 0xFF000000) == 0 ? color : graphics.fillColor;

		if (fillColor == 0) return;

		graphics.pushStyle();

		graphics.noStroke();
		graphics.fill(fillColor);
		graphics.rect(x, y, size, size);

		graphics.popStyle();

	}

	public static Block getBlock(int id) {
		if (id > blocks.size()) id = 0;
		return blocks.get(id);
	}

}
