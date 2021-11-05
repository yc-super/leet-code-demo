package 动态规划专练.代码随想录.背包问题.背包问题01.一和零;
/*
* ["10", "0001", "111001", "1", "0"], m = 5, n = 3
* array0=[1,3,2,0,1]
* array1=[1,1,4,1,0]
*
* 1. 定义dp数组及下标含义：dp[i][j],表示最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
* 直接定义要求的结果我是没想到的。
* 2.递推公式
* dp[i][j]=Max(dp[i][j],dp[i-zeroNum][j-oneNum])
*
* 好好看看代码随想录的思路，这是典型的01背包，其中，m和n代表的含义：其实是两个维度的背包容量(weight[i])，
* 字符串本身的个数相当于物品的价值（value[i],每个value[i]都等于1）
* https://programmercarl.com/0474.%E4%B8%80%E5%92%8C%E9%9B%B6.html#%E6%80%9D%E8%B7%AF
* */
public class code {
    public static void main(String[] args) {
        String[] strs={"10", "0001", "111001", "1", "0"};
        int m=5,n=3;
        int maxForm = new code().findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j]表示i个0和j个1时的最大子集
        int[][] dp = new int[m + 1][n + 1];
        int oneNum, zeroNum;
        for (String str : strs) {
            oneNum = 0;
            zeroNum = 0;
            for (char ch : str.toCharArray()) {
                if (ch == '0') {
                    zeroNum++;
                } else {
                    oneNum++;
                }
            }
            //倒序遍历
            for (int i = m; i >= zeroNum; i--) {
                for (int j = n; j >= oneNum; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeroNum][j - oneNum] + 1);
                }
            }
        }
        return dp[m][n];
    }
}
