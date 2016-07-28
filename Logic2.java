/* CodingBat Logic-2
 * url: http://codingbat.com/java/Logic-2
 */

public class Logic2 {

	/*
	 * makeBricks(3, 1, 8) → true
	 * makeBricks(3, 1, 9) → false
	 * makeBricks(3, 2, 10) → true
	 */
	public boolean makeBricks(int small, int big, int goal) {

		int bigUsed = goal / 5;

		if (bigUsed > big) {
			if (goal - (big * 5) <= small)
				return true;
			else
				return false;
		} else {
			if (goal - (bigUsed * 5) <= small)
				return true;
			else
				return false;
		}
	}

	/*
	 * noTeenSum(1, 2, 3) → 6
	 * noTeenSum(2, 13, 1) → 3
	 * noTeenSum(2, 1, 14) → 3
	 */
	public int noTeenSum(int a, int b, int c) {

		a = fixTeen(a);
		b = fixTeen(b);
		c = fixTeen(c);
		return a + b + c;
	}

	private int fixTeen(int n) {

		if (n >= 13 && n <= 19) {
			if (n == 15 || n == 16) {
				return n;
			} else {
				return 0;
			}
		} else {
			return n;
		}
	}

	/*
	 * blackjack(19, 21) → 21
	 * blackjack(21, 19) → 21
	 * blackjack(19, 22) → 19
	 */
	public int blackjack(int a, int b) {

		if (a > 21 && b > 21) {
			return 0;
		} else if (a <= 21 && b > 21) {
			return a;
		} else if (a > 21 && b <= 21) {
			return b;
		} else {
			if (a > b) {
				return a;
			} else {
				return b;
			}
		}
	}

	/*
	 * loneSum(1, 2, 3) → 6
	 * loneSum(3, 2, 3) → 2
	 * loneSum(3, 3, 3) → 0
	 */
	public int loneSum(int a, int b, int c) {

		if (a == b && a == c) {
			return 0;
		} else if (a == b && a != c) {
			return c;
		} else if (a == c && a != b) {
			return b;
		} else if (b == c && a != b) {
			return a;
		} else {
			return a + b + c;
		}
	}

	/*
	 * roundSum(16, 17, 18) → 60
	 * roundSum(12, 13, 14) → 30
	 * roundSum(6, 4, 4) → 10
	 */
	public int roundSum(int a, int b, int c) {

		a = round10(a);
		b = round10(b);
		c = round10(c);
		return a + b + c;
	}

	private int round10(int num) {

		int rmndr = num % 10;
		if (rmndr >= 5) {
			num = num - rmndr + 10;
		} else {
			num = num - rmndr;
		}
		return num;
	}

	/*
	 * evenlySpaced(2, 4, 6) → true
	 * evenlySpaced(4, 6, 2) → true
	 * evenlySpaced(4, 6, 3) → false
	 */
	public boolean evenlySpaced(int a, int b, int c) {

		int mid = getMiddle(a, b, c);

		switch (mid) {
		case 0:
			return false;
		case 1:
			if (Math.abs(a - c) == Math.abs(a - b))
				return true;
			else
				return false;
		case 2:
			if (Math.abs(b - a) == Math.abs(b - c))
				return true;
			else
				return false;
		case 3:
			if (Math.abs(c - a) == Math.abs(c - b))
				return true;
			else
				return false;
		default:
			return true;
		}
	}

	private int getMiddle(int a, int b, int c) {
		if (a == b && a == c) {
			return -1;
		} else if ((a > b && c > a) || (a > c && b > a)) {
			return 1;
		} else if ((b > a && c > b) || (b > c && a > b)) {
			return 2;
		} else if ((c > a && b > c) || (c > b && a > c)) {
			return 3;
		} else {
			return 0;
		}
	}

	/*
	 * luckySum(1, 2, 3) → 6
	 * luckySum(1, 2, 13) → 3
	 * luckySum(1, 13, 3) → 1
	 */
	public int luckySum(int a, int b, int c) {

		int rtn = 0;

		if (a == 13) {
			rtn = rtn;
		} else {
			if (b == 13) {
				rtn += a;
			} else {
				if (c == 13) {
					rtn += (a + b);
				} else {
					rtn += (a + b + c);
				}
			}
		}
		return rtn;
	}

	/*
	 * closeFar(1, 2, 10) → true
	 * closeFar(1, 2, 3) → false
	 * closeFar(4, 1, 3) → true
	 */
	public boolean closeFar(int a, int b, int c) {

		if (Math.abs(a - b) == 1 || Math.abs(a - b) == 0) {
			if (Math.abs(a - c) >= 2 && Math.abs(b - c) >= 2) {
				return true;
			} else {
				return false;
			}
		} else if (Math.abs(a - c) == 1 || Math.abs(a - c) == 0) {
			if (Math.abs(a - b) >= 2 && Math.abs(b - c) >= 2) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	/*
	 * makeChocolate(4, 1, 9) → 4
	 * makeChocolate(4, 1, 10) → -1
	 * makeChocolate(4, 1, 7) → 2
	 */
	public int makeChocolate(int small, int big, int goal) {

		if (5 * big > goal) {
			int bigUsed = goal / 5;
			if (goal - (bigUsed * 5) <= small)
				return goal - (bigUsed * 5);
			else
				return -1;
		} else {
			if (goal - (big * 5) <= small)
				return goal - (big * 5);
			else
				return -1;
		}
	}
}
