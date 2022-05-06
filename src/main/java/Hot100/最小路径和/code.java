package Hot100.最小路径和;

//仍然是动态规划，只不过优化了空间
/*
* 思路：只维护一个一维数组，dp[j]:代表到当前点最小路径长，不断更新
* */
public class code {
    public static void main(String[] args) {
        int[][] grid ={{1,3,3},{4,3,6},{1,1,6}};
//        int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
//        int[][] grid ={{1,2,3},{4,5,6}};
//        int[][] grid ={{2},{1}};
//        int[][] grid ={{1}};
//        int[][] grid ={{2,1},{2,1}};
        int i = new code().minPathSum(grid);
        System.out.println(i);
    }
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[j] = (j - 1 >= 0 ? dp[j - 1] : 0) + grid[i][j];
                } else {
                    dp[j] = grid[i][j] + (j - 1 >= 0 ? Math.min(dp[j], dp[j - 1]) : dp[j]);
                }
            }
        }
        return dp[n - 1];
    }
}
