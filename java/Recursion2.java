/*
 * CodingBat Recursion-2
 * URL: http://codingbat.com/java/Recursion-2
 */

 import java.util.*;
 class Recursion2 {
   /*
   * groupSum(0, [2, 4, 8], 10) → true
   * groupSum(0, [2, 4, 8], 14) → true
   * groupSum(0, [2, 4, 8], 9) → false
   */
   public boolean groupSum(int start, int[] nums, int target) {
     if (start >= nums.length) {
       if (target == 0) {
         return true;
       } else {
         return false;
       }
     } else {
       //Binary Search.
       return groupSum(start + 1, nums, target - nums[start]) ||
       groupSum(start + 1, nums, target);
     }
   }

   /*
   * groupSum5(0, [2, 5, 10, 4], 19) → true
   * groupSum5(0, [2, 5, 10, 4], 17) → true
   * groupSum5(0, [2, 5, 10, 4], 12) → false
   */
   public boolean groupSum5(int start, int[] nums, int target) {
     if (start <= nums.length - 1 && nums[start] % 5 == 0) {
       target -= nums[start];
       if (start + 1 < nums.length && nums[start + 1] == 1) {
         nums[start + 1] = 0;
       }
     }
     if (start >= nums.length) {
       if (target == 0) {
         return true;
       } else {
         return false;
       }
     } else {
       return groupSum5(start + 1, nums, target - nums[start]) ||
       groupSum5(start + 1, nums, target);
     }
   }

   /*
   * splitOdd10([5, 5, 5]) → true
   * splitOdd10([5, 5, 6]) → false
   * splitOdd10([5, 5, 6, 1]) → true
   */
   public boolean splitOdd10(int[] nums) {
     if (nums.length == 0) {
       return false;
     } else if (nums.length == 1) {
       return true;
     }
     Arrays.sort(nums);
     int tot1 = 0, tot2 = 0;
     return addAndCompare(nums, nums.length - 1, tot1, tot2);
   }

   public boolean addAndCompare(int[] nums, int index, int tot1, int tot2) {
     if (nums[index] % 5 == 0) {
       if (index == nums.length - 1) {
         tot2 += nums[index];
       } else {
         tot1 += nums[index];
       }
     } else {
       if ((tot1 + nums[index]) % 10 == 0) {
         tot1 += nums[index];
       } else {
         tot2 += nums[index];
       }
     }
     if (index == 0) {
       if (tot1 % 10 == 0 && tot2 % 2 == 1) {
         return true;
       } else {
         return false;
       }
     } else {
       return addAndCompare(nums, index - 1, tot1, tot2);
     }
   }


   /*
   * groupSum6(0, [5, 6, 2], 8) → true
   * groupSum6(0, [5, 6, 2], 9) → false
   * groupSum6(0, [5, 6, 2], 7) → false
   */
   public boolean groupSum6(int start, int[] nums, int target) {
     if (start < nums.length && nums[start] == 6) {
       target -= 6;
     }
     if (start >= nums.length) {
       if (target == 0) {
         return true;
       } else {
         return false;
       }
     } else {
       return groupSum6(start + 1, nums, target - nums[start]) ||
       groupSum6(start + 1, nums, target);
     }
   }

   /*
   * groupSumClump(0, [2, 4, 8], 10) → true
   * groupSumClump(0, [1, 2, 4, 8, 1], 14) → true
   * groupSumClump(0, [2, 4, 4, 8], 14) → false
   */
   public boolean groupSumClump(int start, int[] nums, int target) {
     if (start >= nums.length) {
       if (target == 0) {
         return true;
       } else {
         return false;
       }
     } else {
       int next = 1;
       if (start < nums.length - 1 && nums[start] == nums[start + 1]) {
         next += skipAdjacent(start, nums);
       }
       return groupSumClump(start + next, nums, target - (nums[start] * next)) ||
       groupSumClump(start + next, nums, target);
     }
   }

   public int skipAdjacent(int current, int[] nums) {
     int index = current;
     while (index < nums.length - 1) {
       if (nums[index] != nums[index + 1]) break;
       else index++;
     }
     return (index - current);
   }

   /*
   * split53([1, 1]) → true
   * split53([1, 1, 1]) → false
   * split53([2, 4, 2]) → true
   */
   public boolean split53(int[] nums) {
     if (nums.length == 0) {
       return true;
     } else if (nums.length == 1) {
       return false;
     }
     Arrays.sort(nums);
     int tot1 = 0, tot2 = 0;
     return addAndCompare(nums, nums.length - 1, tot1, tot2);
   }

   public boolean addAndCompare(int[] nums, int index, int tot1, int tot2) {
     if (nums[index] % 5 == 0) {
       tot1 += nums[index];
     } else if (nums[index] % 3 == 0) {
       tot2 += nums[index];
     } else {
       if (tot1 > tot2) {
         tot2 += nums[index];
       } else {
         tot1 += nums[index];
       }
     }
     if (index == 0) {
       if (tot1 == tot2) {
         return true;
       } else {
         return false;
       }
     } else {
       return addAndCompare(nums, index - 1, tot1, tot2);
     }
   }

   /*
   * groupNoAdj(0, [2, 5, 10, 4], 12) → true
   * groupNoAdj(0, [2, 5, 10, 4], 14) → false
   * groupNoAdj(0, [2, 5, 10, 4], 7) → false
   */
   public boolean groupNoAdj(int start, int[] nums, int target) {
     if (start >= nums.length) {
       if (target == 0) {
         return true;
       } else {
         return false;
       }
     } else {
       return groupNoAdj(start + 2, nums, target - nums[start]) ||
       groupNoAdj(start + 1, nums, target);
     }
   }

   /*
   * splitArray([2, 2]) → true
   * splitArray([2, 3]) → false
   * splitArray([5, 2, 3]) → true
   */
   public boolean splitArray(int[] nums) {
     if (nums.length == 0) {
       return true;
     } else if (nums.length == 1) {
       return false;
     }
     Arrays.sort(nums);
     int tot1 = 0, tot2 = 0;
     return addAndCompare(nums, nums.length - 1, tot1, tot2);
   }

   public boolean addAndCompare(int[] nums, int index, int tot1, int tot2) {
     if (tot1 > tot2) {
       tot2 += nums[index];
     } else {
       tot1 += nums[index];
     }
     if (index == 0) {
       if (tot1 == tot2) {
         return true;
       } else {
         return false;
       }
     } else {
       return addAndCompare(nums, index - 1, tot1, tot2);
     }
   }
 }
