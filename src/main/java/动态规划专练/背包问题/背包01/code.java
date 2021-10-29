package 动态规划专练.背包问题.背包01;
/*
* 1. 确定dp数组及下标的含义
*   dp[i][j]:表示物品0-i放入容量为j的背包，存放的物品最大价值总和
* 2. 确定递推公式
*   有两种情况可以得到dp[i][j]:
*       (1)不放物品i:dp[i][j]=dp[i-1][j],其实就是放了0到i-1物品后，放不下第i个物品，因此和不放i的结果一样
*       (2)放物品i:dp[i][j]=dp[i-1][j-weight[i]]+value[i]
*   因此dp[i][j]=max(dp[i-1][j],dp[i-1][j-weight[i]]+value[i])
* 3. 初始化dp数组
*   从dp数组可以看出，dp[i][j]都是由左上方的值推导出来的，因此dp[0][j]需要初始化。
*   初始化dp[0][j]:
*       也就是背包容量为j,存放物品0，背包能装下的最大价值
*       显然，当物品0的重量小于等于背包容量时，值为物品0的价值；否则值为0
*   当背包容量为0时，也就是dp[i][0],背包能装下的最大价值都为0
*
* 4. 确定遍历顺序
*   从前往后
* 5. 举例推导dp数组
*   	    重量	价值
    物品0	1	15
    物品1	3	20
    物品2	4	30
* */
public class code {
    public static void main(String[] args) {
        int[] weight={1,3,4};
        int[] value={15,20,30};
        int bagWeight=4;
        int result = bagProblem(weight, value,bagWeight);
        System.out.println(result);
    }
    public static int bagProblem(int[] weight,int[] value,int bagWeight){
        int[][] dp=new int[weight.length][bagWeight+1];//数组默认值应该都是0吧
        /*for (int i = 0; i < weight.length+1; i++) {
            dp[i][0]=0;
        }*/
        for (int i =weight[0]; i <bagWeight+1 ; i++) {
            dp[0][i]=value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 1; j <= bagWeight; j++) {
                if(j<weight[i]){
                    dp[i][j]=dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        return dp[weight.length-1][bagWeight];


        //"formsubsys","purchasesubsys","documentmanager","techsubsys","financesubsys","subinfosubsys","fjytpmsubsys","softwaresubsys","printsubsys","form2subsys","integratedsubsys","financesubsys2","hrsubsys","suppliersubsys","manufactorysubsys","hsesubsys","systemcenter","webform4subsys","overseesubsys","srfilesubsys","hse2subsys","itsubsys",
    }
}
