package 代码随想录.贪心算法.分发饼干;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int result = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int len_g = g.length;
        int len_s = s.length;
        while (i < len_g && j < len_s) {
            if (g[i] <= s[j]) {
                result++;
                i++;
            }
            j++;
        }
        return result;
    }
}
