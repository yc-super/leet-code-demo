package 代码随想录.动态规划专练.代码随想录.背包问题.背包问题01.分割等和子集;

public class Solution {
    public static void main(String[] args) {

    }
    public boolean canPartition(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int target=sum/2;

        if(nums[0]==target)
            return true;

        int[][] dp=new int[nums.length][target+1];
        for (int i = 0; i < nums.length; i++) {
            dp[i][0]=0;
        }
        for (int j = target; j >=nums[0]; j--) {
            dp[0][j]=nums[0];
        }

        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j <=target; j++) {
                dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-nums[i]]+nums[i]);
            }
        }

        if(dp[nums.length-1][target]==target)
            return true;

        return false;

    }
    public boolean canPartition2(int[] nums) {
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }
        if(sum%2!=0)
            return false;
        int target=sum/2;

        if(nums[0]==target)
            return true;

        int[] dp=new int[target+1];
        dp[0]=0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >=nums[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }
        }
        return dp[target]==target;
    }
}
