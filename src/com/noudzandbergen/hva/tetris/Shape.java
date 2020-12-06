package com.noudzandbergen.hva.tetris;

import processing.core.PGraphics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author Noud Zandbergen (http://www.NoudZandbergen.com/)
 */
public enum Shape {

	I(Block.RED, .5f, -.5f,-1, 0, 2, 0, 1, 0, 0, 0),
	J(Block.ORANGE_RED, 0, 0, -1, 0, 1, 0, -1, 1, 0, 0),
	L(Block.ORANGE, 0, 0, -1, 0, 1, 0, 1, -1, 0, 0),
	O(Block.YELLOW, .5f, -.5f, 0, 0, 1, 0, 1, -1, 0, -1),
	S(Block.GREEN, 0, 0, -1, 0, 1, -1, 0, -1, 0, 0),
	Z(Block.CYAN, 0, 0, 1, 0, -1, -1, 0, -1, 0, 0),
	T(Block.BLUE, 0, 0, -1, 0, 1, 0, 0, -1, 0, 0);

	private static final Shape[] shapes = Shape.values();

	public final List<List<BlockPosition>> rotatedPositionsLists;

	public final Block block;

	private final float anchorX;
	private final float anchorY;

	Shape(Block block, float anchorX, float anchorY, int... positions) {

		this.block = block;
		this.anchorX = anchorX;
		this.anchorY = anchorY;

		ArrayList<List<BlockPosition>> list = new ArrayList<>();
		for (int i = 0; i < 4; i++) {
			ArrayList<BlockPosition> current = new ArrayList<>();

			for (int j = 0; j < positions.length;) {

				current.add(new BlockPosition(positions[j], -positions[j+1]));

//				Rotate the position by 90 degrees for the next list of positions.
				int tmp = positions[j];

				positions[j++] = (int) (positions[j] - anchorY + anchorX);
				positions[j++] = (int) (-tmp + anchorX + anchorY);

			}

			current.trimToSize();
			list.add(Collections.unmodifiableList(current));
		}

//		Make sure the list is the right size and then store it as an unmodifiableList.
		list.trimToSize();
		rotatedPositionsLists = Collections.unmodifiableList(list);
	}

	public void draw(PGraphics graphics, float x, float y, float blockSize, float rotation, float time) {

		if (block.color == 0) return;

		graphics.pushMatrix();

		graphics.translate(x+blockSize, y+blockSize);
		graphics.rotate(rotation);
		graphics.translate(-(.5f+anchorX)*blockSize, -(.5f-anchorY)*blockSize);

		for (BlockPosition pos : rotatedPositionsLists.get(0)) {
			block.draw(graphics, pos.x * blockSize, pos.y * blockSize, blockSize, time);
		}

		graphics.popMatrix();

	}

	public List<BlockPosition> getPositions(int rotation) {
		return rotatedPositionsLists.get(rotation & 0b11);
	}

	public static class BlockPosition {

		public final int x, y;

		private BlockPosition(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static Shape getRandom() {
		return shapes[(int) (Math.random() * shapes.length)];
	}

}
