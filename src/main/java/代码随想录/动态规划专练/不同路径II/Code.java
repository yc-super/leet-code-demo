package 代码随想录.动态规划专练.不同路径II;
/*
*相比 不同路径 ，这道题只是多了个障碍，只要在推导dp[k]时dp[k][j]=dp[k-1][j]+dp[k][j-1];注意obstacleGrid[k-1][j]和obstacleGrid[k][j-1]是否为1
* ，也就是上面或左面是否有障碍物就行了
*
* */
public class Code {
    public static void main(String[] args) {
//        int[][] obstacleGrid = {{0,0,0}, {0,1,0},{0,0,0},{0,0,0}};
//        int[][] obstacleGrid = {{1,0}};
        int[][] obstacleGrid = {{0,1,0},{0,1,0},{0,1,0}};
//        int[][] obstacleGrid = {{0,1,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,1,1,0,0,0,0,0,0,1,0},{0,0,0,1,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,1,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,1,0,0,0,1,1,0,0,0,0,0,0},{0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0,0},{0,0,0,0,1,0,0,1,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,1,0},{0,0,0,0,1,0,0,0,0,0,1,0,0,0,0,0,0,0,0,1,0,1,0,0,0,0,0,0,0,0,0},{0,0,1,1,0,0,0,0,1,0,1,0,0,0,0,0,0,0,1,0,0,1,1,0,1,0,0,0,0,0,0},{0,1,0,1,0,0,0,0,0,1,0,0,0,0,1,0,0,0,0,1,0,0,1,0,1,0,0,1,1,0,0},{0,0,0,0,1,1,0,0,0,0,0,0,0,1,0,0,0,1,1,0,0,1,0,0,0,1,1,0,1,0,0},{0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,0},{0,0,0,1,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,1,0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0,0,0,1,0,0,0,0},{0,1,0,1,1,0,0,0,0,0,0,0,1,0,0,0,0,1,0,0,1,1,0,0,0,0,1,1,0,0,0}};
//        int[][] obstacleGrid = {{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0},{0}};
        int num = uniquePathsWithObstacles(obstacleGrid);
        System.out.println(num);
    }
    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if(obstacleGrid[0][0]==1)
            return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        int i=0;
        for (i = 0; i < m; i++) {
            if(obstacleGrid[i][0]==1){
                dp[i][0]=0;
                break;
            }else {
                dp[i][0] = 1;
            }
        }
        if(n==1&&i!=m)
            return 0;
        if(n==1&&i==m)
            return 1;
        for (int j = i+1; j < m; j++) {
            dp[j][0]=0;
        }
        for (i = 0; i < n; i++) {
            if(obstacleGrid[0][i]==1){
                dp[0][i]=0;
                break;
            }else {
                dp[0][i] = 1;
            }
        }
        if(m==1&&i!=n)
            return 0;
        if(m==1&&i==n)
            return 1;
        for (int j = i+1; j < n; j++) {
            dp[0][j]=0;
        }
        for (i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
                if(obstacleGrid[i][j]==1)
                    dp[i][j]=0;
            }
        }
        return dp[m-1][n-1];
    }

    public static int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        if(obstacleGrid[0][0]==1)
            return 0;
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m][n];
        int index;
        for (index = 0; index < n; index++) {
            if(obstacleGrid[0][index]==0) {
                dp[0][index] = 1;
            }else{
                break;
            }
        }
        for (index = 0; index < m; index++) {
            if(obstacleGrid[index][0]==0) {
                dp[index][0] = 1;
            }else{
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if(obstacleGrid[i][j]==0)
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
