package com.noudzandbergen.hva.racequest;

/**
 * @author Noud Zandbergen (http://www.NoudZandbergen.com/)
 */
public class Shape {

	public final String name;

	// Center of the block
	public final float centerX;
	public final float centerY;

	public final Position[][] positions;


	public Shape(String name, float centerX, float centerY, int... positions) {
		this.name = name;
		this.centerX = centerX;
		this.centerY = centerY;
		this.positions = new Position[4][positions.length/2];
		for (int i = 0; i < this.positions.length; i++) {
			for (int j = 0; j < positions.length;) {
				this.positions[i][j/2] = new Position(positions[j], -positions[j+1]);

//				Rotate the position by 90 degrees for the next list of positions.
				int tmp = positions[j];
				positions[j++] = (int) (positions[j] - centerY + centerX);
				positions[j++] = (int) (-tmp + centerX + centerY);
			}
		}
	}

	public Position[] getPositions(int rotation) {
		return positions[rotation & 0b11];
	}

	public static class Position {

		public final int x, y;

		private Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
