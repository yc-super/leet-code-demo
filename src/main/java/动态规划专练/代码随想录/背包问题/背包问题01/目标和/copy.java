package 动态规划专练.代码随想录.背包问题.背包问题01.目标和;
/*
* 将数组分成两部分，neg为加上负号的一部分，那么另一部分就是sum-neg,并且(sum-neg)-neg=target,那么neg=(sum-target)/2,要求(sum-target)/2>=0，并且(sum-target)/2是个整数
* 这道题和前面几道题不同点在于，前面几道题都是求最大能装的价值，这道题是求能组成最大值的方式有几种
* 1.定义dp数组及下标的含义
* dp[i][j]:表示将前i个物品放入容量为j的背包中，装满的方式有几种。最终答案为dp[n][neg],n为nums数组的长度
* 2.递推公式
* dp[i][j]=
*   两种情况：
*       1. 如果第i个物品装不进去，即j<nunms[i]，那么不能选nums[i]，那么dp[i][j]=dp[i-1][j]
*       2. 如果第i个物品能装进去，如果不装，那么dp[i][j]=dp[i-1][j]，如果装nums[i],那么dp[i][j]=dp[i-1][j-nums[i]]
* */
public class copy {
    public static void main(String[] args) {
        //        int[] nums = {1,1,1,1,1};
        int[] nums = {1,2,3};
//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int target = 3;
        int result = new copy().findTargetSumWays1(nums, target);
        System.out.println(result);
    }

    //官方答案，动态规划二维数组
    public int findTargetSumWays1(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if((sum-target)%2==1||sum-target<0)
            return 0;
        int neg=(sum-target)/2;
        int n=nums.length;
        int[][] dp=new int[n][neg+1];
        dp[0][0]=1;
        for (int i = 1; i <n ; i++) {
            for (int j = 0; j <=neg ; j++) {
                dp[i][j] = dp[i - 1][j];
                if(j>=nums[i]) {
                    dp[i][j] += dp[i - 1][j - nums[i]];
                }
            }
        }
        return dp[n-1][neg];
    }
}
