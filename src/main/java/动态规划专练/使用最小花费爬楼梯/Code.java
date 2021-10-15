package 动态规划专练.使用最小花费爬楼梯;

//dp[i]:i代表第i步，dp[i]表示第i步加上之前的步数之和
//cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
// 输出：6 解释：最低花费方式是从 cost[0] 开始，逐个经过那些 1 ，跳过 cost[3] ，一共花费 6 。

/*
假设到了dp[i]，i之前都是最优选，那么i+1该怎么选：
* 要么走一步，要么走两步
*
*
* */
public class Code {
    public static void main(String[] args) {
        int[] cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost={10, 15, 20};
        int num=minCostClimbingStairs(cost);
        System.out.println(num);
    }
    public static int minCostClimbingStairs(int[] cost) {
        int[] dp=new int[cost.length];
        dp[0]=cost[0];
        dp[1]=cost[1];
        //dp[i]=min(dp[i-1],dp[i-2])+cost[i-1]
        for (int i = 2; i < cost.length; i++) {
            dp[i]=Math.min(dp[i-1],dp[i-2])+cost[i];
//            System.out.println("i:"+i+","+dp[i]);
        }
        return Math.min(dp[cost.length-1],dp[cost.length-2]);
    }
}
