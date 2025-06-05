package 网易题目.合唱团;
/*
* 有 n 个学生站成一排，每个学生有一个能力值，牛牛想从这 n 个学生中按照顺序选取 k 名学生，
* 要求相邻两个学生的位置编号的差不超过 d，使得这 k 个学生的能力值的乘积最大，你能返回最大的乘积吗？
* 设计一个java方法，参数有int n、int[] a、int k、int d，其中a代表各个学生的能力值，下标为学生编号，方法返回值是 k 个学生的能力值的乘积
* */
public class Solution {
    // 2,5,1,8,4,9,5,7,1
    public int getBestTeams(int n, int a[], int kk, int d) {
       /*  dp[i][j]:i下标结尾的元素，最大的j个乘积
       dp[i][j]=max(dp[i-1][j-1],dp[i-2][j-1],dp[i-3][j-1]。。。dp[i-d][j-1])*a[i]
       dp[0][0]=1
       dp[0][1]=a[0]
        */
        int[][] dp = new int[n][kk];
        for (int j = 0; j < kk; j++) {
            dp[0][j] = a[0];
        }
        int result = dp[0][kk - 1];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < kk; j++) {
                int max = Integer.MIN_VALUE;
                for (int k = i; k >= 0 && k >= i - d; k++) {
                    max = Math.max(max, dp[i][j - 1]);
                }
                dp[i][j] = a[i] * max;
            }
            result = Math.max(dp[i][kk - 1], result);
        }
        return result;
    }
}
