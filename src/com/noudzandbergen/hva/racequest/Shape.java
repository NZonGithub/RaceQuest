package com.noudzandbergen.hva.racequest;

/**
 * @author Noud Zandbergen (http://www.NoudZandbergen.com/)
 */
public class Shape {

	public final String name;

	// Center of the block
	private final float anchorX;
	private final float anchorY;

	public final Position[][] positions;


	public Shape(String name, float anchorX, float anchorY, int... positions) {
		this.name = name;
		this.anchorX = anchorX;
		this.anchorY = anchorY;
		this.positions = new Position[4][positions.length/2];
		for (int i = 0; i < this.positions.length; i++) {
			for (int j = 0; j < positions.length;) {
				this.positions[i][j/2] = new Position(positions[j], -positions[j+1]);

//				Rotate the position by 90 degrees for the next list of positions.
				int tmp = positions[j];
				positions[j++] = (int) (positions[j] - anchorY + anchorX);
				positions[j++] = (int) (-tmp + anchorX + anchorY);
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
