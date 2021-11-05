package 动态规划专练.代码随想录.背包问题.背包问题01.最后一块石头的重量II;
/*
首先，这道题实际上就是把石头尽可能分成重量相同的两部分，然后相撞，它们的差值就是答案
实际和上一道题 分割等和子集 是一样的思路

* 1.确定dp数组及下标含义
* dp[j]:表示容量为j的背包能装的最大价值

* 2.确定递推公式
* dp[j]=Max(dp[j],dp[j-weight[i]]+value[i])
* 3.初始化dp数组
*
* 4.确定遍历顺序
*
* 5.举例推导dp数组
* */
public class code {
    public static void main(String[] args) {
//        int[] stones = {2,7,4,1,8,1};
        int[] stones = {31,26,33,21,40};
        int i = lastStoneWeightII(stones);
        System.out.println(i);
    }
    public static int lastStoneWeightII(int[] stones) {
        int sum=0;
        for(int num:stones){
            sum+=num;
        }
        int target=sum/2;
        int[] dp=new int[target+1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = target; j >=stones[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[target]-dp[target];
    }
}
