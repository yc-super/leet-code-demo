package LeetCode_Hot100.单词拆分;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        System.out.println(new Solution().wordBreak2(s, wordDict));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        //除了dp[0],初始化为false
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //优化点：如果内循环中j-i的长度大于wordDict中最长的，直接break，确定dp[i]=false;
    //注意，如果想采用上面的方案，内循环就要倒序遍历！！
    public boolean wordBreak2(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 1];
        //除了dp[0],初始化为false
        dp[0] = true;
        int max = 0;
        for (int i = 0; i < wordDict.size(); i++) {
            set.add(wordDict.get(i));
            max = Math.max(max, wordDict.get(i).length());
        }
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0 && i-j <= max; j--) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
