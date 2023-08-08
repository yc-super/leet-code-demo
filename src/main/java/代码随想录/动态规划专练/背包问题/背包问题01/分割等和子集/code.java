package 代码随想录.动态规划专练.背包问题.背包问题01.分割等和子集;
/*
* 1.确定dp数组及下标含义
* dp[i]:数组前i个元素可以分割成等和子集
* 前i个能否分割成等和子集，一定会对前i+1个能否分割成等和子集造成影响吗？不能，那么就不能把dp数组设置成上面那样
*
*
*
* 2.确定递推公式
*
* 3.初始化dp数组
*
* 4.确定遍历顺序
*
* 5.举例推导dp数组
* */
public class code {
    public static void main(String[] args) {
        int []nums = {1,5,11,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        if(nums==null||nums.length==0)
            return false;
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if(sum%2!=0)
            return false;
        int target=sum/2;
        int[] dp=new int[target+1];

        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >=nums[i]; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }

        }
        return dp[target]==target;
    }
}
