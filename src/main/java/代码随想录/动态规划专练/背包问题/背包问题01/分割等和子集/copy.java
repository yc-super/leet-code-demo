package 代码随想录.动态规划专练.背包问题.背包问题01.分割等和子集;
/*
* 1.定义dp数组及下标含义：
* 根据题意，如果存在等和子集，那么这两个子集的各自的和应该都是sum/2，那么问题就转化成了，从数组中取出若干个数，
* 放入背包容量为sum/2中，能否把背包放满，也就是dp[i]是否等于sum/2
* dp[i][j]:把物品0-i放入容量为j的背包，最大能放的价值总和
*
* 2.递推公式
* dp[j]=max(dp[j],dp[j-weight[i]]+value[i]);
* 其中，weight[i]和value[i]都等于nums[i]
* */
public class copy {
    public static void main(String[] args) {
        int []nums = {1,5,11,5};
        boolean b = canPartition(nums);
        System.out.println(b);
    }
    public static boolean canPartition(int[] nums) {
        int len=nums.length;
        int sum=0;
        for (int i = 0; i < len; i++) {
            sum+=nums[i];
        }
        if(sum%2==1)
            return false;
        int tar=sum/2;
        int[] dp=new int[tar+1];
        for (int i = 0; i < len; i++) {
            for (int j = tar; j >=nums[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-nums[i]]+nums[i]);
            }

        }
        return dp[tar]==tar;
    }
}
