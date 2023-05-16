package 代码随想录.动态规划专练.代码随想录.背包问题.背包问题01.背包基础2;

public class Solution {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWight = 4;
        System.out.println(new Solution().testWeightBagProblem(weight, value, bagWight));
    }
    public int testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int[] dp = new int[bagWeight + 1];
        dp[0] = 0;
        for (int i = 0; i < weight.length; i++) {
            for (int j = bagWeight; j >= weight[i]; j--) {
//            for (int j = weight[i]; j <=bagWeight; j++) {//这里不能正序的原因：物品会被放多次。对应的，完全背包应该正序
                dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
            }
        }
        for (int i = 0; i < dp.length; i++) {
            System.out.println(dp[i]);
        }
        return dp[bagWeight];
    }
}
