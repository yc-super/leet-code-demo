package 其他.year2024.最长回文子串;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String s="abaaaa";
        System.out.println(new Solution().method(s));
    }
    public String method(String s) {
        int len = s.length();
        int maxCount = 1;
        int maxI = 0, maxJ = 0;
        boolean[][] dp = new boolean[len][len];
        Arrays.fill(dp[len-1],true);
        for (int i = len-2; i >=0; i--) {
            for (int j = i; j < len; j++) {
                if (i == j) {
                    dp[i][j] = true;
                } else if (j - i == 1) {
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxCount) {
                            maxCount = j - i + 1;
                            maxI = i;
                            maxJ = j;
                        }
                    }
                } else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        if (j - i + 1 > maxCount) {
                            maxCount = j - i + 1;
                            maxI = i;
                            maxJ = j;
                        }
                    }
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }
}
