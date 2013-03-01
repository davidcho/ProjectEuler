package util;

import java.math.BigInteger;

public class Power {
	public static BigInteger digitSum(BigInteger num) {
		BigInteger sum = BigInteger.ZERO;
		BigInteger ten = new BigInteger("10");
		while (num.compareTo(BigInteger.ZERO) > 0) {
			sum = sum.add(num.mod(ten));
			num = num.divide(ten);
		}
		System.out.println(sum);
		return sum;
	}

	public static BigInteger pow(BigInteger base, BigInteger exp) {
		if (exp.equals(BigInteger.ZERO))
			return BigInteger.ONE;
		BigInteger two = new BigInteger("2");
		BigInteger h = pow(base, exp.divide(two));
		h = h.pow(2);
		if (exp.mod(two).equals(BigInteger.ZERO))
			return h;
		return h.multiply(base);
	}

	public static void main(String[] args) {
		BigInteger one = new BigInteger("2");
		BigInteger two = new BigInteger("1000");
		digitSum(pow(one, two));
	}
}
