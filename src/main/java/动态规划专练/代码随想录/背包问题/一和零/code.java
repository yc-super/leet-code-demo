package 动态规划专练.代码随想录.背包问题.一和零;
/*
* ["10", "0001", "111001", "1", "0"], m = 5, n = 3
* array0=[1,3,2,0,1]
* array1=[1,1,4,1,0]
*
* 1. 定义dp数组及下标含义：dp[i][j],表示最多有i个0和j个1的strs的最大子集的大小为dp[i][j]
* 直接定义要求的结果我是没想到的。
* 2.递推公式
* dp[i][j]=Max(dp[i][j],dp[i-zeroNum][j-oneNum])
* */
public class code {
    public static void main(String[] args) {
        String[] strs={"10", "0001", "111001", "1", "0"};
        int m=5,n=3;
        int maxForm = new code().findMaxForm(strs, m, n);
        System.out.println(maxForm);
    }
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp=new int[m+1][n+1];
        int zeroNum=0;
        int oneNum=0;
        for(String s:strs){
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='0') {
                    zeroNum++;
                }else{
                    oneNum++;
                }
            }
            for (int i = m; i>= zeroNum; i--) {
                for (int j = n; j >=oneNum ; j--) {
                    dp[i][j]=Math.max(dp[i][j],dp[i-zeroNum][j-oneNum]+1);
                }
            }
        }

        return dp[m][n];
    }
}
