/*
 * CodingBat String-3
 * URL: http://codingbat.com/java/String-3
 */
import java.util.*;

public class String3 {

	/*
	 * countYZ("fez day") → 2 
	 * countYZ("day fez") → 2 
	 * countYZ("day fyyyz") → 2
	 */
	public int countYZ(String str) {

		int count = 0;

		for (int i = 0; i < str.length(); i++) {
			if (!Character.isLetter(str.charAt(i)) && i != 0) {
				if (str.toLowerCase().charAt(i - 1) == 'y'
						|| str.toLowerCase().charAt(i - 1) == 'z') {
					count++;
				}
			}
		}

		if (str.toLowerCase().endsWith("y") || str.toLowerCase().endsWith("z"))
			count++;
		return count;
	}

	/*
	 * gHappy("xxggxx") → true 
	 * gHappy("xxgxx") → false 
	 * gHappy("xxggyygxx") → false
	 */
	public boolean gHappy(String str) {

		if (str.length() == 1)
			return false;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'g') {
				if (i == 0) {
					if (str.charAt(i + 1) != 'g')
						return false;
				} else if (i == str.length() - 1) {
					if (str.charAt(i - 1) != 'g')
						return false;
				} else {
					if (str.charAt(i - 1) != 'g' && str.charAt(i + 1) != 'g')
						return false;
				}
			}
		}
		return true;
	}

	/*
	 * sameEnds("abXYab") → "ab" 
	 * sameEnds("xx") → "x" 
	 * sameEnds("xxx") → "x"
	 */
	public String sameEnds(String string) {

		String rtn = "";

		for (int i = 0; i <= string.length() / 2; i++) {
			for (int j = string.length() - 1; j >= string.length() / 2; j--) {
				if (string.substring(0, i).equals(string.substring(j))) {
					rtn = string.substring(0, i);
				}
			}
		}
		return rtn;
	}

	/*
	 * sumNumbers("abc123xyz") → 123 
	 * sumNumbers("aa11b33") → 44
	 * sumNumbers("7 11") → 18
	 */
	public int sumNumbers(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				sum += getKVSet(str, i).getKey();
				i += getKVSet(str, i).getValue();
			}
		}
		return sum;
	}

	public AbstractMap.SimpleEntry<Integer, Integer> getKVSet(String str,
			int start) {
		String rtn = "";
		int index = 0;
		for (int i = start; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				rtn += "" + str.charAt(i);
				if (i == str.length() - 1) {
					index = i - start;
					break;
				}
			} else {
				index = i - start;
				break;
			}
		}
		return new AbstractMap.SimpleEntry(Integer.parseInt(rtn), index);
	}

	/*
	 * withoutString("Hello there", "llo") → "He there"
	 * withoutString("Hello there", "e") → "Hllo thr"
	 * withoutString("Hello there", "x") → "Hello there"
	 */
	public String withoutString(String base, String remove) {

		String rtn = "";
		int count = 0;
		int max = base.length() - remove.length();

		while (count <= max) {
			if ((base.substring(count, count + remove.length()))
					.equalsIgnoreCase(remove)) {
				count += remove.length();
			} else {
				rtn += base.charAt(count);
				count++;
			}
		}

		rtn += base.substring(count);
		return rtn;
	}

	/*
	 * countTriple("abcXXXabc") → 1 
	 * countTriple("xxxabyyyycd") → 3
	 * countTriple("a") → 0
	 */
	public int countTriple(String str) {

		int count = 0;

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == str.charAt(i + 1)
					&& str.charAt(i + 1) == str.charAt(i + 2))
				count++;
		}
		return count;
	}

	/*
	 * mirrorEnds("abXYZba") → "ab" 
	 * mirrorEnds("abca") → "a" 
	 * mirrorEnds("aba") → "aba"
	 */
	public String mirrorEnds(String string) {

		String rtn = "";
		String reverse = "";

		for (int i = string.length() - 1; i >= 0; i--) {
			reverse += "" + string.charAt(i);
		}

		if (string.equals(reverse))
			return string;

		for (int j = 0; j < string.length(); j++) {
			String str = string.substring(0, j);
			if (reverse.startsWith(str)) {
				rtn = str;
			}
		}
		return rtn;
	}

	/*
	 * notReplace("is test") → "is not test" 
	 * notReplace("is-is") → "is not-is not" 
	 * notReplace("This is right") → "This is not right"
	 */
	public String notReplace(String str) {

		List<Integer> list = searchForTheIndexes(str);
		String rtn = "";
		int count = 0;

		while (count < str.length()) {
			if (list.contains(count)) {
				rtn += "is not";
				count += 2;
			} else {
				rtn += str.charAt(count);
				count++;
			}
		}
		return rtn;
	}

	public List<Integer> searchForTheIndexes(String str) {

		List<Integer> rtn = new LinkedList();

		if (str.length() < 3) {
			if (str.equals("is")) {
				rtn.add(0);
			}
			return rtn;
		}

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i + 2).equals("is")) {

				if ((i == 0 && !Character.isLetter(str.charAt(i + 2)))
						|| (i == str.length() - 2 && !Character.isLetter(str
								.charAt(i - 1)))
						|| ((i > 0 && i < str.length() - 2)
								&& !Character.isLetter(str.charAt(i - 1)) && !Character
									.isLetter(str.charAt(i + 2)))) {
					rtn.add(i);
				}
			}
		}
		return rtn;
	}

	/*
	 * equalIsNot("This is not") → false 
	 * equalIsNot("This is notnot") → true
	 * equalIsNot("noisxxnotyynotxisi") → true
	 */
	public boolean equalIsNot(String str) {

		int countIs = 0;
		int countNot = 0;

		for (int i = 0; i < str.length() - 1; i++) {
			if (str.substring(i, i + 2).equals("is"))
				countIs++;
		}

		for (int j = 0; j < str.length() - 2; j++) {
			if (str.substring(j, j + 3).equals("not"))
				countNot++;
		}

		if (countIs == countNot)
			return true;
		else
			return false;
	}

	/*
	 * sumDigits("aa1bc2d3") → 6 
	 * sumDigits("aa11b33") → 8 
	 * sumDigits("Chocolate") → 0
	 */
	public int sumDigits(String str) {

		List<Integer> list = new LinkedList();

		for (int i = 0; i < str.length(); i++) {
			if (Character.isDigit(str.charAt(i))) {
				list.add(Integer.parseInt("" + str.charAt(i)));
			}
		}

		int rtn = 0;
		for (int j = 0; j < list.size(); j++) {
			rtn += list.get(j);
		}
		return rtn;
	}

	/*
	 * maxBlock("hoopla") → 2
	 * maxBlock("abbCCCddBBBxx") → 3
	 * maxBlock("") → 0
	 */
	public int maxBlock(String str) {

		int rtn = 0;

		for (int i = 0; i < str.length(); i++) {
			if (countAdjacentChars(str, i) > rtn)
				rtn = countAdjacentChars(str, i);
		}
		return rtn;
	}

	public int countAdjacentChars(String str, int start) {
		int count = 1;
		char c = str.charAt(start);
		for (int i = start + 1; i < str.length(); i++) {
			if (str.charAt(i) == c)
				count++;
			else
				break;
		}
		return count;
	}
}
