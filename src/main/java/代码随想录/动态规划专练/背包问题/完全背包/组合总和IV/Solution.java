package 代码随想录.动态规划专练.背包问题.完全背包.组合总和IV;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        //完全背包，排列问题-->注意遍历顺序，要先遍历背包，再遍历物品
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i >= nums[j])
                    dp[i] += dp[i - nums[j]];//这边递推公式，永远是dp[背包下标]+=dp[背包下标-nums[物品下标]]
            }
        }
        return dp[target];
    }


    public static void main(String[] args) {
        int[] nums = {1, 2};
        int target = 10;
        //[0, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89]
        System.out.println(new Solution().combinationSum5(nums, target));
    }

    // 自己想的动态规划
    public int combinationSum5(int[] nums, int target) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        int[] dp = new int[target + 1];
        if (set.contains(1)) {
            dp[1] = 1;
        }
        for (int i = 2; i <= target; i++) {
            for (int j = 1; j < i; j++) {
                if (set.contains(j)) {
                    dp[i] += dp[i - j];
                }
            }
            if (set.contains(i)) {
                dp[i]++;
            }
        }
        return dp[target];
    }
/*
* 3:1,2
* 4:1,2,3
*
* */
}
