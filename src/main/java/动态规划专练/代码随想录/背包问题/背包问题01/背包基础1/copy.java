package 动态规划专练.代码随想录.背包问题.背包问题01.背包基础1;
/*
* 1.确定dp数组及下标含义：
* dp[i][j]:表示将物品0-i装进容量为j的背包中，所能装的最大价值
* 2.确定递推公式
* dp[i][j]=Max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i]);
* 3.初始化dp数组：
* 由递推公式可知是左上角推出的，而：
* 将物品0装入容量为j的背包，也就是dp[0][j],当物品0的重量小于等于j时，dp[0][j]=value[0]
* 将物品装入容量为0的背包，也就是dp[i][0]=0
*
* 其实也可以不初始化dp[0][j],不过定义dp数组时，物品要从1开始算，相较于上面的定义，要多一行数据。
* 具体见代码随想录的写法，他没有初始化dp[0][j],但dp[weight.length+1][bagWeight]
* */
public class copy {
    public static void main(String[] args) {
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagWeight=4;
        int result = bagProblem(weight, value,bagWeight);
        System.out.println(result);
    }
    public static int bagProblem(int[] weight,int[] value,int bagWeight){
        int wlen=weight.length;
        int[][] dp=new int[wlen][bagWeight+1];
        for (int j = weight[0]; j <=bagWeight ; j++) {
            dp[0][j]=value[0];
        }
        for (int i = 1; i < wlen; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if(j<weight[i]) {
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[wlen-1][bagWeight];
    }
}
