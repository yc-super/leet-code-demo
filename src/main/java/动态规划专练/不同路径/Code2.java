package 动态规划专练.不同路径;
//果然还是有优化空间的方法，滚动数组。但是我理解不了啊呜呜呜
public class Code2 {
    public static void main(String[] args) {
        int m=2,n=4;
        int num=uniquePaths(m,n);
        System.out.println(num);
    }
    public static int uniquePaths(int m, int n) {
        int[] dp=new int[Math.max(m,n)];
        for (int i = 0; i < n; i++)
            dp[i] = 1;
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n; i++) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[n - 1];
    }
}
