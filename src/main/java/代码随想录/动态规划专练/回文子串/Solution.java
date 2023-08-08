package 代码随想录.动态规划专练.回文子串;

public class Solution {
    public static void main(String[] args) {
        //aabbaaca
        //bbbab
        //cbbd
        String s = "abac";
        System.out.println(new Solution().countSubstrings2(s));
    }

    //最先想到的是双指针暴力法
    public int countSubstrings(String s) {
        int len = s.length();
        int l, r;
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j >= i; j--) {
                l = i;
                r = j;
                while (l <= r) {
                    if (s.charAt(l) != s.charAt(r)) {
                        break;
                    }
                    l++;
                    r--;
                }
                if (l > r) {
                    count++;
                }
            }
        }
        return count;
    }

    //dp[i][j]:以i开头以j结尾的子串是否是回文子串
    // dp[i][j]=dp[i+1][j-1]
    public int countSubstrings2(String s) {
        int len = s.length();
        int count = 0;
        boolean[][] dp = new boolean[len][len];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    int a = j - i;
                    if (a <= 2) {
                        count++;
                        dp[i][j] = true;
                    } else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //双指针中心扩散法.O(n2),O(1)
    public int countSubstrings3(String s) {
        //2种情况，1是以i为中心，2是以i和i+1为中心（奇数或偶数个数）
        int result = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            result += getCount(s, i, i, len);
            result += getCount(s, i, i + 1, len);
        }
        return result;
    }

    private int getCount(String s, int i, int j, int len) {
        int count = 0;
        while (i >= 0 && j < len && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
            count++;
        }
        return count;
    }
}
