package LeetCode_Hot150.删除有序数组中的重复项II;

public class Solution {

    public int removeDuplicates(int[] nums) {
        int pre = -10000 - 1;
        int defaultValue = -10000 - 1;
        int count = 0;
        int nowCount = 1;//起始可以不用这个变量来统计当前值一共出现了几次，详见下面的官方答案
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == pre) {
                nowCount++;
                if (nowCount > 2) {
                    nums[i] = defaultValue;
                } else {
                    count++;
                }
            } else {
                nowCount = 1;
                pre = nums[i];
                count++;
            }
        }

        int left = 0, right = 0;
        while (right != nums.length) {
            if (nums[right] != defaultValue) {
                nums[left++] = nums[right];
            }
            right++;
        }

        return count;
    }


    //官方答案
    public int removeDuplicates2(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n;
        }
        int slow = 2, fast = 2;
        while (fast < n) {
            if (nums[slow - 2] != nums[fast]) {
                nums[slow] = nums[fast];
                ++slow;
            }
            ++fast;
        }
        return slow;
    }
}
