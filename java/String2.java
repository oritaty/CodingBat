/*
 * CodingBat String2
 * url: http://codingbat.com/java/String-2
 */
import java.util.*;

public class String2 {

	/*
	 * doubleChar("The") → "TThhee"
	 * doubleChar("AAbb") → "AAAAbbbb"
	 * doubleChar("Hi-There") → "HHii--TThheerree" 
	 */
	public String doubleChar(String str) {

		String rtn = "";

		for (int i = 0; i < str.length(); i++) {
			rtn += "" + str.charAt(i) + str.charAt(i);
		}
		return rtn;
	}

	/*
	 * countCode("aaacodebbb") → 1
	 * countCode("codexxcode") → 2
	 * countCode("cozexxcope") → 2 
	 */
	public int countCode(String str) {

		if (str.length() < 4)
			return 0;

		int count = 0;
		for (int i = 0; i <= str.length() - 4; i++) {
			if (str.substring(i, i + 2).equals("co")
					&& str.charAt(i + 3) == 'e') {
				count++;
			}
		}
		return count;
	}

	/*
	 * bobThere("abcbob") → true
	 * bobThere("b9b") → true
	 * bobThere("bac") → false
	 */
	public boolean bobThere(String str) {
		int counter = 0;
		for (int i = 0; i < str.length() - 2; i++)
			if (str.charAt(i) == 'b' && str.charAt(i + 2) == 'b') {
				counter = counter + 1;
			}

		if (counter > 0) {
			return true;
		}

		else {
			return false;
		}
	}

	/*
	 * repeatEnd("Hello", 3) → "llollollo"
	 * repeatEnd("Hello", 2) → "lolo"
	 * repeatEnd("Hello", 1) → "o"
	 */
	public String repeatEnd(String str, int n) {

		String rtn = "";
		String last = str.substring(str.length() - n);

		for (int i = 0; i < n; i++) {
			rtn += last;
		}
		return rtn;
	}

	/*
	 * prefixAgain("abXYabc", 1) → true
	 * prefixAgain("abXYabc", 2) → true
 	 * prefixAgain("abXYabc", 3) → false
	 */
	public boolean prefixAgain(String str, int n) {

		String prefix = str.substring(0, n);

		for (int i = prefix.length(); i <= str.length() - prefix.length(); i++) {
			if (str.substring(i, i + prefix.length()).equals(prefix)) {
				return true;
			}
		}
		return false;
	}

	/*
	 * sameStarChar("xy*yzz") → true
	 * sameStarChar("xy*zzz") → false
	 * sameStarChar("*xa*az") → true
	 */
	public boolean sameStarChar(String str) {

		for (int i = 1; i < str.length() - 1; i++) {
			if (str.charAt(i) == '*') {
				if (str.charAt(i - 1) != str.charAt(i + 1)) {
					return false;
				}
			}
		}
		return true;
	}

	/*
	 * starOut("ab*cd") → "ad"
	 * starOut("ab**cd") → "ad"
	 * starOut("sm*eilly") → "silly"
	 */
	public String starOut(String str) {

		if (!str.contains("*")) {
			return str;
		}

		String[] arr = str.split("\\*");
		String rtn = "";

		for (int i = 0; i < arr.length; i++) {
			if (arr[i].length() > 0) {
				if (i == 0) {
					rtn += arr[i].substring(0, arr[i].length() - 1);
				} else if (i == arr.length - 1) {
					rtn += arr[i].substring(1);
				} else {
					rtn += arr[i].substring(1, arr[i].length() - 1);
				}
			}
		}
		return rtn;
	}

	/*
	 * countHi("abc hi ho") → 1
	 * countHi("ABChi hi") → 2
	 * countHi("hihi") → 2
	 */
	public int countHi(String str) {
		int counter = 0;
		for (int i = 0; i < str.length() - 1; i++)
			if (str.substring(i, i + 2).equals("hi")) {
				counter++;
			}
		return counter;
	}

