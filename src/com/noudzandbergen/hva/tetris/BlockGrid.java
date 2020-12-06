package com.noudzandbergen.hva.tetris;

import java.util.Arrays;

public class BlockGrid {

	public final int width;
	public final int height;
	private final int[] grid;

	public int removedLines;

	public BlockGrid(int width, int height) {
		this.width = width;
		this.height = height;
		grid = new int[width * height];
		Arrays.fill(grid, Block.EMPTY.ID);
	}

	public Block get(int x, int y) {
		if (
				x < 0 || x >= width ||
				y < 0 || y >= height
		) return Block.WALL;
		return Block.getBlock(grid[y*width+x]);
	}

	public boolean set(int x, int y, Block block) {
		if (
				x < 0 || x >= width ||
				y < 0 || y >= height
		) return false;

		int index = y*width+x;

		if (grid[index] == Block.ROAD.ID) return false;
		grid[index] = block.ID;
		return true;
	}

	public void removeFilledLines() {
		int moveDownBy = 0;
		for (int y = height-1; y >= 0; y--) {

			int blockCount = 0;
			for (int x = 0; x < width; x++) {

				Block block = get(x, y);

				if (block.collide()) {
					blockCount++;
					set(x, y, Block.EMPTY);
					set(x, y+moveDownBy, block);
				}
			}

			if (blockCount == width) {
				moveDownBy += 1;
				for (int x = 0; x < width; x++) set(x, y, Block.EMPTY);
				removedLines++;
			} else if (blockCount == 0) break;
		}
	}

}
