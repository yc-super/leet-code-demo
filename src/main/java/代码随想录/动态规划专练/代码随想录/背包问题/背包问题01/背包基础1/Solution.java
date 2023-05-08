package 代码随想录.动态规划专练.代码随想录.背包问题.背包问题01.背包基础1;

public class Solution {
    public int testWeightBagProblem(int[] weight,int[] value,int bagSize){
        // dp[i][j]数据含义：在0-i个物品任意选，放入容量为j的背包，所能获得的最大价值
        int num=weight.length;// 物品数量
        int[][] dp=new int[num][bagSize+1];
        // 递推公式，分为2种情况：
        // 1是第i件物品可以装得下，也就是j>weight[i]，此时从 不装第i件物品获得的价值 和 装第i件物品获得的价值 取最大值：
                //  dp[i][j]=Max(dp[i-1][j],dp[i-1][j-weight[i]]+values[i])
        // 2是第i件物品装不下,dp[i][j]=dp[i-1][j]，和 不装物品i得到的价值 相同
        // 可以看到dp[i][j]是由前面推导出来的，因此要初始化dp[0][j]和dp[i][0]

        // 初始化dp[0][j]，将物品0装入容量为j的背包，大于等于weight[0]的背包得到的价值都是value[0]
        for (int j = weight[0]; j <=bagSize ; j++) {
            dp[0][j]=value[0];
        }

        // 初始化dp[i][0]
        for (int i = 0; i < num; i++) {
            dp[i][0]=0;
        }

        //初始化完成，开始递推
        for (int i = 1; i < num; i++) { // 先遍历物品
            for (int j = 1; j <= bagSize; j++) { // 再遍历背包容量
                if(j>=weight[i]){
                    dp[i][j]=Math.max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[num-1][bagSize];
    }

    public static void main(String[] args) {
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagSize=4;
        System.out.println(new Solution().testWeightBagProblem(weight,value,bagSize));
    }
}
