package 代码随想录.动态规划专练.代码随想录.背包问题.背包问题01.目标和;

/*
* 这道题和前面两道题不一样，这道题是求方法种数，
* 要记住的递推公式是：dp[j]+=dp[j-nums[i]]
*
* 不过 官方答案，动态规划二维数组 中，if(j>=nums[i-1])这个条件还是理解不了，为什么要用j和nums[i-1]相比？
*
* * */
public class code2 {
    public static void main(String[] args) {
                int[] nums = {1,1,1,1,1};
//        int[] nums = {1,2,3};
//        int[] nums = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        int target = 0;
        int target = 3;
        int result = new code2().findTargetSumWays1(nums, target);
        System.out.println(result);
    }

    //官方答案，动态规划二维数组
    public int findTargetSumWays1(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int diff=sum-target;
        if(diff%2==1||diff<0)
            return 0;
        int neg=diff/2;
        int n=nums.length;
        int[][] dp=new int[n+1][neg+1];
        dp[0][0]=1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                dp[i][j]=dp[i-1][j];
                if(j>=nums[i-1])
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
            }
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= neg; j++) {
                System.out.print(dp[i][j]+",");
            }
            System.out.println();
        }
        return dp[n][neg];
    }

    //官方答案，动态规划滚动数组
    public int findTargetSumWays2(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        int diff=sum-target;
        if(diff%2==1||diff<0)
            return 0;
        int neg=diff/2;
        int[] dp=new int[neg+1];
        dp[0]=1;
        for(int num:nums){
            for (int j = neg; j >=num ; j--) {
                dp[j]+=dp[j-num];
            }
        }
        return dp[neg];
    }


    //代码随想录，动态规划滚动数组
    public int findTargetSumWays3(int[] nums, int target) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++)
            sum += nums[i];
        if ((target + sum) % 2 != 0)
            return 0;
        int size = (target + sum) / 2;
        if (size < 0)
            size = -size;
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[size];
    }
}
