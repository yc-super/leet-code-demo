package 代码随想录.动态规划专练.背包问题.背包问题01.最后一块石头的重量II;
/*
* 1.确定dp数组及下标含义
* 通过题意可知：实际就是把数组尽可能分成相同大小的两部分，相减即可得到答案.可以通过转化成01背包问题来解决
* dp[j]：容量为j的背包中，最大能装的物品价值总和
* 2.递推公式：
* dp[j]=max(dp[j],dp[j-weight[i]]+value[i])
* 其中，weight[i]和value[i]都等于stones[i]
* */
public class copy {
    public static void main(String[] args) {
        int[] stones = {2,7,4,1,8,1};
//        int[] stones = {31,26,33,21,40};
        int i = lastStoneWeightII(stones);
        System.out.println(i);
    }
    public static int lastStoneWeightII(int[] stones) {
        int stoneLen=stones.length;
        int sum=0;
        for (int i = 0; i < stoneLen; i++) {
            sum+=stones[i];
        }
        int tar=sum/2;
        int[] dp=new int[tar+1];
        for (int i = 0; i < stoneLen; i++) {
            for (int j = tar; j >=stones[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-stones[i]]+stones[i]);
            }
        }
        return sum-dp[tar]-dp[tar];
    }
}
