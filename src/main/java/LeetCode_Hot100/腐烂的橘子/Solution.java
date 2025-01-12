package LeetCode_Hot100.腐烂的橘子;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
//        int[][] grid={{1,1,1},{1,1,0},{0,1,1}};
        int[][] grid = {{2, 2, 2}, {2, 2, 0}, {0, 2, 2}};
        int i = new Solution().orangesRotting(grid);
        System.out.println(i);
    }

    public int orangesRotting(int[][] grid) {
        List<Integer[]> list = new ArrayList<>();
        int count = 0;// 新鲜橘子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    list.add(new Integer[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        if (count == 0) {
            return 0;
        }
        if (list.size() == 0) {
            return -1;
        }
        List<Integer[]> temp = new ArrayList<>();
        int index = 0;
        int result = 0;
        while (true) {
            while (list.size() > index) {
                Integer[] l = list.get(index);
                index++;
                int m = l[0], n = l[1];
                if (m > 0) {
                    if (grid[m - 1][n] == 1) {
                        temp.add(new Integer[]{m - 1, n});
                        grid[m - 1][n] = 2;
                    }
                }
                if (n > 0) {
                    if (grid[m][n - 1] == 1) {
                        temp.add(new Integer[]{m, n - 1});
                        grid[m][n - 1] = 2;
                    }
                }
                if (m < grid.length - 1) {
                    if (grid[m + 1][n] == 1) {
                        temp.add(new Integer[]{m + 1, n});
                        grid[m + 1][n] = 2;
                    }
                }
                if (n < grid[0].length - 1) {
                    if (grid[m][n + 1] == 1) {
                        temp.add(new Integer[]{m, n + 1});
                        grid[m][n + 1] = 2;
                    }
                }
            }
            if (temp.size() == 0) {
                for (int i = 0; i < grid.length; i++) {
                    for (int j = 0; j < grid[0].length; j++) {
                        if (grid[i][j] == 1) {
                            return -1;
                        }
                    }
                }
                return result;
            }
            result++;
            index = 0;
            list = new ArrayList<>(temp);
            temp.clear();
        }
    }
}
