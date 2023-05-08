package 代码随想录.动态规划专练.代码随想录.背包问题.背包问题01.目标和;

public class Solution {
    public static void main(String[] args) {

//        System.out.println(new Solution().findTargetSumWays());
    }
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        //如果target过大 sum将无法满足
        if ( target < 0 && sum < -target) return 0;
        if ((target + sum) % 2 != 0) return 0;
        int size = (target + sum) / 2;
        if(size < 0) size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }


    /*
    *
    *
    * -------------------------------------------
    *           明天再看下，这个排列组合问题，为什么递推公式是dp[j]+=dp[j-nums[i]]
    *
    *
    *
    *
    *
    * */

    /*
    * dp4   dp3 dp2 dp1 dp0
    * 0     0   0   1   1
    * 0     0   1   2
    * 0     1   3   3
    * 1     4   6   4
    * 5
    *
    *
    * dp0   dp1 dp2 dp3 dp4
    * 1     1   0   0   0
    *       2   1   0   0
    *       3   3   1   0
    *       4   6   4   1
    *       5   10  10  5
    *
    * */
}
