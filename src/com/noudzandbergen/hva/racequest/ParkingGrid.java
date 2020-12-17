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

	protected int getIndex(int x, int y) {
		// if (x < 0 || x >= columns || y < 0 || y >= rows) return -1;
		return y * columns + x;
	}

	public Car get(int x, int y) {
		return get(getIndex(x, y));
	}

	public Car get(int index) {
		if (index < 0 || index >= carGrid.length)
			return null;
		return carGrid[index];
	}

	public boolean checkCollision(int x, int y) {
		if (x < 0 || x >= columns || y >= rows)
			return true;
		if (y < 0)
			return false;
		return carGrid[y * columns + x] != null;
	}

	public void set(int x, int y, Car car) {
		set(getIndex(x, y), car);
	}

	public void set(int index, Car car) {
		if (index < 0 || index >= carGrid.length)
			return;
		carGrid[index] = car;
	}

	public void move(int x1, int y1, int x2, int y2) {
		int index = getIndex(x1, y1);
		set(x2, y2, get(index));
		set(index, null);
	}

	/**
	 * @return The full rows. Adding this because they might be needed elsewhere
	 */
	public ArrayList<RemovedCarRow> removeFullRows() {
		ArrayList<RemovedCarRow> removedRows = new ArrayList<>();

		for (int y = rows - 1; y >= 0; y--) {

			Car car;
			Car[] row = new Car[columns];
			int carsOnRow = 0;

			for (int x = 0; x < columns; x++)
				if ((car = get(x, y)) != null) {
					row[x] = car;
					carsOnRow++;
				}

			if (carsOnRow == columns) {
				removedRows.add(new RemovedCarRow(
						row,
						y
				));
				for (int x = 0; x < columns; x++)
					set(x, y, null);
			} else if (carsOnRow == 0)
				break;
			else if (removedRows.size() > 0)
				for (int x = 0; x < columns; x++)
					move(x, y, x, y + removedRows.size());
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
