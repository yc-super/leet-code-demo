package 动态规划专练.代码随想录.背包问题.背包问题01.背包基础2;
/*
* 01背包的二维数组形式的dp数组，递推公式：dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
* 可以用滚动数组的方式优化空间占用（混动数组我还不太理解），将i省略掉
* 递推公式变为：dp[j]=max(dp[j],dp[j-weight[i]]+value[i]);
*
* 遍历顺序要注意：
* 1.正序遍历物品
* 2.逆序遍历背包容量//是为了不让物品i放入两次，具体可把遍历过程dp[j]的值写出来，正序的值是多少，倒叙的值是多少
* */
public class copy {
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
        for (int i = 0; i <= bagWeight; i++){
            System.out.print(dp[i] + " ");
            System.out.print("\n");
        }
//        return dp[bagWeight];
    }
}
