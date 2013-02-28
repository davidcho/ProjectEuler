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
		return traverse(0, 0, n);
	}

	private static int traverse(int x, int y, int n) {
		// if x is at rightmost, then we have 2 cases:
		// (1) if y is at bottommost, then we are done
		// (2) else we can only move down to reach endpoint
		// if y is at bottommost, we can only move right to reach endpoint

		if (x == n)
			return y == n ? 0 : 1;
		else if (y == n)
			return 1;
		else
			return traverse(x + 1, y, n) + traverse(x, y + 1, n);
	}

	public static void main(String[] args) {
		assert (traverse(2) == 6);
	}
}
