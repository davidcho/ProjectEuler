package util;

public class Primitive {

	public static int intValue(char c) {
		return c - 48;
	}

	/**
	 * Converts a string into an integer
	 * 
	 * @param s
	 * @return
	 */
	public static int intValue(String s) {
		int num = 0;
		for (int i = 0; i < s.length(); i++) {
			num *= 10;
			num += s.charAt(i) - '0';
		}
		return num;
	}

	public static int getNumDivisors(int n) {
		int temp = n;
		if (n < 2)
			return 1;
		int prod = 1;
		int sum;
		for (int i = 2; i < n; i++) {
			sum = 1;
			while (temp % i == 0) {
				temp /= i;
				sum++;
			}
			if (sum > 1)
				prod *= sum;
		}
		return prod == 1 ? 2 : prod;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int x = (int) Math.pow(2, 5) * (int) Math.pow(3, 5)
				* (int) Math.pow(5, 5);
		System.out.println(getNumDivisors(x));
	}
}