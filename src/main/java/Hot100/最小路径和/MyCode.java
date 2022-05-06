package Hot100.最小路径和;
/*
* 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。

说明：每次只能向下或者向右移动一步。
*
* 输入：grid = [
* [1,3,1],
* [1,5,1],
* [4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。
*
* 输入：grid = [
* [1,3,3],
* [4,3,6]
* [1,1,6]
* ]
输出：12
* */
//第一想到的是递归，维护一个最小值，不断更新最小值-----超时了
//优化的话，可能可以用动态规划
public class MyCode {
    public static void main(String[] args) {
//        int[][] grid ={{1,3,3},{4,3,6},{1,1,6}};
//        int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
//        int[][] grid ={{1,2,3},{4,5,6}};
//        int[][] grid ={{2},{1}};
//        int[][] grid ={{1}};
        int[][] grid ={{2,1},{2,1}};
        int i = new MyCode().minPathSum2(grid);
        System.out.println(i);
    }

    /*
     * [1,3,3],
     * [4,3,6]
     * [1,1,6]
     * */
    /*
    * 方法2，动态规划
    * 1.表达式：dp[a][b]:a,b代表下标，dp[a][b]代表到达graid[a][b]的最小路程
    * 2.递推公式：dp[a][b]=min(dp[a-1[b],dp[a][b-1])+grid[a][b]
    * 3.初始化：dp[0][0]=grid[0][0],dp[1][0]=grid[0][0]+grid[1][0],dp[0][1]=grid[0][0]+grid[1][1]
    * 4.验证
    * */
    public int minPathSum2(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        int[][] dp=new int[m][n];
        dp[0][0]=grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0]=dp[i-1][0]+grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i]=dp[0][i-1]+grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                //grid[m][n];
                dp[i][j]=Integer.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }

        }
        return dp[m-1][n-1];
    }


    int min=Integer.MAX_VALUE;
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        calMin(grid,0,0,m,n,0,0);
        return min;
    }
/*
* [1,3,3],
 * [4,3,6]
 * [1,1,6]
* */
    private void calMin(int[][] grid,int nowSum,int count,int m,int n,int m1,int n1) {

        nowSum+=grid[m1][n1];
        count++;
        if(count==m+n-1){
            min=min<=nowSum?min:nowSum;
            return;
        }
        //往下
        if(m1<m-1)
            calMin(grid,nowSum,count,m,n,m1+1,n1);
        //往右
        if(n1<n-1)
            calMin(grid,nowSum,count,m,n,m1,n1+1);

    }
}
