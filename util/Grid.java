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
		return 0;
	}

	public static void main(String[] args) {

	}
}
