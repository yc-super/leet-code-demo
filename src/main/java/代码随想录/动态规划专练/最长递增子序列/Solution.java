package 代码随想录.动态规划专练.最长递增子序列;

public class Solution {
    public static void main(String[] args) {
//        int[] nums={10,9,2,5,3,7,101,18};
//        int[] nums={1,7,8,5,10,6,7,101,18};
        //          1 2 2 2 3 3  4 5   5
//        int[] nums = {10, 9, 2, 5, 3, 7, 6, 18};
        int[] nums = {0,1,0,3,2,3};
        //           1 1 1 2 2 3 3 4
        System.out.println(new Solution().lengthOfLIS(nums));
    }

    //明天看下时间复杂度为O(nlogn)的


    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];
        dp[0] = 1;
        int result=1;
        for (int i = 1; i < len; i++) {
            dp[i]=1;
            for (int j = i-1; j >=0 ; j--) {
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            result=Math.max(result,dp[i]);
        }
        return result;
    }
}
