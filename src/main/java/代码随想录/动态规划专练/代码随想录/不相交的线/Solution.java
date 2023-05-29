package 代码随想录.动态规划专练.代码随想录.不相交的线;

public class Solution {
    public static void main(String[] args) {
//        int[] nums1 = {2, 5, 1, 2, 5};
//        int[] nums2 = {10, 5, 2, 1, 5, 2};
        int[] nums1 = {2, 3, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 1, 2, 0, 5, 2};
//        int[] nums1 = {1,3,7,1,7,5};
//        int[] nums2 = {1,9,2,5,1};//2

        System.out.println(new Solution().maxUncrossedLines(nums1,nums2));
    }

    //想了半天没思路，一直在想如何才能不相交。后面看了代码随想录才知道，这就和”最长公共子序列”一模一样的题目！
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int len1=nums1.length;
        int len2=nums2.length;
        int[][] dp=new int[len1+1][len2+1];
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[len1][len2];
    }
}
