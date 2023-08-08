package 代码随想录.动态规划专练.最大子序和;

public class Solution {
    public int maxSubArray(int[] nums){
        int len=nums.length;
        int[] dp=new int[len];
        dp[0]=nums[0];
        int result=nums[0];
        for (int i = 1; i < len; i++) {
            if(dp[i-1]>=0){
                dp[i]=dp[i-1]+nums[i];
            }else{
                dp[i]=nums[i];
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
