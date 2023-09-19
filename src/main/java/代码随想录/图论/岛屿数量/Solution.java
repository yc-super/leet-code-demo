package 代码随想录.图论.岛屿数量;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
        String str="[{\"a\":null}]";
        Map<String,String> map=new HashMap<>();
        JSONArray array = JSONArray.parseArray(str);
        System.out.println();
    }

//    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}};
//        new Solution().numIslands3(grid);
//    }

    // dfs
    boolean[][] isVisited;

    public int numIslands(char[][] grid) {
        int result = 0;
        isVisited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!isVisited[i][j]) {
                    if (grid[i][j] == '1') {
                        result++;
                        backTrack(grid, i, j);
                    }
                }
            }

        }
        return result;
    }

    private void backTrack(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && !isVisited[i][j] && grid[i][j] == '1') {
            isVisited[i][j] = true;
            backTrack(grid, i + 1, j);
            backTrack(grid, i, j + 1);
            backTrack(grid, i, j - 1);
            backTrack(grid, i - 1, j);
        }
    }


    // dfs
    // 不使用visited数组
    private int result2 = 0;

    public int numIslands2(char[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result2++;
                    back(grid, i, j);
                }
            }
        }
        return result2;
    }

    private void back(char[][] grid, int i, int j) {
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            back(grid, i + 1, j);
            back(grid, i, j - 1);
            back(grid, i - 1, j);
            back(grid, i, j + 1);
        }
    }


    // bfs
    public int numIslands3(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    grid[i][j] = '0';
                    Queue<int[]> queue = new LinkedList();
                    queue.offer(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        int[] poll = queue.poll();
                        if (poll[1] + 1 < grid[0].length && grid[poll[0]][poll[1] + 1] == '1') {
                            queue.offer(new int[]{poll[0], poll[1] + 1});
                            grid[poll[0]][poll[1] + 1] = '0';
                        }
                        if (poll[0] + 1 < grid.length && grid[poll[0] + 1][poll[1]] == '1') {
                            queue.offer(new int[]{poll[0] + 1, poll[1]});
                            grid[poll[0] + 1][poll[1]] = '0';
                        }
                        if (poll[1] - 1 >= 0 && grid[poll[0]][poll[1] - 1] == '1') {
                            queue.offer(new int[]{poll[0], poll[1] - 1});
                            grid[poll[0]][poll[1] - 1] = '0';
                        }
                        if (poll[0] - 1 >= 0 && grid[poll[0] - 1][poll[1]] == '1') {
                            queue.offer(new int[]{poll[0] - 1, poll[1]});
                            grid[poll[0] - 1][poll[1]] = '0';
                        }
                    }
                }
            }
        }
        return result;
    }
}
