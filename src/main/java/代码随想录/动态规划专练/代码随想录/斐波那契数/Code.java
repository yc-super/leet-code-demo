package 代码随想录.动态规划专练.代码随想录.斐波那契数;

//力扣509
//方式1，递归，比较容易想出来，缺点是有重复计算（重复计算树节点的值）
public class Code {
    public static void main(String[] args) {
        int n = 4;
        int result = fib(n);
        System.out.println(result);
    }

    public static int fib(int n) {
        return fixProblem(n);
    }

    private static int fixProblem(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fixProblem(n - 1) + fixProblem(n - 2);
    }

    //dp
    public int fib2(int n) {
        //1.确定dp及下标含义，dp[k]:下表为k时，对应的斐波那契数
        //2.确定递推公式，dp[k]=dp[k-1]+dp[k-2]
        //3.初始化
        //4.确定遍历顺序
        //5.举例推导
        if (n < 2)
            return n;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

}
