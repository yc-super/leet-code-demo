package 动态规划专练.不同的二叉搜索树;
/*
* n=3,输出5
* 1.确定dp数组及下标的含义
*   dp[i]:表示n为i时组合的数量
* 2.确定递推公式
* dp[i]+=dp[i-j]*dp[j-1]
* 3.初始化dp数组
* dp[0]=1
* 4.确定顺序
* 从前往后
* 5.举例验证
*dp[1]=dp[0]*dp[0]=1√
* dp[2]=dp[1]*dp[0]+dp[0]*dp[1]=2
* dp[3]=dp[2]*dp[0]+dp[1]*dp[1]+dp[0]*dp[2]=5
*
* */
/*
* 总结：写这道题我一开始从1到4画了对应的树，尝试找规律，毕竟之前做动态规划的题目给了我经验：找规律。
* 但是这次很困难，找不出来正确的规律，很大的原因是我没有考虑到这是个二叉搜索树。
* 看来还要多了解数据结构
* */
public class Code {
    public static void main(String[] args) {
        int n=4;
        int result = numTrees(n);
        System.out.println(result);
    }
    public static int numTrees(int n) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <=i ; j++) {
                dp[i]+=dp[i-j]*dp[j-1];
            }
        }
        return dp[n];
    }
}
