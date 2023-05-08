package 代码随想录.双指针法专练.最大连续1的个数III;

public class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length, l = 0, r = 0, zeroCount = 0;
        int result = 0;
        while (r < n) {
            if (nums[r] == 0)
                zeroCount++;
            while (zeroCount > k) {
                if (nums[l] == 0)
                    zeroCount--;
                l++;
            }
            result = Math.max(result, r - l + 1);
            r++;
        }
        return result;
    }
}
