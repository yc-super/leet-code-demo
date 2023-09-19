package LeetCode.检查骑士巡视方案;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[][] grid = {{24, 11, 22, 17, 4}, {21, 16, 5, 12, 9}, {6, 23, 10, 3, 18}, {15, 20, 1, 8, 13}, {0, 7, 14, 19, 2}};
        boolean b = new Solution().checkValidGrid(grid);
        System.out.println();
    }

    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0)
            return false;
        Map<Integer, int[]> map = new HashMap<>();
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map.put(grid[i][j], new int[]{i, j});
            }
        }
        n = n * n - 1;
        int preI = map.get(n)[0];
        int preJ = map.get(n)[1];
        n--;
        while (n >= 0) {
            int nowI = map.get(n)[0];
            int nowJ = map.get(n)[1];
            if (!checkVal(preI, preJ, nowI, nowJ)) {
                return false;
            }
            preI = nowI;
            preJ = nowJ;
            n--;
        }
        return true;
    }

    private boolean checkVal(int preI, int preJ, int nowI, int nowJ) {
        int a = Math.abs(preI - nowI);
        int b = Math.abs(preJ - nowJ);
        if ((a == 1 && b == 2) || (a == 2 && b == 1)) {
            return true;
        }
        return false;
    }
}
