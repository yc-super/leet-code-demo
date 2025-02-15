package 剑指offer.字母迷宫;

import org.apache.ibatis.reflection.ArrayUtil;

import java.util.Arrays;
import java.util.Collections;

import static jdk.nashorn.internal.objects.NativeArray.reverse;

public class Solution {
    boolean[][] vis;
    // 回溯法。思路是没问题的。最佳答案也只是在此基础上做了优化，具体优化见方法2
    public boolean wordPuzzle(char[][] grid, String target) {
        vis=new boolean[grid.length][grid[0].length];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                boolean a=backTrack(sb,grid,target,0,i,j);
                if(a)
                    return true;
            }
        }
        return false;
    }

    private boolean backTrack(StringBuilder sb, char[][] grid, String target,int index, int i, int j) {
        if (!vis[i][j] && grid[i][j] == target.charAt(index)) {
            sb.append(grid[i][j]);
            if (sb.toString().equals(target)) {
                return true;
            }
            if (sb.length() == target.length())
                return false;

            vis[i][j]=true;
            if (i + 1 < grid.length) {
                boolean a = backTrack(sb, grid, target, index + 1, i + 1, j);
                if (a)
                    return true;
            }
            if (j + 1 < grid[0].length) {
                boolean a = backTrack(sb, grid, target, index + 1, i, j + 1);
                if (a)
                    return true;
            }
            if (i - 1 >= 0) {
                boolean a = backTrack(sb, grid, target, index + 1, i - 1, j);
                if (a)
                    return true;
            }
            if (j - 1 >= 0) {
                boolean a = backTrack(sb, grid, target, index + 1, i, j - 1);
                if (a)
                    return true;
            }
            sb.deleteCharAt(sb.length() - 1);
            vis[i][j]=false;
        }
        return false;
    }


    /*
    最佳答案，优化：
    1. vis数组去掉，记录是否访问用原数组grid，访问了将其置空，如果后续不满足条件，再恢复值
    2. 如果target中某个字母的数量，大于grid数组中该字母的数量，直接返回false
    3. 设grid中“target中第一个字母”字母出现的次数为x，grid中“target中最后一个字母”出现的次数为y，如果y>x，则将target翻转，这样就能更早地匹配到正确答案
    上述我的写法中，sb也可省略
    */
    public static void main(String[] args) {
        System.out.println('a'-0);
        System.out.println('z'-0);
        System.out.println('A'-0);
        System.out.println('Z');
    }
}
