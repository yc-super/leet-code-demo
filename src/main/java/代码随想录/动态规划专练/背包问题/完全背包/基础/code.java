package 代码随想录.动态规划专练.背包问题.完全背包.基础;
/*
* 所谓的完全背包，就是:
* 有N件物品和一个最多能背重量为W的背包，第i件物品的重量是weight[i]，得到的价值是value[i],
* 每件物品都有无限个，求解将哪些物品放入背包里物品价值总和最大。
*
* 完全背包和01背包最大的不同，就是物品有无限个。
* */
public class code {
    public static void main(String[] args) {
        int[] weight = {1, 3, 4};
        int[] value = {15, 20, 30};
        int bagWeight = 4;
        System.out.println(testCompletePack(weight,value,bagWeight));
    }

    private static int testCompletePack(int[] weight, int[] value, int bagWeight) {
        //01背包是先遍历物品，再倒叙遍历背包，这里说的是一维数组
        int[] dp=new int[bagWeight+1];
        /*for (int i = 0; i <weight.length; i++) {
            for (int j = bagWeight; j >=weight[i] ; j--) {
                dp[j]=Math.max(dp[j],dp[j-weight[i]]+value[i]);
            }
        }*/
        //而完全背包，只要正序遍历背包就可以了(回顾下之前为什么要倒叙，就是因为会重复放入物品
        // 而重复放入物品，就刚好是完全背包)
        for (int i = 0; i < weight.length; i++) {
            for (int j = 0; j <=bagWeight; j++) {
                if(j>=weight[i]) {
                    dp[j] = Math.max(dp[j], dp[j - weight[i]] + value[i]);
                }
            }
        }
        return dp[bagWeight];
    }

}
