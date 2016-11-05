import java.util.*;
class Array3 {

    /*
     * maxSpan([1, 2, 1, 1, 3]) → 4
     * maxSpan([1, 4, 2, 1, 4, 1, 4]) → 6
     * maxSpan([1, 4, 2, 1, 4, 4, 4]) → 6
     */
    public int maxSpan(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int left = nums[0];
        int right = nums[nums.length - 1];
        if (left == right) {
            return nums.length;
        } else {
            return nums.length - 1;
        }
    }

    /*
     * canBalance([1, 1, 1, 2, 1]) → true
     * canBalance([2, 1, 1, 2, 1]) → false
     * canBalance([10, 10]) → true
     */
    public boolean canBalance(int[] nums) {
        int total = 0;
        for (int n : nums) {
            total += n;
        }
        if (total % 2 == 1) return false;
        int half = total / 2;
        total = 0;
        for (int m : nums) {
            total += m;
            if (total == half) return true;
        }
        return false;
    }

    /*
     * seriesUp(3) → [1, 1, 2, 1, 2, 3]
     * seriesUp(4) → [1, 1, 2, 1, 2, 3, 1, 2, 3, 4]
     * seriesUp(2) → [1, 1, 2]
     */
    public int[] seriesUp(int n) {
        List<Integer> list = new LinkedList();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                list.add(j);
            }
        }
        int[] rtn = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            rtn[k] = list.get(k);
        }
        return rtn;
    }

    /*
     * fix34([1, 3, 1, 4]) → [1, 3, 4, 1]
     * fix34([1, 3, 1, 4, 4, 3, 1]) → [1, 3, 4, 1, 1, 3, 4]
     * fix34([3, 2, 2, 4]) → [3, 4, 2, 2]
     */
    public int[] fix34(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 3) {
                if (getNext4(nums, i + 1, false) == 0) {
                    int index = getNext4(nums, i - 1, true);
                    nums[index] = nums[i + 1];
                    nums[i + 1] = 4;
                } else {
                    int index = getNext4(nums, i + 1, false);
                    nums[index] = nums[i + 1];
                    nums[i + 1] = 4;
                }
            }
        }
        return nums;
    }

    public int getNext4(int[] nums, int start, boolean reverse) {
        if (reverse == true) {
            for (int i = start; i >= 0; i--) {
                if (nums[i] == 4) return i;
            }
            return 0;
        } else {
            for (int i = start; i < nums.length; i++) {
                if (nums[i] == 4) return i;
            }
            return 0;
        }
    }

    /*
     * linearIn([1, 2, 4, 6], [2, 4]) → true
     * linearIn([1, 2, 4, 6], [2, 3, 4]) → false
     * linearIn([1, 2, 4, 4, 6], [2, 4]) → true
     */
    public boolean linearIn(int[] outer, int[] inner) {
        List<Integer> out = new ArrayList();
        for (int o : outer) {
            out.add(o);
        }
        for (int i : inner) {
            if (!out.contains(i)) return false;
        }
        return true;
    }

    /*
     * maxMirror([1, 2, 3, 8, 9, 3, 2, 1]) → 3
     * maxMirror([1, 2, 1, 4]) → 3
     * maxMirror([7, 1, 2, 9, 7, 2, 1]) → 2
     */
    public int maxMirror(int[] nums) {
        int[] reverse = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            reverse[i] = nums[nums.length - i - 1];
        }
        for (int j = 0; j < nums.length; j++) {
            for (int k = 0; k <= j; k++) {
                if(contains(reverse, Arrays.copyOfRange(nums, k, k + nums.length - j))) {
                    return nums.length - j;
                }
            }
        }
        return 0;
    }

    public boolean contains(int[] main, int[] sub) {
        if (sub.length > main.length) {
            return false;
        } else if (Arrays.equals(main, sub)) {
            return true;
        } else {
            for (int i = 0; i <= main.length - sub.length; i++) {
                if (Arrays.equals(Arrays.copyOfRange(main, i, i + sub.length), sub)) {
                    return true;
                }
            }
            return false;
        }
    }

    /*
     * fix45([5, 4, 9, 4, 9, 5]) → [9, 4, 5, 4, 5, 9]
     * fix45([1, 4, 1, 5]) → [1, 4, 5, 1]
     * fix45([1, 4, 1, 5, 5, 4, 1]) → [1, 4, 5, 1, 1, 4, 5]
     */
    public int[] fix45(int[] nums) {
        //Indexes of 4s.
        List<Integer> list1 = new ArrayList();
        //Every elements other than 4s in correct order.
        List<Integer> list2 = new ArrayList();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                list1.add(i);
            } else {
                list2.add(nums[i]);
            }
        }
        int[] rtn = new int[nums.length];
        assert(nums.length == rtn.length);
        for (int j = 0; j < rtn.length; j++) {
            if (list1.contains(j)) {
                rtn[j] = 4;
                rtn[j + 1] = 5;
                list2.remove(list2.indexOf(5));
                j++;
            } else {
                if (list2.get(0) == 5) {
                    for (int k = 1; k < list2.size(); k++) {
                        if (list2.get(k) != 5) {
                            rtn[j] = list2.get(k);
                            list2.remove(k);
                            break;
                        }
                    }
                } else {
                    rtn[j] = list2.get(0);
                    list2.remove(0);
                }
            }
        }
        return rtn;
    }

    /*
     * squareUp(3) → [0, 0, 1, 0, 2, 1, 3, 2, 1]
     * squareUp(2) → [0, 1, 2, 1]
     * squareUp(4) → [0, 0, 0, 1, 0, 0, 2, 1, 0, 3, 2, 1, 4, 3, 2, 1]
     */
    public int[] squareUp(int n) {
        List<Integer> list = new LinkedList();
        for (int i = 1; i <= n; i++) {
            int count = n - i;
            while (count > 0) {
                list.add(0);
                count--;
            }
            for (int k = i; k >= 1; k--) {
                list.add(k);
            }
        }
        int[] rtn = new int[list.size()];
        for (int k = 0; k < list.size(); k++) {
            rtn[k] = list.get(k);
        }
        return rtn;
    }

    /*
     * countClumps([1, 2, 2, 3, 4, 4]) → 2
     * countClumps([1, 1, 2, 1, 1]) → 2
     * countClumps([1, 1, 1, 1, 1]) → 1
     */
    public int countClumps(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] != nums[j]) {
                        count++;
                        i = j - 1;
                        break;
                    }
                }
            }
        }
        if (nums.length > 0 && nums[nums.length - 1] == nums[nums.length - 2]) {
            count++;
        }
        return count;
    }
}