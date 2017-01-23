/*
 * CodingBat AP-1
 * URL: http://codingbat.com/java/AP-1
 */
import java.util.*;
class AP1 {

    /*
     * scoresIncreasing([1, 3, 4]) → true
     * scoresIncreasing([1, 3, 2]) → false
     * scoresIncreasing([1, 1, 4]) → true
     */
    public boolean scoresIncreasing(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] > scores[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
     * scoresAverage([2, 2, 4, 4]) → 4
     * scoresAverage([4, 4, 4, 2, 2, 2]) → 4
     * scoresAverage([3, 4, 5, 1, 2, 3]) → 4
     */
    public int scoresAverage(int[] scores) {
        int first = 0, second = 0;
        for (int i = 0; i < scores.length/2; i++) {
            first += scores[i];
        }
        first = first / (scores.length/2);
        for (int j = scores.length/2; j < scores.length; j++) {
            second += scores[j];
        }
        second = second / (scores.length/2);
        if (first > second) return first;
        else return second;
    }

    /*
     * wordsWithoutList(["a", "bb", "b", "ccc"], 1) → ["bb", "ccc"]
     * wordsWithoutList(["a", "bb", "b", "ccc"], 3) → ["a", "bb", "b"]
     * wordsWithoutList(["a", "bb", "b", "ccc"], 4) → ["a", "bb", "b", "ccc"]
     */
    public List wordsWithoutList(String[] words, int len) {
        List<String> rtn = new LinkedList();
        for (String w : words) {
            if (w.length() != len) {
                rtn.add(w);
            }
        }
        return rtn;
    }

    /*
     * copyEvens([3, 2, 4, 5, 8], 2) → [2, 4]
     * copyEvens([3, 2, 4, 5, 8], 3) → [2, 4, 8]
     * copyEvens([6, 1, 2, 4, 5, 8], 3) → [6, 2, 4]
     */
    public int[] copyEvens(int[] nums, int count) {
        List<Integer> list = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                list.add(nums[i]);
                count--;
            }
            if (count <= 0) {
                break;
            }
        }
        int[] rtn = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            rtn[j] = list.get(j);
        }
        return rtn;
    }

    /*
     * scoreUp(["a", "a", "b", "b"], ["a", "c", "b", "c"]) → 6
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "c"]) → 11
     * scoreUp(["a", "a", "b", "b"], ["a", "a", "b", "b"]) → 16
     */
    public int scoreUp(String[] key, String[] answers) {
        int score = 0;
        assert(key.length == answers.length);
        for (int i = 0; i < key.length; i++) {
            if (key[i].equals(answers[i])) {
                score += 4;
            } else if (answers[i].equals("?")) {
                score += 0;
            } else {
                score -= 1;
            }
        }
        return score;
    }

    /*
     * sumHeights([5, 3, 6, 7, 2], 2, 4) → 6
     * sumHeights([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights([5, 3, 6, 7, 2], 0, 4) → 11
     */
    public int sumHeights(int[] heights, int start, int end) {
        int diff = 0;
        for (int i = start; i < end; i++) {
            if (heights[i] == heights[i + 1]) {
                diff += 0;
            } else {
                diff += Math.abs(heights[i] - heights[i + 1]);
            }
        }
        return diff;
    }

    /*
     * userCompare("bb", 1, "zz", 2) → -1
     * userCompare("bb", 1, "aa", 2) → 1
     * userCompare("bb", 1, "bb", 1) → 0
     */
    public int userCompare(String aName, int aId, String bName, int bId) {
        if (aName.compareTo(bName) < 0) return -1;
        else if (aName.compareTo(bName) > 0) return 1;
        else {
            if (aId < bId) return - 1;
            else if (aId > bId) return 1;
            else return 0;
        }
    }

    /*
     * scores100([1, 100, 100]) → true
     * scores100([1, 100, 99, 100]) → false
     * scores100([100, 1, 100, 100]) → true
     */
    public boolean scores100(int[] scores) {
        for (int i = 0; i < scores.length - 1; i++) {
            if (scores[i] == 100) {
                if (scores[i + 1] == 100) return true;
            }
        }
        return false;
    }

    /*
     * wordsCount(["a", "bb", "b", "ccc"], 1) → 2
     * wordsCount(["a", "bb", "b", "ccc"], 3) → 1
     * wordsCount(["a", "bb", "b", "ccc"], 4) → 0
     */
    public int wordsCount(String[] words, int len) {
        int count = 0;
        for (String s : words) {
            if (s.length() == len) count++;
        }
        return count;
    }

    /*
     * hasOne(10) → true
     * hasOne(22) → false
     * hasOne(220) → false
     */
    public boolean hasOne(int n) {
        String str = "" + n;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') return true;
        }
        return false;
    }

    /*
     * copyEndy([9, 11, 90, 22, 6], 2) → [9, 90]
     * copyEndy([9, 11, 90, 22, 6], 3) → [9, 90, 6]
     * copyEndy([12, 1, 1, 13, 0, 20], 2) → [1, 1]
     */
    public int[] copyEndy(int[] nums, int count) {
        List<Integer> list = new LinkedList();
        for (int i : nums) {
            if (isEndy(i)) {
                list.add(i);
                count--;
            }
            if (count <= 0) {
                break;
            }
        }
        int[] arr = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            arr[j] = list.get(j);
        }
        return arr;
    }

    public boolean isEndy(int n) {
        if (n >= 0 && n <= 10) {
            return true;
        } else if (n >= 90 && n <= 100) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * wordsWithout(["a", "b", "c", "a"], "a") → ["b", "c"]
     * wordsWithout(["a", "b", "c", "a"], "b") → ["a", "c", "a"]
     * wordsWithout(["a", "b", "c", "a"], "c") → ["a", "b", "a"]
     */
    public String[] wordsWithout(String[] words, String target) {
        List<String> list = new LinkedList();
        for (String w : words) {
            if (!w.equals(target)) list.add(w);
        }
        String[] arr = new String[list.size()];
        return list.toArray(arr);
    }

    /*
     * sumHeights2([5, 3, 6, 7, 2], 2, 4) → 7
     * sumHeights2([5, 3, 6, 7, 2], 0, 1) → 2
     * sumHeights2([5, 3, 6, 7, 2], 0, 4) → 15
     */
    public int sumHeights2(int[] heights, int start, int end) {
        int diff = 0;
        for(int i = start; i < end; i++) {
            if (heights[i] > heights[i + 1]) {
                diff += Math.abs(heights[i] - heights[i + 1]);
            } else if (heights[i] < heights[i + 1]) {
                diff += 2 * Math.abs(heights[i] - heights[i + 1]);
            } else {
                diff += 0;
            }
        }
        return diff;
    }

    /*
     * mergeTwo(["a", "c", "z"], ["b", "f", "z"], 3) → ["a", "b", "c"]
     * mergeTwo(["a", "c", "z"], ["c", "f", "z"], 3) → ["a", "c", "f"]
     * mergeTwo(["f", "g", "z"], ["c", "f", "g"], 3) → ["c", "f", "g"]
     */
    public String[] mergeTwo(String[] a, String[] b, int n) {
        List<String> list = new LinkedList();
        for (String s : a) {
            list.add(s);
        }
        for (String ss : b) {
            if (!list.contains(ss)) list.add(ss);
        }
        Collections.sort(list);
        String[] rtn = new String[n];
        for (int i = 0; i < n; i++) {
            rtn[i] = list.get(i);
        }
        return rtn;
    }

    /*
     * scoresClump([3, 4, 5]) → true
     * scoresClump([3, 4, 6]) → false
     * scoresClump([1, 3, 5, 5]) → true
     */
    public boolean scoresClump(int[] scores) {
        for (int i = 0; i < scores.length - 2; i++) {
            if(Math.abs(scores[i] - scores[i + 1]) <= 2 &&
                    Math.abs(scores[i] - scores[i + 2]) <= 2 &&
                    Math.abs(scores[i + 1] - scores[i + 2]) <= 2) {
                return true;
            }
        }
        return false;
    }

    /*
     * wordsFront(["a", "b", "c", "d"], 1) → ["a"]
     * wordsFront(["a", "b", "c", "d"], 2) → ["a", "b"]
     * wordsFront(["a", "b", "c", "d"], 3) → ["a", "b", "c"]
     */
    public String[] wordsFront(String[] words, int n) {
        String[] rtn = new String[n];
        for (int i = 0; i < n; i++) {
            rtn[i] = words[i];
        }
        return rtn;
    }

    /*
     * dividesSelf(128) → true
     * dividesSelf(12) → true
     * dividesSelf(120) → false
     */
    public boolean dividesSelf(int n) {
        String str = "" + n;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '0') {
                return false;
            } else {
                if (n % (Integer.parseInt("" + str.charAt(i))) != 0) return false;
            }
        }
        return true;
    }

    /*
     * matchUp(["aa", "bb", "cc"], ["aaa", "xx", "bb"]) → 1
     * matchUp(["aa", "bb", "cc"], ["aaa", "b", "bb"]) → 2
     * matchUp(["aa", "bb", "cc"], ["", "", "ccc"]) → 1
     */
    public int matchUp(String[] a, String[] b) {
        int count = 0;
        assert(a.length == b.length);
        for (int i = 0; i < a.length; i++) {
            if (a[i].length() > 0 && b[i].length() > 0) {
                if (b[i].startsWith("" + a[i].charAt(0))) count++;
            }
        }
        return count;
    }

    /*
     * scoresSpecial([12, 10, 4], [2, 20, 30]) → 40
     * scoresSpecial([20, 10, 4], [2, 20, 10]) → 40
     * scoresSpecial([12, 11, 4], [2, 20, 31]) → 20
     */
    public int scoresSpecial(int[] a, int[] b) {
        return scoresSpecial(a) + scoresSpecial(b);
    }

    public int scoresSpecial(int[] nums) {
        int special = 0;
        for (int n : nums) {
            if (n % 10 == 0) {
                if (n > special) special = n;
            }
        }
        return special;
    }

    /*
     * bigHeights([5, 3, 6, 7, 2], 2, 4) → 1
     * bigHeights([5, 3, 6, 7, 2], 0, 1) → 0
     * bigHeights([5, 3, 6, 7, 2], 0, 4) → 1
     */
    public int bigHeights(int[] heights, int start, int end) {
        int count = 0;
        for (int i = start; i < end; i++) {
            if (Math.abs(heights[i] - heights[i + 1]) >= 5) {
                count++;
            }
        }
        return count;
    }

    /*
     * commonTwo(["a", "c", "x"], ["b", "c", "d", "x"]) → 2
     * commonTwo(["a", "c", "x"], ["a", "b", "c", "x", "z"]) → 3
     * commonTwo(["a", "b", "c"], ["a", "b", "c"]) → 3
     */
    public int commonTwo(String[] a, String[] b) {
        int count = 0;
        List<String> list1 = new LinkedList();
        List<String> list2 = new LinkedList();
        for (String s : a) {
            if (!list1.contains(s)) list1.add(s);
        }
        for (String ss : b) {
            if (!list2.contains(ss) && list1.contains(ss)) {
                count++;
                list2.add(ss);
            }
        }
        return count;
    }
}