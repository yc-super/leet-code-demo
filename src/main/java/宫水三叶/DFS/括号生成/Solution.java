package 宫水三叶.DFS.括号生成;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        List<String> strings = new Solution().generateParenthesis(3);
        System.out.println();
    }


    /*
     * 我的题解，经典的dfs，回溯法
     * */
    List<String> ans;

    public List<String> generateParenthesis(int n) {
        ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        myDFS(n, sb, 0, 0, new char[]{'(', ')'});
        return ans;
    }

    // ((()
    private void myDFS(int n, StringBuilder sb, int c1, int c2, char[] array) {
        if (c1 == n && c2 == n) {
            ans.add(sb.toString());
            return;
        }
        if (c2 > c1 || c1 > n)
            return;

        for (int i = 0; i < 2; i++) {
            sb.append(array[i]);
            if (array[i] == '(') {
                c1++;
            } else {
                c2++;
            }
            myDFS(n, sb, c1, c2, array);
            char c = sb.charAt(sb.length() - 1);
            if (c == '(') {
                c1--;
            } else {
                c2--;
            }
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}
