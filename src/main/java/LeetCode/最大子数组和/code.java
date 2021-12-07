package LeetCode.最大子数组和;
//简单题，没想出来。。。
//官方答案：动态规划
/*
* dp[i]:从0到i,最大之和
*
* 确定递推公式：
* max=0;
* dp[i]=Max(max,Max(dp[i-1]+nums[i],nums[i]));
* */
public class code {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new code().maxSubArray(nums));
    }
    public int maxSubArray(int[] nums) {
        int pre=0,max=nums[0];
        for(int num:nums){
            pre=Math.max(pre+num,num);
            max=Math.max(max,pre);
        }
        return max;
    }
}
