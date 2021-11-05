package 动态规划专练.代码随想录.背包问题.背包问题01.背包基础2;

public class code1 {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        testWeightBagProblem(weight, value, bagWeight);
    }

    private static void testWeightBagProblem(int[] weight, int[] value, int bagWeight) {
        int wLen=weight.length;
        int[] dp=new int[bagWeight+1];
        for (int i = 0; i < wLen; i++) {
            for (int j = bagWeight; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }
        //打印dp数组
        for (int j = 0; j <= bagWeight; j++){
            System.out.println(dp[j] + " ");
        }
    }
}
