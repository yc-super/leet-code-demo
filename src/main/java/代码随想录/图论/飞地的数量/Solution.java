package 代码随想录.图论.飞地的数量;

public class Solution {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{0, 1, 1, 0, 0}};
        System.out.println(new Solution().numEnclaves(grid));
    }

    private int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public int numEnclaves(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j ++) {
                if (i == 0 || i == grid.length-1 || j == 0 || j == grid[0].length-1)
                    if (grid[i][j] == 1) {
                        back(grid, i, j);
                    }
            }
        }
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 || i == grid.length - 1 || j == 0 || j == grid[0].length - 1)
                    continue;
                if (grid[i][j] == 1) {
                    sum++;
                }
            }
        }

        return sum;
    }

    private void back(int[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            for (int[] a : move) {
                back(grid, i + a[0], j + a[1]);
            }
        }
    }
}
