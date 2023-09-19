package 代码随想录.图论.岛屿面积;

public class Solution {
    // dfs
    // 不使用visited数组
    private int result = 0;
    private int nowCount;
    private int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int maxAreaOfIsland(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    nowCount = 0;
                    back(grid, i, j);
                    result = Math.max(result, nowCount);
                }
            }
        }
        return result;
    }

    private void back(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            nowCount++;
            for (int[] a : move) {
                back(grid, i + a[0], j + a[1]);
            }
        }
    }
}
