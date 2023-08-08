package 代码随想录.动态规划专练.打家劫舍II;

public class Solution {
    public static void main(String[] args) {
        int[] nums={2,1,1,2};
        System.out.println(new Solution().rob(nums));
    }
    //在打家劫舍1的基础上，分2种情况，1是不偷第1家，2是不偷最后一家，两者最大值再取最大值。如何实现不偷第1家：把第1家的钱暂时置0就好了
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1)
            return nums[0];
        if (len == 2)
            return Math.max(nums[0], nums[1]);
        int[] dp = new int[len];
        int a1 = nums[0];

        //确保不偷0
        nums[0]=0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        int result = dp[len - 1];

        //确保不偷len-1
        nums[0] = a1;
        nums[len - 1] = 0;
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return Math.max(result, dp[len - 1]);
    }
}