	/*
	 * endOther("Hiabc", "abc") → true
	 * endOther("AbC", "HiaBc") → true
	 * endOther("abc", "abXabc") → true
	 */
	public boolean endOther(String a, String b) {

		a = a.toLowerCase();
		b = b.toLowerCase();

		if (a.length() >= b.length()) {
			return a.endsWith(b);
		} else {
			return b.endsWith(a);
		}
	}

	/*
	 * xyBalance("aaxbby") → true
	 * xyBalance("aaxbb") → false
	 * xyBalance("yaaxbb") → false
	 */
	public boolean xyBalance(String str) {

		int last_x = -1;
		int first_y = -1;

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == 'x')
				last_x = i;
			if (str.charAt(i) == 'y')
				first_y = i;
		}

		return (last_x <= first_y);
	}

	/*
	 * repeatFront("Chocolate", 4) → "ChocChoChC"
	 * repeatFront("Chocolate", 3) → "ChoChC"
	 * repeatFront("Ice Cream", 2) → "IcI"
	 */
	public String repeatFront(String str, int n) {

		String rtn = "";

		for (int i = n; i > 0; i--) {
			rtn += str.substring(0, i);
		}
		return rtn;
	}

	/*
	 * xyzMiddle("AAxyzBB") → true
	 * xyzMiddle("AxyzBB") → true
	 * xyzMiddle("AxyzBBB") → false
	 */
	public boolean xyzMiddle(String str) {

		final String s = "xyz";

		for (int i = 0; i <= str.length() - s.length(); i++) {
			if (str.substring(i, i + 3).equals(s)) {
				if (i == (str.length() - (i + 3))
						|| i + 1 == (str.length() - (i + 3))
						|| i - 1 == (str.length() - (i + 3))) {
					return true;
				}
			}
		}
		return false;
	}

	/*
	 * oneTwo("abc") → "bca"
	 * oneTwo("tca") → "cat"
	 * oneTwo("tcagdo") → "catdog"
	 */
	public String oneTwo(String str) {

		int times = str.length() / 3;

		if (str.length() % 3 != 0)
			times++;

		String rtn = "";

		for (int i = 0; i < times; i++) {
			String target;
			if (i == times - 1) {
				target = str.substring(i * 3);
				if (target.length() == 3) {
					rtn += target.substring(1, 3) + "" + target.charAt(0);
				}
			} else {
				target = str.substring(i * 3, (i * 3) + 3);
				rtn += target.substring(1, 3) + "" + target.charAt(0);
			}
		}
		return rtn;
	}

	/*
	 * plusOut("12xy34", "xy") → "++xy++"
	 * plusOut("12xy34", "1") → "1+++++"
	 * plusOut("12xy34xyabcxy", "xy") → "++xy++xy+++xy"
	 */
	public String plusOut(String str, String word) {

		List<Integer> list = getTheIndexes(str, word);

		int count = 0;
		String rtn = "";

		while (count < str.length()) {
			if (list.contains(count)) {
				rtn += word;
				count += word.length();
			} else {
				rtn += "+";
				count++;
			}
		}
		return rtn;
	}

	public List<Integer> getTheIndexes(String str, String word) {

		List<Integer> rtn = new LinkedList();

		for (int i = 0; i <= str.length() - word.length(); i++) {
			if (str.substring(i, i + word.length()).equals(word)) {
				rtn.add(i);
			}
		}
		return rtn;
	}

	/*
	 * catDog("catdog") → true
	 * catDog("catcat") → false
	 * catDog("1cat1cadodog") → true
	 */
	public boolean catDog(String str) {
		int counter = 0;
		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 3).equals("cat")) {
				counter++;
			} else if (str.substring(i, i + 3).equals("dog")) {
				counter--;
			}
		}

		if (counter == 0)
			return true;
		else
			return false;
	}

	/*
	 * xyzThere("abcxyz") → true
	 * xyzThere("abc.xyz") → false
	 * xyzThere("xyz.abc") → true
	 */
	public boolean xyzThere(String str) {

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.substring(i, i + 3).equals("xyz")) {
				if (i == 0)
					return true;
				else if (str.charAt(i - 1) != '.')
					return true;
			}
		}
		return false;
	}

	/*
	 * mixString("abc", "xyz") → "axbycz"
	 * mixString("Hi", "There") → "HTihere"
	 * mixString("xxxx", "There") → "xTxhxexre"
	 */
	public String mixString(String a, String b) {

		String result = "";
		int length, bigger, i = 0;
		if (a.length() > b.length()) {
			length = b.length();
			bigger = 1;
		} else {
			length = a.length();
			bigger = 2;
		}

		while (i < length) {
			result += a.charAt(i);
			result += b.charAt(i);
			i++;
		}

		if (bigger == 1) {
			result += a.substring(i, a.length());
		} else {
			result += b.substring(i, b.length());
		}
		return result;
	}

	/*
	 * repeatSeparator("Word", "X", 3) → "WordXWordXWord"
	 * repeatSeparator("This", "And", 2) → "ThisAndThis"
	 * repeatSeparator("This", "And", 1) → "This"
	 */
	public String repeatSeparator(String word, String sep, int count) {

		String result = "";
		for (int i = 0; i < count; i++) {
			if (i + 1 == count) {
				result += word;
			} else {
				result += (word + sep);
			}
		}
		return result;
	}

	/*
	 * getSandwich("breadjambread") → "jam"
	 * getSandwich("xxbreadjambreadyy") → "jam"
	 * getSandwich("xxbreadyy") → ""
	 */
	public String getSandwich(String str) {

		int indexFirst = -1;
		int indexLast = str.length();
		boolean foundFirst = false;
		boolean foundLast = false;

		for (int i = 0; i < str.length() - 4; i++) {
			if (!foundFirst) {
				if (str.substring(i, i + 5).equals("bread")) {
					indexFirst = i + 5;
					foundFirst = true;
				}
			}
			if (!foundLast) {
				if (str.substring(str.length() - 5 - i,
						(str.length() - 5 - i) + 5).equals("bread")) {
					indexLast = str.length() - 5 - i;
					foundLast = true;
				}
			}
			if (foundFirst && foundLast) {
				if (indexFirst - 5 != indexLast)
					return str.substring(indexFirst, indexLast);
				else
					break;
			}
		}
		return "";
	}

	/*
	 * zipZap("zipXzap") → "zpXzp"
	 * zipZap("zopzop") → "zpzp"
	 * zipZap("zzzopzop") → "zzzpzp"
	 */
	public String zipZap(String str) {

		if (str.length() < 3) {
			return str;
		}

		String rtn = "";

		for (int i = 0; i < str.length() - 2; i++) {
			if (str.charAt(i) == 'z' && str.charAt(i + 2) == 'p') {
				rtn += "zp";
				i += 2;
			} else {
				rtn += "" + str.charAt(i);
			}
		}

		if (str.charAt(str.length() - 3) != 'z'
				|| str.charAt(str.length() - 1) != 'p') {
			rtn += str.substring(str.length() - 2);
		}
		return rtn;
	}

	/*
	 * wordEnds("abcXY123XYijk", "XY") → "c13i"
	 * wordEnds("XY123XY", "XY") → "13"
	 * wordEnds("XY1XY", "XY") → "11"
	 */
	public String wordEnds(String str, String word) {

		String rtn = "";
		List<Character> list = getCharsList(str, word);

		for (int i = 0; i < list.size(); i++) {
			rtn += list.get(i);
		}
		return rtn;
	}

	public List<Character> getCharsList(String str, String word) {

		List<Character> rtn = new LinkedList();

		if (str.equals(word)) {
			return rtn;
		}

		for (int i = 0; i <= str.length() - word.length(); i++) {
			if (str.substring(i, i + word.length()).equals(word)) {

				if (i == 0) {
					rtn.add(str.charAt(word.length()));
				} else {
					rtn.add(str.charAt(i - 1));
					if (i != str.length() - word.length()) {
						rtn.add(str.charAt(i + word.length()));
					}
				}
			}
		}
		return rtn;
	}
}
