package util;

import java.math.BigInteger;

public class Grid {
	/**
	 * Computes the number of possible ways of going from top left corner to
	 * bottom right corner by only moving down and right
	 * 
	 * @param n
	 *            Represents number of rows and columns of the grid
	 */
	public static BigInteger traverse(int n) {
		return traverse(0, 0, n, n);
	}

	public static BigInteger traverse(int xMax, int yMax) {
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
	public static BigInteger traverse(int x, int y, int xMax, int yMax) {
		// if x is at rightmost, then we have 2 cases:
		// (1) if y is at bottommost, then we are done
		// (2) else we can only move down to reach endpoint
		// if y is at bottommost, we can only move right to reach endpoint

		if (x == xMax)
			return y == yMax ? BigInteger.ZERO : BigInteger.ONE;
		else if (y == yMax)
			return BigInteger.ONE;
		else if (x == y)
			return traverse(x + 1, y, xMax, yMax).multiply(new BigInteger("2"));
		else
			return traverse(x + 1, y, xMax, yMax).add(
					traverse(x, y + 1, xMax, yMax));
	}

	public static void main(String[] args) {
		// assert (traverse(2) == 6);
		for (int i = 18; i <= 18; i++) {
			long start = System.currentTimeMillis();
			System.out.println(i + ": " + traverse(i));
			System.out.println(System.currentTimeMillis() - start);
		}

		// // example that MxN takes same number of steps as NxM
		// System.out.println(traverse(5, 3));
		// System.out.println(traverse(3, 5));
	}
}
