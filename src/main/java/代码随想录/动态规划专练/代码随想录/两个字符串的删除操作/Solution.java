package 代码随想录.动态规划专练.代码随想录.两个字符串的删除操作;

public class Solution {
    public static void main(String[] args) {
//        String word1 = "sea", word2 = "eat";//2
        String word1 = "leetcode", word2 = "leetcod";//4
        // abcde      abcfg
        System.out.println(new Solution().minDistance(word1,word2));
    }
    public int minDistance(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 0; i <=len2; i++) {
            dp[0][i]=i;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0]=i;
        }
        for (int i = 1; i <=len1; i++) {
            for (int j = 1; j <=len2; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1])+1,dp[i-1][j-1]+2);
                    //可以简化为这个
//                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+1;
                }
            }
        }
        return dp[len1][len2];
    }

    //动态规划思路2：求最少删除的个数，实际就是 先求最长公共子序列，然后len1+len2-最长公共子序列长度*2
    public int minDistance2(String word1, String word2) {
        int len1=word1.length();
        int len2=word2.length();
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 1; i <=len1; i++) {
            for (int j = 1; j <=len2; j++) {
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return len1+len2-dp[len1][len2]*2;
    }
}
