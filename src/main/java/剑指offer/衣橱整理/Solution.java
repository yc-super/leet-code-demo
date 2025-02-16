package 剑指offer.衣橱整理;

// 回溯法，注意vis不会被重置
public class Solution {
    public static void main(String[] args) {
        int m = 100, n = 100;
        System.out.println(new Solution().wardrobeFinishing(m, n, 20));
    }

    boolean[][] vis;
    int result = 0;

    public int wardrobeFinishing(int m, int n, int cnt) {
        vis = new boolean[m][n];
        dfs(0, 0, m, n, cnt);
        return result;
    }

    private void dfs(int i, int j, int m, int n, int cnt) {
        vis[i][j] = true;
        if (getMyValue(i) + getMyValue(j) > cnt)
            return;
        result++;
        if (i + 1 < m && !vis[i + 1][j])
            dfs(i + 1, j, m, n, cnt);
        if (j + 1 < n && !vis[i][j + 1])
            dfs(i, j + 1, m, n, cnt);
    }

    private int getMyValue(int i) {
        int result = 0;
        while (i != 0) {
            int i1 = i % 10;
            i /= 10;
            result += i1;
        }
        return result;
    }
}
