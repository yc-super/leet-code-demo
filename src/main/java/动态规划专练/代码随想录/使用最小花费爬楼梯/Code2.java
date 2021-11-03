package 动态规划专练.代码随想录.使用最小花费爬楼梯;
//空间复杂度优化
public class Code2 {
    public static void main(String[] args) {
//        int[] cost={1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
//        int[] cost={10, 15, 20};
//        int[] cost={4,1};
        int[] cost={1,4};
        int num=minCostClimbingStairs(cost);
        System.out.println(num);
    }
    public static int minCostClimbingStairs(int[] cost) {
        if(cost.length==2)
            return Math.min(cost[0],cost[1]);

        int k=cost[0],j=cost[1],m=Integer.MAX_VALUE;
        for (int i = 2; i < cost.length; i++) {
            m=Math.min(k,j)+cost[i];
            k=j;
            j=m;
        }
        return Math.min(k,m);
    }
}
