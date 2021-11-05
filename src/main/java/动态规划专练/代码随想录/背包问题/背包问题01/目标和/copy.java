package 动态规划专练.代码随想录.背包问题.背包问题01.目标和;
/*
* 将数组分成两部分，tr为加上负号的一部分，那么另一部分就是sum-tr,并且(sum-tr)-tr=target,那么tr=(sum-target)/2,要求tr>=0
* 这道题和前面几道题不同点在于，前面几道题都是求最大能装的价值，这道题是求能组成最大值的方式有几种
* 1.定义dp数组及下标的含义
* dp[i][j]:表示将前i个物品放入容量为j的背包中，装满的方式有几种
* 2.递推公式
* dp[i][j]=
*   两种情况：
*       1. 如果第i个物品装不进去，那么dp[i][j]=dp[i-1][j-weight[i]]
*       2. 如果第i个物品装进去，那么dp[i][j]=dp[i-1][j-weight[i]]
* */
public class copy {
    public static void main(String[] args) {
        //        int[] nums = {1,1,1,1,1};
//        int[] nums = {1,2,3};
        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        int target = 0;
        int result = new code2().findTargetSumWays2(nums, target);
        System.out.println(result);
    }

    //官方答案，动态规划二维数组
    public int findTargetSumWays1(int[] nums, int target) {

        return 0;
    }
}
