package 动态规划专练.不同路径II;

public class Code1 {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0}, {0,1,0},{0,0,0},{0,0,0}};
//        int[][] obstacleGrid = {{1,0}};
//        int[][] obstacleGrid = {{0,1,0},{0,1,0},{0,1,0}};
//        int[][] obstacleGrid = {{0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,0},{0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},{0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0},{0,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,1,0,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,0,0},{0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},{0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,1,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,1,0,0,0}};
//        int[][] obstacleGrid = {{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
        int[][] obstacleGrid = {{1,0}};
        int num = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(num);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        dp[0][0]=1-obstacleGrid[0][0];
        if(dp[0][0]==0)
            return 0;
        for (int i = 1; i < m; i++) {
            if(obstacleGrid[i][0]==1)
                break;
            dp[i][0]=1;
        }
        for (int i = 1; i < n; i++) {
            if(obstacleGrid[0][i]==1)
                break;
            dp[0][i]=1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
//                System.out.println(dp[i][j]);
            }
        }
        return dp[m-1][n-1];
    }
}
