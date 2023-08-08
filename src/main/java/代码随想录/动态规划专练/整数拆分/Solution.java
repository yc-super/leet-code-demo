package 代码随想录.动态规划专练.整数拆分;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(8));
    }
    public int integerBreak(int n) {
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        for (int i = 3; i <=n; i++) {
            for (int j = 1; j <=i/2 ; j++) {
                int temp=Math.max(dp[j],j)*Math.max(dp[i-j],i-j);
                dp[i]=Math.max(dp[i],temp);
            }
        }
        return dp[n];
    }
}
