package util;

public class Palindrone {

	public static boolean isPalindrone(int n) {
		String s = "" + n;
		int start = 0;
		int end = s.length() - 1;
		
		while (start < end) {
			if (s.charAt(start++) != s.charAt(end--))
				return false;
		}
		return true;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(isPalindrone(0));
	}

}
