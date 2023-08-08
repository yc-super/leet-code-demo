package 代码随想录.动态规划专练.不同路径;
//试试优化空间复杂度
/*dp[i][j]=dp[i-1][j]+dp[i][j-1],本来以为dp[i][j]只由dp[i-1][j]和dp[i][j-1]决定，
但是不能像前几个算法一样那么优化空间复杂度
 */
public class Code1 {
    public static void main(String[] args) {
//        int m=3,n=7;
//        int m=7,n=3;
//        int m=3,n=3;
        int m=2,n=4;
        int num=uniquePaths(m,n);
        System.out.println(num);
    }
    public static int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }

        int a=1,b=1,c=2;


        return dp[m-1][n-1];
    }
}
