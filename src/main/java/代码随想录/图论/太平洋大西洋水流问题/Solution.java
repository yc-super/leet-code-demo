package 代码随想录.图论.太平洋大西洋水流问题;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] heights = {{1, 2, 2, 3, 5}, {3, 2, 3, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {5, 1, 1, 2, 4}};
        System.out.println(new Solution().pacificAtlantic(heights));
    }

    private int[][][] bb;
    private int[][] move = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    List<List<Integer>> result;

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        bb = new int[heights.length][heights[0].length][2];
        for (int i = 0; i < heights.length; i++) {
            bb[i][0][0] = 1;
            bb[i][heights[0].length - 1][1] = 1;
        }
        for (int j = 0; j < heights[0].length; j++) {
            bb[0][j][0] = 1;
            bb[heights.length - 1][j][1] = 1;
        }
        for (int i = 0; i < heights.length; i++) {
            dfs0(heights, i, 0);
            dfs1(heights, i, heights[0].length - 1);
        }
        for (int j = 0; j < heights[0].length; j++) {
            dfs0(heights, 0, j);
            dfs1(heights, heights.length - 1, j);
        }

        for (int i = 0; i < bb.length; i++) {
            for (int j = 0; j < bb[0].length; j++) {
                if (bb[i][j][0] == 1 && bb[i][j][1] == 1)
                    result.add(Arrays.asList(i, j));
            }

        }
        return result;
    }

    private void dfs1(int[][] heights, int i, int j) {
        for (int[] k : move) {
            int i1 = i + k[0];
            int j1 = j + k[1];
            if (i1 < 0 || i1 == heights.length || j1 < 0 || j1 == heights[0].length)
                continue;
            if (heights[i][j] <= heights[i1][j1]) {
                if (bb[i1][j1][1] == 0) {
                    bb[i1][j1][1] = 1;
                    dfs1(heights, i1, j1);
                }
            }
        }
    }

    private void dfs0(int[][] heights, int i, int j) {
        for (int[] k : move) {
            int i1 = i + k[0];
            int j1 = j + k[1];
            if (i1 < 0 || i1 == heights.length || j1 < 0 || j1 == heights[0].length)
                continue;
            if (heights[i][j] <= heights[i1][j1]) {
                if (bb[i1][j1][0] == 0) {
                    bb[i1][j1][0] = 1;
                    dfs0(heights, i1, j1);
                }
            }
        }
    }
}
