package 动态规划专练.代码随想录.斐波那契数;

public class Code3 {
    public static void main(String[] args) {
        int n=3;
        int result = fib(n);
        System.out.println(result);
    }
    public static int fib(int n) {
        if(n==0)
            return 1;
        if(n==1)
            return 1;
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for (int i = 2; i < n+1; i++) {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}
