package 代码随想录.图论.最大人工岛;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {

    //方法1,自己想的，超时了
//    public int largestIsland(int[][] grid) {
//        Set<String> s1 = new HashSet<>();
//        Set<String> s2 = new HashSet<>();
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[0].length; j++) {
//                if (grid[i][j] == 1) {
//                    for (int[] k : move) {
//                        int i1 = i + k[0];
//                        int j1 = j + k[1];
//                        if (i1 >= 0 && i1 < grid.length && j1 >= 0 && j1 < grid[0].length) {
//                            if (grid[i1][j1] == 0) {
//                                String temp = i1 + "," + j1;
//                                if (s1.contains(i1 + "," + j1)) {
//                                    s2.add(temp);
//                                } else {
//                                    s1.add(i1 + "," + j1);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//        vis = new boolean[grid.length][grid[0].length];
//        if (!s2.isEmpty()) {
//            daoyu(s2, grid);
//        } else if (!s1.isEmpty()) {
//            daoyu(s1, grid);
//        } else {
//            if (grid[0][0] == 1)
//                return grid.length * grid[0].length;
//        }
//        return max;
//    }
//
//    private void daoyu(Set<String> s2, int[][] grid) {
//        for (String ss : s2) {
//            fill(vis);
//            String[] split = ss.split(",");
//            grid[Integer.valueOf(split[0])][Integer.valueOf(split[1])] = 1;
//            for (int i = 0; i < grid.length; i++) {
//                for (int j = 0; j < grid[0].length; j++) {
//                    if (grid[i][j] == 1 && !vis[i][j]) {
//                        nowCount = 1;
//                        vis[i][j] = true;
//                        backTrack(grid, i, j);
//                        max = Math.max(max, nowCount);
//                    }
//                }
//            }
//            grid[Integer.valueOf(split[0])][Integer.valueOf(split[1])] = 0;
//        }
//    }
//
//    private void fill(boolean[][] vis) {
//        for (int i = 0; i < vis.length; i++) {
//            for (int j = 0; j < vis[0].length; j++) {
//                vis[i][j] = false;
//            }
//        }
//    }
//
//    private void backTrack(int[][] grid, int i, int j) {
//        for (int[] k : move) {
//            int i1 = i + k[0];
//            int j1 = j + k[1];
//            if (i1 >= 0 && i1 < grid.length && j1 >= 0 && j1 < grid[0].length) {
//                if (!vis[i1][j1] && grid[i1][j1] == 1) {
//                    nowCount++;
//                    vis[i1][j1] = true;
//                    backTrack(grid, i1, j1);
//                }
//            }
//        }
//
//    }
//
//    private int max = 1;
//    private int nowCount = 1;
//    boolean[][] vis;
//
//    int[][] move = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};


    private static final int[][] position = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};  // 四个方向

    /**
     * @param grid 矩阵数组
     * @param row 当前遍历的节点的行号
     * @param col 当前遍历的节点的列号
     * @param mark 当前区域的标记
     * @return 返回当前区域内 1 的数量
     */
    public int dfs(int[][] grid, int row, int col, int mark) {
        int ans = 0;
        grid[row][col] = mark;
        for (int[] current: position) {
            int curRow = row + current[0], curCol = col + current[1];
            if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) continue;  // 越界
            if (grid[curRow][curCol] == 1)
                ans += 1 + dfs(grid, curRow, curCol, mark);
        }
        return ans;
    }

    public int largestIsland(int[][] grid) {
        int ans = Integer.MIN_VALUE, size = grid.length, mark = 2;
        Map<Integer, Integer> getSize = new HashMap<>();
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                if (grid[row][col] == 1) {
                    int areaSize = 1 + dfs(grid, row, col, mark);
                    getSize.put(mark++, areaSize);
                }
            }
        }
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                // 当前位置如果不是 0 那么直接跳过，因为我们只能把 0 变成 1
                if (grid[row][col] != 0) continue;
                Set<Integer> hashSet = new HashSet<>();     // 防止同一个区域被重复计算
                // 计算从当前位置开始获取的 1 的数量，初始化 1 是因为把当前位置的 0 转换成了 1
                int curSize = 1;
                for (int[] current: position) {
                    int curRow = row + current[0], curCol = col + current[1];
                    if (curRow < 0 || curRow >= grid.length || curCol < 0 || curCol >= grid.length) continue;
                    int curMark = grid[curRow][curCol];     // 获取对应位置的标记
                    // 如果标记存在 hashSet 中说明该标记被记录过一次，如果不存在 getSize 中说明该标记是无效标记(此时 curMark = 0)
                    if (hashSet.contains(curMark) || !getSize.containsKey(curMark)) continue;
                    hashSet.add(curMark);
                    curSize += getSize.get(curMark);
                }
                ans = Math.max(ans, curSize);
            }
        }
        // 当 ans == Integer.MIN_VALUE 说明矩阵数组中不存在 0，全都是有效区域，返回数组大小即可
        return ans == Integer.MIN_VALUE ? size * size : ans;
    }
}
