package 代码随想录.动态规划专练.编辑距离;

public class Solution {
    public static void main(String[] args) {
//        String word1 = "horse", word2 = "ros";//3
//        String word1 = "horse", word2 = "rse";//2
        String word1 = "intention", word2 = "execution";//5
        System.out.println(new Solution().minDistance(word1,word2));
    }

    //没想出来。word1.charAt(i-1)==word2.charAt(j-1)时我知道 dp[i][j]=dp[i-1][j-1];
    // 但一直在纠结增加怎么处理，会不会影响后面的，看了代码随想录才知道，增加相当于删除，是一样的
    //至于修改，dp[i][j]=dp[i-1][j-1]+1;
    //删除和以前一样，Math.min(dp[i-1][j],dp[i][j-1])+1;
    //最后取这3者最小值就行了
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
                    int a=Math.min(dp[i-1][j],dp[i][j-1])+1;//删除
                    int b=dp[i-1][j-1]+1;//修改
                    dp[i][j]=Math.min(a,b);
                }
            }
        }
        return dp[len1][len2];
    }
}
