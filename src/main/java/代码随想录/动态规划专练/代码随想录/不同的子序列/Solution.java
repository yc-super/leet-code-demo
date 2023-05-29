package 代码随想录.动态规划专练.代码随想录.不同的子序列;

public class Solution {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
//        String s = "rabbdbitbb", t = "rabdit";
        System.out.println(new Solution().numDistinct(s, t));
    }

    //想了半天没想出来。卡在了递推公式
    public int numDistinct(String s, String t) {
        int len1=s.length();
        int len2=t.length();
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 0; i <=len2; i++) {
            dp[0][i]=0;
        }
        for (int i = 0; i <= len1; i++) {
            dp[i][0]=1;
        }
        for (int i = 1; i <=len1; i++) {
            for (int j = 1; j <=len2; j++) {
                if(s.charAt(i-1)==t.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];//求的是s中有多少个t，所以只能”删除”s中的元素
                }
            }
        }
        return dp[len1][len2];
    }
}
