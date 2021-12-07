package LeetCode.最长递增子序列;

import java.util.Map;

/*
 * 明显是要用动态规划
 * dp[i]:从0到i，以i结尾的最长递增子序列的长度，包括nums[i]
 * 注意：dp[i]的定义，必须是以nums[i]结尾
 * 递推公式：
 * 分析：dp[i]=max(dp[j])+1,其中，0<=j<i且num[j]<num[i]，就是说，在0到i-1之间最长的递增子序列再加上1
 *5
 *123464
 *123453
 * */
public class code2 {
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
        int[] nums = {0,1,0,3,2,3};
//        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(new code2().lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=1;
        int max=1;
        for (int i = 1; i < nums.length; i++) {
            dp[i]=1;
            for (int j = 0; j < i; j++) {
                if(nums[i]>nums[j]){
                    dp[i]= Math.max(dp[i],dp[j]+1);
                }
            }
            max=Math.max(max,dp[i]);
        }
        return max;
    }
}
