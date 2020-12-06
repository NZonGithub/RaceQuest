package com.noudzandbergen.hva.tetris;

import processing.core.PConstants;
import processing.core.PGraphics;
import processing.core.PVector;

public class ShapeController {

	private Shape shape = Shape.I;

	private int x = 5;
	private int y = 0;
	private int rotation = 0;

	private PVector drawPosition = new PVector(x, y);
	private float drawRotation = 0;

	private float moveInterval = .5f;
	private float timeSinceLastMove = 0;

	private BlockGrid grid;

	public ShapeController(BlockGrid grid) {
		this.grid = grid;
	}

	public BlockGrid getGrid() {
		return grid;
	}

	public void update(float delta) {

		timeSinceLastMove += delta;

		if (timeSinceLastMove > moveInterval) {
			y++;

			if (checkBounds()) {
				y--;

				reset();
			}

			timeSinceLastMove -= moveInterval;
		}

		PVector deltaPos = new PVector(x, y).sub(drawPosition);

		drawPosition.add(deltaPos.mult(delta/moveInterval*4));

		float deltaRot = rotation * PConstants.HALF_PI - drawRotation;

		drawRotation += deltaRot * delta/moveInterval*4;
	}

	public void draw(PGraphics graphics, float blockSize, float time) {
//		shape.draw(graphics, drawPosition.x*blockSize, drawPosition.y*blockSize, blockSize, drawRotation, time);
//
//		graphics.fill(0x7F000000 | shape.block.color & 0x00FFFFFF);

		for (Shape.BlockPosition position : shape.getPositions(rotation))
			shape.block.draw(graphics, (x + position.x) * blockSize, (y + position.y) * blockSize, blockSize, time);

//		shape.draw(graphics, x *blockSize, y *blockSize, blockSize, rotation * PConstants.HALF_PI, time);
	}

	private boolean checkBounds() {
		for (Shape.BlockPosition position : shape.getPositions(rotation))
			if (grid.get(x + position.x, y + position.y).collide())
				return true;

		return false;
	}

	public void rotate(boolean counterClockwise) {
		int oldRot = rotation;

		rotation = (counterClockwise ? rotation - 1 : rotation + 1) & 3;

		if (checkBounds()) rotation = oldRot;
	}

	public void moveBy(int x, int y) {
		this.x += x;
		this.y += y;

		if (checkBounds()) {
			this.x -= x;
			this.y -= y;
		}
	}

	private void write() {
		for (Shape.BlockPosition position : shape.getPositions(rotation))
			grid.set(x + position.x, y + position.y, shape.block);
	}

	private void reset() {

		for (Shape.BlockPosition position : shape.getPositions(rotation))
			grid.set(x + position.x, y + position.y, shape.block);

		x = 5;
		y = 0;

		grid.removeFilledLines();

		shape = Shape.getRandom();
	}

}
