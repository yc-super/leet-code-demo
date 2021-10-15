package 动态规划专练.整数拆分;
/*
* 输入: 10 输出: 36 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
* 说明: 你可以假设 n 不小于 2 且不大于 58。

* 2     1+1     1*1=1
* 3     1+2     1*2=2
* 4     2+2     2*2=4
* 5     2+3     2*3=6
* 6     3+3     3*3=9
* 7     2+2+3   2*2*3=12
* 8     2+9     2*9=18
* 9     3+3+3   3*3*3=27
*
* 1.确定dp数组及下标的含义
*   dp[i]:分拆数字i，可以得到的最大乘积为dp[i]
* 2.确定递推公式：
*   dp[i]=Max((i-j)*j,(i-j)*dp[j])
* 3.dp的初始化
*   dp[2]=1,dp[3]=2
* 4.确定遍历顺序
*   从前往后
* 5.举例推导dp数组
*   以10来举例
*
* */
public class Code {
    public static void main(String[] args) {
        int n=3;
        int m = integerBreak(n);
        System.out.println(m);
    }
    public static int integerBreak(int n) {
        if(n==2)
            return 1;
        int[] dp=new int[n+1];
        dp[2]=1;
        dp[3]=2;
        for (int i = 3; i < n+1; i++) {
            for (int j = 1; j <= i/2; j++) {
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,j*dp[i-j]));
            }
        }
        return dp[n];
    }
}
