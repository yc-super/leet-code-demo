package LeetCode_Hot100.最小路径和;

public class code_copy {
    public static void main(String[] args) {
        int[][] grid = {{1, 3, 3}, {4, 3, 6}, {1, 1, 6}};
//        int[][] grid ={{1,3,1},{1,5,1},{4,2,1}};
//        int[][] grid ={{1,2,3},{4,5,6}};
//        int[][] grid ={{2},{1}};
//        int[][] grid ={{1}};
//        int[][] grid ={{2,1},{2,1}};
        int i = new code_copy().minPathSum(grid);
        System.out.println(i);
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    dp[j] = (j > 0 ? dp[j - 1] : 0) + grid[0][j];
                } else {
                    dp[j] = (j > 0 ? Integer.min(dp[j - 1], dp[j]) : dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n - 1];
    }
}
