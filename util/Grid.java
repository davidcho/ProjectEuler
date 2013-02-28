package util;

import java.math.BigInteger;

public class Grid {
	private BigInteger[] array;

	public Grid(int n) {
		array = new BigInteger[n - 1];
		for (int i = 0; i < array.length; i++)
			array[i] = null;
	}

	/**
	 * Computes the number of possible ways of going from top left corner to
	 * bottom right corner by only moving down and right
	 * 
	 * @param n
	 *            Represents number of rows and columns of the grid
	 */
	public BigInteger traverse(int n) {
		return traverse(0, 0, n);
	}

	/**
	 * 
	 * @param x
	 *            Current x coor
	 * @param y
	 *            Current y coor
	 * @param max
	 *            Max coor
	 * @return
	 */
	public BigInteger traverse(int x, int y, int max) {
		// if x is at rightmost, then we have 2 cases:
		// (1) if y is at bottommost, then we are done
		// (2) else we can only move down to reach endpoint
		// if y is at bottommost, we can only move right to reach endpoint

		if (x == max)
			return y == max ? BigInteger.ZERO : BigInteger.ONE;
		else if (y == max)
			return BigInteger.ONE;
		else if (x == y) {
			if (x == 0)
				return traverse(x + 1, y, max).multiply(new BigInteger("2"));
			else if (array[x - 1] != null)
				return array[x - 1];
			else {
				array[x - 1] = traverse(x + 1, y, max).multiply(
						new BigInteger("2"));
				return array[x - 1];
			}
		} else
			return traverse(x + 1, y, max).add(traverse(x, y + 1, max));
	}

	public static void main(String[] args) {
		int x = 20;

		String s = x + ": ";
		Grid g = new Grid(x);
		long start = System.currentTimeMillis();
		System.out.println(s + g.traverse(x));
		System.out.println(System.currentTimeMillis() - start);
		
		// Correct answer is: 137846528820
	}
}
