package LeetCode.可以攻击国王的皇后;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> result = new ArrayList<>();
        int i, j;
        int[][] qipan = new int[8][8];
        for (int k = 0; k < queens.length; k++) {
            for (int l = 0; l < queens[0].length; l++) {
                qipan[queens[k][0]][queens[k][1]] = 1;
            }
        }
        i = king[0];
        j = king[1];
        i--;
        j--;
        while (i >= 0 && j >= 0) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            i--;
            j--;
        }
        i = king[0];
        j = king[1];
        i--;
        while (i >= 0) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            i--;
        }
        i = king[0];
        j = king[1];
        i--;
        j++;
        while (i >= 0 && j < 8) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            i--;
            j++;
        }
        i = king[0];
        j = king[1];
        j++;
        while (j < 8) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            j++;
        }
        i = king[0];
        j = king[1];
        i++;
        j++;
        while (i < 8 && j < 8) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            i++;
            j++;
        }
        i = king[0];
        j = king[1];
        i++;
        while (i < 8) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            i++;
        }
        i = king[0];
        j = king[1];
        i++;
        j--;
        while (i < 8 && j >= 0) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            i++;
            j--;
        }
        i = king[0];
        j = king[1];
        j--;
        while (j >= 0) {
            if (qipan[i][j] == 1) {
                List<Integer> l = new ArrayList<>();
                l.add(i);
                l.add(j);
                result.add(l);
                break;
            }
            j--;
        }
        return result;
    }


    // 灵神优雅的写法，一样的思路，从国王视角出发向8个方向看
    private int[][] direction = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};

    public List<List<Integer>> queensAttacktheKing2(int[][] queens, int[] king) {
        boolean[][] isQueen = new boolean[8][8];
        List<List<Integer>> result = new ArrayList<>();
        for (int[] a : queens) {
            isQueen[a[0]][a[1]] = true;
        }
        int x, y;
        for (int[] aa : direction) {
            x = king[0]+aa[0];
            y = king[1]+aa[1];
            while (x >= 0 && x < 8 && y >= 0 && y < 8) {
                if (isQueen[x][y]) {
                    result.add(Arrays.asList(x, y));
                    break;
                }
                x += aa[0];
                y += aa[1];
            }
        }
        return result;
    }
}
