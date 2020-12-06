package com.noudzandbergen.hva.racequest;

import java.util.ArrayList;

public class ParkingGrid {

	private final Car[] carGrid;
	public final int columns, rows;

	public ParkingGrid(int columns, int rows) {
		this.columns = columns;
		this.rows = rows;
		this.carGrid = new Car[columns * rows];
	}

	public Car get(int x, int y) {
		if (x < 0 || x >= columns || y < 0 || y >= rows) return null;
		return carGrid[y*columns+x];
	}

	public void set(int x, int y, Car car) {
		if (x < 0 || x >= columns || y < 0 || y >= rows) return;
		carGrid[y*columns+x] = car;
	}

	/**
	 * @return The full rows. Adding this because they might be need
	 */
	public ArrayList<RemovedCarRow> removeFullRows() {
		ArrayList<RemovedCarRow> removedRows = new ArrayList<>();

		for (int y = rows-1; y > 0; y--) {

			Car[] row = new Car[columns];

			int rowCarCount = 0;
			for (int x = 0; x < columns; x++) {
				Car car = get(x, y);

				if (car == null) continue;

				row[x] = car;
				rowCarCount++;

				if (removedRows.size() > 0) {
					set(x, y, null);
					set(x, y - removedRows.size(), car);
				}
			}

			if (rowCarCount == columns) {
				removedRows.add(new RemovedCarRow(
						row,
						y
				));
			} else if (rowCarCount == 0) {
				break;
			}

		}

		return removedRows;
	}

	public static class RemovedCarRow {

		public final Car[] items;
		public final int row;

		public RemovedCarRow(Car[] items, int row) {
			this.items = items;
			this.row = row;
		}
	}
}
