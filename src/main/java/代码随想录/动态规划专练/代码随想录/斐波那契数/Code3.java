package 代码随想录.动态规划专练.代码随想录.斐波那契数;
//方式3，动态规划
public class Code3 {
    public static void main(String[] args) {
        int n=3;
        int result = fib(n);
        System.out.println(result);
    }
    public static int fib(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;

        //1.确定dp及下标定义：下标代表n，dp[n]代表k=n时的值，dp[n]就是所求答案
        int[] dp = new int[n + 1];

        //2.确定递推公式
        //dp[k]=dp[k-1]+dp[k-2];

        //3.dp数组初始化
        dp[0] = 0;
        dp[1] = 1;

        //4.确定顺序：从前到后
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }

        //5.举例推导
        return dp[n];
    }
}
