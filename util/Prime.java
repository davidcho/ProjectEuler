package util;

import java.math.BigInteger;

public class Prime {

	/**
	 * 
	 * @param n
	 *            n > 1
	 * @return whether n is a prime number
	 */
	public static boolean prime(int n) {
		assert (n > 1);
		if (n % 2 == 0)
			return false;
		int limit = (int) Math.sqrt(n);
		for (int i = 3; i <= limit; i += 2)
			if (n % i == 0)
				return false;
		return true;
	}

	/**
	 * 
	 * @param num
	 *            num > 0
	 * @return
	 */
	public static int nextPrime(int num) {
		if (num == 1)
			return 2;
		else if (num == 2)
			return 3;
		else
			num += 2;
		while (!prime(num))
			num += 2;
		return num;
	}

	/**
	 * 
	 * @param num
	 *            num > 0
	 * @return
	 */
	public static BigInteger nextBigPrime(BigInteger num) {
		if (num.intValue() == 1)
			return new BigInteger("2");
		else if (num.intValue() == 2)
			return new BigInteger("3");
		BigInteger two = new BigInteger("2");
		num = num.add(two);
		while (!prime(num.intValue()))
			num = num.add(two);
		return num;
	}

	/**
	 * Returns the n-th prime number
	 * 
	 * @param n
	 *            n > 0
	 * @return
	 */
	public static int nthPrime(int n) {
		int p = 1;
		while (n > 0) {
			p = nextPrime(p);
			n--;
		}
		return p;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BigInteger p = BigInteger.ONE;
		for (int i = 0; i < 10; i++) {
			p = nextBigPrime(p);
			System.out.println(p);
		}
	}
}
