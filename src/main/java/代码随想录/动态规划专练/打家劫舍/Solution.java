package 代码随想录.动态规划专练.打家劫舍;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(new Solution().rob2(nums));
    }

    public int rob(int[] nums) {
        int len = nums.length;
        int bagSize = 0;
        for (int num : nums) {
            bagSize += num;
        }
        int[] dp = new int[bagSize + 1];
        boolean[] temp = new boolean[len];
        for (int i = 0; i < len; i++) {
            for (int j = bagSize; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
        }
//        dp[i][j]=Math.max(dp[i-1][j],dp[i][j-nums[i]]+nums[i]);

        return dp[bagSize];
    }

    public int rob2(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-1],dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }
}
