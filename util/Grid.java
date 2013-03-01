package util;

import java.math.BigInteger;
import java.util.Hashtable;

public class Grid {
	/**
	 * Computes the number of possible ways of going from top left corner to
	 * bottom right corner by only moving down and right
	 * 
	 * @param n
	 *            Represents number of rows and columns of the grid
	 */
	public static BigInteger traverse(int n) {
		Hashtable<String, BigInteger> database = new Hashtable<String, BigInteger>();
		return traverse(0, 0, n, database);
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
	public static BigInteger traverse(int x, int y, int max,
			Hashtable<String, BigInteger> database) {
		// if x is at rightmost, then we have 2 cases:
		// (1) if y is at bottommost, then we are done
		// (2) else we can only move down to reach endpoint
		// if y is at bottommost, we can only move right to reach endpoint

		if (x == max)
			return y == max ? BigInteger.ZERO : BigInteger.ONE;
		else if (y == max)
			return BigInteger.ONE;

		if (database.get(x + " " + y) == null)
			if (x == y)
				database.put(x + " " + y, traverse(x + 1, y, max, database)
						.multiply(new BigInteger("2")));
			else
				database.put(x + " " + y, traverse(x + 1, y, max, database)
						.add(traverse(x, y + 1, max, database)));
		return database.get(x + " " + y);
	}

	public static void main(String[] args) {
		int x = 20;
		long start = System.currentTimeMillis();
		System.out.println(x + ": " + Grid.traverse(x));
		System.out.println(System.currentTimeMillis() - start);
		// Correct answer is: 137846528820
	}
}
