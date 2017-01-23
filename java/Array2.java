/*
 * CodingBat Array-2
 * URL: http://codingbat.com/java/Array-2
 */
import java.util.*;

public class Array2 {

	/*
	 * countEvens([2, 1, 2, 3, 4]) → 3
	 * countEvens([2, 2, 0]) → 3
	 * countEvens([1, 3, 5]) → 0
	 */
	public int countEvens(int[] nums) {

		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 2 == 0)
				count++;
		}
		return count;
	}

	/*
	 * sum13([1, 2, 2, 1]) → 6
	 * sum13([1, 1]) → 2
	 * sum13([1, 2, 2, 1, 13]) → 6
	 */
	public int sum13(int[] nums) {

		int sum = 0;
		int count = 0;

		while (count < nums.length) {
			if (nums[count] == 13) {
				if (count == nums.length - 1) {
					sum = sum;
					break;
				} else {
					sum = sum;
					count += 2;
				}
			} else {
				sum += nums[count];
				count++;
			}
		}
		return sum;
	}

	/*
	 * lucky13([0, 2, 4]) → true
	 * lucky13([1, 2, 3]) → false
	 * lucky13([1, 2, 4]) → false
	 */
	public boolean lucky13(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1 || nums[i] == 3) {
				return false;
			}
		}
		return true;
	}

	/*
	 * fizzArray(4) → [0, 1, 2, 3]
	 * fizzArray(1) → [0]
	 * fizzArray(10) → [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]
	 */
	public int[] fizzArray(int n) {

		int[] rtn = new int[n];

		for (int i = 0; i < n; i++) {
			rtn[i] = i;
		}
		return rtn;
	}

	/*
	 * no14([1, 2, 3]) → true
	 * no14([1, 2, 3, 4]) → false
	 * no14([2, 3, 4]) → true
	 */
	public boolean no14(int[] nums) {

		boolean cont1 = false;
		boolean cont4 = false;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 1)
				cont1 = true;
			if (nums[i] == 4)
				cont4 = true;
			if (cont1 && cont4)
				return false;
		}
		return true;
	}

	/*
	 * matchUp([1, 2, 3], [2, 3, 10]) → 2
	 * matchUp([1, 2, 3], [2, 3, 5]) → 3
	 * matchUp([1, 2, 3], [2, 3, 3]) → 2
	 */
	public int matchUp(int[] nums1, int[] nums2) {

		int rtn = 0;
		assert (nums1.length == nums2.length);

		for (int i = 0; i < nums1.length; i++) {
			if (Math.abs(nums1[i] - nums2[i]) == 2
					|| Math.abs(nums1[i] - nums2[i]) == 1) {
				rtn++;
			}
		}
		return rtn;
	}

	/*
	 * modThree([2, 1, 3, 5]) → true
	 * modThree([2, 1, 2, 5]) → false
	 * modThree([2, 4, 2, 5]) → true
	 */
	public boolean modThree(int[] nums) {

		for (int i = 0; i < nums.length - 2; i++) {
			if ((isOdd(nums[i]) && isOdd(nums[i + 1]) && isOdd(nums[i + 2]))
					|| (!isOdd(nums[i]) && !isOdd(nums[i + 1]) && !isOdd(nums[i + 2]))) {
				return true;
			}
		}
		return false;
	}

	public boolean isOdd(int n) {
		if (n % 2 == 1)
			return true;
		else
			return false;
	}

	/*
	 * sameEnds([5, 6, 45, 99, 13, 5, 6], 1) → false
	 * sameEnds([5, 6, 45, 99, 13, 5, 6], 2) → true
	 * sameEnds([5, 6, 45, 99, 13, 5, 6], 3) → false
	 */
	public boolean sameEnds(int[] nums, int len) {

		if (len == 0) {
			return true;
		}

		String front = "";
		String reverse = "";

		for (int i = 0; i < len; i++) {
			front += nums[i];
			reverse += nums[nums.length - len + i];
		}
		if (front.equals(reverse)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * shiftLeft([6, 2, 5, 3]) → [2, 5, 3, 6]
	 * shiftLeft([1, 2]) → [2, 1]
	 * shiftLeft([1]) → [1]
	 */
	public int[] shiftLeft(int[] nums) {

		if (nums.length <= 1) {
			return nums;
		} else {
			final int first = nums[0];

			for (int i = 1; i < nums.length; i++) {
				nums[i - 1] = nums[i];
			}
			nums[nums.length - 1] = first;
			return nums;
		}
	}

	/*
	 * post4([2, 4, 1, 2]) → [1, 2]
	 * post4([4, 1, 4, 2]) → [2]
	 * post4([4, 4, 1, 2, 3]) → [1, 2, 3]
	 */
	public int[] post4(int[] nums) {

		int last4Index = -1;

		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] == 4) {
				last4Index = i;
				break;
			}
		}

		if (last4Index == -1) {
			return nums;
		} else {
			int[] rtn = new int[nums.length - (last4Index + 1)];

			for (int j = last4Index + 1; j < nums.length; j++) {
				rtn[j - (last4Index + 1)] = nums[j];
			}
			return rtn;
		}
	}

	/*
	 * withoutTen([1, 10, 10, 2]) → [1, 2, 0, 0]
	 * withoutTen([10, 2, 10]) → [2, 0, 0]
	 * withoutTen([1, 99, 10]) → [1, 99, 0]
	 */
	public int[] withoutTen(int[] nums) {

		int[] rtn = new int[nums.length];
		int count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != 10) {
				rtn[count] = nums[i];
				count++;
			}
		}
		return rtn;
	}

	/*
	 * fizzBuzz(1, 6) → ["1", "2", "Fizz", "4", "Buzz"]
	 * fizzBuzz(1, 8) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7"]
	 * fizzBuzz(1, 11) → ["1", "2", "Fizz", "4", "Buzz", "Fizz", "7", "8", "Fizz", "Buzz"]
	 */
	public String[] fizzBuzz(int start, int end) {

		String[] rtn = new String[end - start];

		for (int i = start; i < end; i++) {
			if (i % 3 == 0 && i % 5 == 0) {
				rtn[i - start] = "FizzBuzz";
			} else if (i % 3 == 0 && i % 5 != 0) {
				rtn[i - start] = "Fizz";
			} else if (i % 3 != 0 && i % 5 == 0) {
				rtn[i - start] = "Buzz";
			} else {
				rtn[i - start] = "" + i;
			}
		}
		return rtn;
	}

	/*
	 * bigDiff([10, 3, 5, 6]) → 7
	 * bigDiff([7, 2, 10, 9]) → 8
	 * bigDiff([2, 10, 7, 2]) → 8
	 */
	public int bigDiff(int[] nums) {

		int biggest = nums[0];
		int smallest = nums[0];

		for (int i = 1; i < nums.length; i++) {
			biggest = Math.max(biggest, nums[i]);
			smallest = Math.min(smallest, nums[i]);
		}
		return biggest - smallest;
	}

	/*
	 * sum67([1, 2, 2]) → 5
	 * sum67([1, 2, 2, 6, 99, 99, 7]) → 5
	 * sum67([1, 1, 6, 7, 2]) → 4
	 */
	public int sum67(int[] nums) {
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 6) {
				i = findSeven(nums, i);
			} else {
				sum += nums[i];
			}
		}
		return sum;
	}

	public int findSeven(int[] nums, int start) {

		for (int i = start; i < nums.length; i++) {
			if (nums[i] == 7)
				return i;
		}
		return 0;
	}

	/*
	 * sum28([2, 3, 2, 2, 4, 2]) → true
	 * sum28([2, 3, 2, 2, 4, 2, 2]) → false
	 * sum28([1, 2, 3, 4]) → false
	 */
	public boolean sum28(int[] nums) {

		int count = 0;

		for (int i : nums) {
			if (i == 2)
				count++;
		}

		if (count == 4)
			return true;
		else
			return false;
	}

	/*
	 * only14([1, 4, 1, 4]) → true
	 * only14([1, 4, 2, 4]) → false
	 * only14([1, 1]) → true
	 */
	public boolean only14(int[] nums) {

		for (int i : nums) {
			if (i != 1 && i != 4)
				return false;
		}
		return true;
	}

	/*
	 * isEverywhere([1, 2, 1, 3], 1) → true
	 * isEverywhere([1, 2, 1, 3], 2) → false
	 * isEverywhere([1, 2, 1, 3, 4], 1) → false
	 */
	public boolean isEverywhere(int[] nums, int val) {

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] != val && nums[i + 1] != val)
				return false;
		}
		return true;
	}

	/*
	 * has77([1, 7, 7]) → true
	 * has77([1, 7, 1, 7]) → true
	 * has77([1, 7, 1, 1, 7]) → false
	 */
	public boolean has77(int[] nums) {

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 7) {
				if (i == nums.length - 2) {
					if (nums[i + 1] == 7)
						return true;
				} else {
					if (nums[i + 1] == 7 || nums[i + 2] == 7)
						return true;
				}
			}
		}
		return false;
	}

	/*
	 * haveThree([3, 1, 3, 1, 3]) → true
	 * haveThree([3, 1, 3, 3]) → false
	 * haveThree([3, 4, 3, 3, 4]) → false
	 */
	public boolean haveThree(int[] nums) {

		int count = 0;

		if (nums.length < 5)
			return false;
		if (nums[0] == 3 && nums[1] != 3)
			count++;
		if (nums[nums.length - 1] == 3 && nums[nums.length - 2] != 3)
			count++;

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == 3) {
				if (nums[i - 1] != 3 && nums[i + 1] != 3) {
					count++;
				}
			}
		}

		if (count == 3)
			return true;
		else
			return false;
	}

	/*
	 * tripleUp([1, 4, 5, 6, 2]) → true
	 * tripleUp([1, 2, 3]) → true
	 * tripleUp([1, 2, 4]) → false
	 */
	public boolean tripleUp(int[] nums) {

		if (nums.length < 3)
			return false;

		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] + 1 == nums[i + 1] && nums[i + 1] + 1 == nums[i + 2])
				return true;
		}
		return false;
	}

	/*
	 * tenRun([2, 10, 3, 4, 20, 5]) → [2, 10, 10, 10, 20, 20]
	 * tenRun([10, 1, 20, 2]) → [10, 10, 20, 20]
	 * tenRun([10, 1, 9, 20]) → [10, 10, 10, 20]
	 */
	public int[] tenRun(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] % 10 == 0) {
				int theNextIndex = searchNextMultipleOf10(nums, i);
				if (theNextIndex != i) {
					for (int j = i; j < theNextIndex; j++) {
						nums[j] = nums[i];
					}
				} else {
					for (int j = i; j < nums.length; j++) {
						nums[j] = nums[i];
					}
				}
			}
		}
		return nums;
	}

	public int searchNextMultipleOf10(int[] nums, int index) {

		for (int i = index + 1; i < nums.length; i++) {
			if (nums[i] % 10 == 0) {
				return i;
			}
		}
		return index;
	}

	/*
	 * notAlone([1, 2, 3], 2) → [1, 3, 3]
	 * notAlone([1, 2, 3, 2, 5, 2], 2) → [1, 3, 3, 5, 5, 2]
	 * notAlone([3, 4], 3) → [3, 4]
	 */
	public int[] notAlone(int[] nums, int val) {

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] != nums[i - 1] && nums[i] != nums[i + 1]
					&& nums[i - 1] != nums[i + 1]) {
				nums[i] = Math.max(nums[i - 1], nums[i + 1]);
			}
		}
		return nums;
	}

	/*
	 * zeroMax([0, 5, 0, 3]) → [5, 5, 3, 3]
	 * zeroMax([0, 4, 0, 3]) → [3, 4, 3, 3]
	 * zeroMax([0, 1, 0]) → [1, 1, 0] 
	 */
	public int[] zeroMax(int[] nums) {

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				int theNextIndex = findTheNextIndex(nums, i);
				if (theNextIndex != i) {
					int theNextValue = nums[theNextIndex];
					for (int j = i; j < theNextIndex; j++) {
						if (nums[i] == 0) {
							nums[j] = theNextValue;
						}
					}
				} else {
					return nums;
				}
			}
		}
		return nums;
	}

	public int findTheNextIndex(int[] nums, int index) {
		int rtn = index;
		int comp = Integer.MIN_VALUE;
		for (int i = index; i < nums.length; i++) {
			if (nums[i] % 2 == 1) {
				if (nums[i] >= comp) {
					comp = nums[i];
					rtn = i;
				}
			}
		}
		if (comp == Integer.MIN_VALUE) {
			return index;
		} else {
			return rtn;
		}
	}

	/*
	 * centeredAverage([1, 2, 3, 4, 100]) → 3
	 * centeredAverage([1, 1, 5, 5, 10, 8, 7]) → 5
	 * centeredAverage([-10, -4, -2, -4, -2, 0]) → -3 
	 */
	public int centeredAverage(int[] nums) {

		int biggest = nums[0];
		int smallest = nums[0];
		int indexOfTheBiggest = 0;
		int indexOfTheSmallest = 0;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] >= biggest) {
				biggest = nums[i];
				indexOfTheBiggest = i;
			}
			if (nums[i] <= smallest) {
				smallest = nums[i];
				indexOfTheSmallest = i;
			}
		}

		int sum = 0;
		for (int j = 0; j < nums.length; j++) {
			if (j != indexOfTheBiggest && j != indexOfTheSmallest) {
				sum += nums[j];
			}
		}
		if (biggest == smallest) {
			sum -= biggest;
		}
		return sum / (nums.length - 2);
	}

	/*
	 * has22([1, 2, 2]) → true
	 * has22([1, 2, 1, 2]) → false
	 * has22([2, 1, 2]) → false
	 */
	public boolean has22(int[] nums) {

		if (nums.length == 2 && nums[0] == 2 && nums[1] == 2)
			return true;

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == 2) {
				if (nums[i - 1] == 2 || nums[i + 1] == 2)
					return true;
			}
		}
		return false;
	}

	/*
	 * more14([1, 4, 1]) → true
	 * more14([1, 4, 1, 4]) → false
	 * more14([1, 1]) → true
	 */
	public boolean more14(int[] nums) {

		int ones = 0;
		int fours = 0;

		for (int n : nums) {
			if (n == 1)
				ones++;
			else if (n == 4)
				fours++;
		}

		if (ones > fours)
			return true;
		else
			return false;
	}

	/*
	 * fizzArray2(4) → ["0", "1", "2", "3"]
	 * fizzArray2(10) → ["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"]
	 * fizzArray2(2) → ["0", "1"]
	 */
	public String[] fizzArray2(int n) {

		String[] rtn = new String[n];

		for (int i = 0; i < n; i++) {
			rtn[i] = "" + i;
		}
		return rtn;
	}

	/*
	 * either24([1, 2, 2]) → true
	 * either24([4, 4, 1]) → true
	 * either24([4, 4, 1, 2, 2]) → false
	 */
	public boolean either24(int[] nums) {

		boolean twoToTwo = false;
		boolean fourToFour = false;

		for (int i = 0; i < nums.length - 1; i++) {
			if (nums[i] == 2) {
				if (nums[i + 1] == 2)
					twoToTwo = true;
			} else if (nums[i] == 4) {
				if (nums[i + 1] == 4)
					fourToFour = true;
			}
		}

		if (twoToTwo == true && fourToFour == true)
			return false;
		else if ((twoToTwo == true && fourToFour != true)
				|| (twoToTwo != true && fourToFour == true))
			return true;
		else
			return false;
	}

	/*
	 * has12([1, 3, 2]) → true
	 * has12([3, 1, 2]) → true
	 * has12([3, 1, 4, 5, 2]) → true
	 */
	public boolean has12(int[] nums) {

		boolean oneFound = false;

		for (int n : nums) {
			if (n == 1)
				oneFound = true;
			if (oneFound == true) {
				if (n == 2)
					return true;
			}
		}
		return false;
	}

	/*
	 * twoTwo([4, 2, 2, 3]) → true
	 * twoTwo([2, 2, 4]) → true
	 * twoTwo([2, 2, 4, 2]) → false
	 */
	public boolean twoTwo(int[] nums) {

		if (nums.length == 0) {
			return true;
		} else if (nums.length == 1) {
			if (nums[0] == 2)
				return false;
			else
				return true;
		}

		for (int i = 1; i < nums.length - 1; i++) {
			if (nums[i] == 2) {
				if (nums[i - 1] != 2 && nums[i + 1] != 2)
					return false;
			}
		}

		if (nums[nums.length - 1] == 2 && nums[nums.length - 2] != 2)
			return false;
		return true;
	}

	/*
	 * fizzArray3(5, 10) → [5, 6, 7, 8, 9]
	 * fizzArray3(11, 18) → [11, 12, 13, 14, 15, 16, 17]
	 * fizzArray3(1, 3) → [1, 2]
	 */
	public int[] fizzArray3(int start, int end) {

		int[] rtn = new int[end - start];

		for (int i = start; i < end; i++) {
			rtn[i - start] = i;
		}
		return rtn;
	}

	/*
	 * pre4([1, 2, 4, 1]) → [1, 2]
	 * pre4([3, 1, 4]) → [3, 1]
	 * pre4([1, 4, 4]) → [1]
	 */
	public int[] pre4(int[] nums) {

		List<Integer> list = new LinkedList();
		int count = 0;
		while (count < nums.length) {
			if (nums[count] == 4) {
				break;
			} else {
				list.add(nums[count]);
			}
			count++;
		}

		int[] rtn = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			rtn[i] = list.get(i);
		}
		return rtn;
	}

	/*
	 * zeroFront([1, 0, 0, 1]) → [0, 0, 1, 1]
	 * zeroFront([0, 1, 1, 0, 1]) → [0, 0, 1, 1, 1]
	 * zeroFront([1, 0]) → [0, 1] 
	 */
	public int[] zeroFront(int[] nums) {

		if (nums.length == 0)
			return nums;

		List<Integer> list = new LinkedList();

		for (int n : nums) {
			list.add(n);
		}
		Collections.sort(list);

		if (list.get(0) < 0)
			Collections.reverse(list);

		int[] rtn = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			rtn[i] = list.get(i);
		}
		return rtn;
	}

	/*
	 * evenOdd([1, 0, 1, 0, 0, 1, 1]) → [0, 0, 0, 1, 1, 1, 1]
	 * evenOdd([3, 3, 2]) → [2, 3, 3]
	 * evenOdd([2, 2, 2]) → [2, 2, 2]
	 */
	public int[] evenOdd(int[] nums) {

		List<Integer> evenList = new LinkedList();
		List<Integer> oddList = new LinkedList();

		for (int n : nums) {
			if (n % 2 == 0)
				evenList.add(n);
			else
				oddList.add(n);
		}

		int[] rtn = new int[nums.length];
		for (int i = 0; i < evenList.size(); i++) {
			rtn[i] = evenList.get(i);
		}

		for (int j = 0; j < oddList.size(); j++) {
			rtn[evenList.size() + j] = oddList.get(j);
		}
		return rtn;
	}
}
