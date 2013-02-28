package util;

public class Grid {
	/**
	 * Computes the number of possible ways of going from top left corner to
	 * bottom right corner by only moving down and right
	 * 
	 * @param n
	 *            Represents number of rows and columns of the grid
	 */
	public static int traverse(int n) {
		return traverse(0, 0, n, n);
	}

	public static int traverse(int xMax, int yMax) {
		return traverse(0, 0, xMax, yMax);
	}

	/**
	 * 
	 * @param x
	 *            Current x coor
	 * @param y
	 *            Current y coor
	 * @param xMax
	 *            Max x coor
	 * @param yMax
	 *            Max y coor
	 * @return
	 */
	public static int traverse(int x, int y, int xMax, int yMax) {
		// if x is at rightmost, then we have 2 cases:
		// (1) if y is at bottommost, then we are done
		// (2) else we can only move down to reach endpoint
		// if y is at bottommost, we can only move right to reach endpoint

		if (x == xMax)
			return y == yMax ? 0 : 1;
		else if (y == yMax)
			return 1;
		else if (x == y)
			return 2 * traverse(x + 1, y, xMax, yMax);
		else
			return traverse(x + 1, y, xMax, yMax)
					+ traverse(x, y + 1, xMax, yMax);
	}

	public static void main(String[] args) {
		// assert (traverse(2) == 6);
		for (int i = 20; i <= 20; i++) {
			long start = System.currentTimeMillis();
			System.out.println(i + ": " + traverse(i));
			System.out.println(System.currentTimeMillis() - start);
		}

		// // example that MxN takes same number of steps as NxM
		// System.out.println(traverse(5, 3));
		// System.out.println(traverse(3, 5));
	}
}
