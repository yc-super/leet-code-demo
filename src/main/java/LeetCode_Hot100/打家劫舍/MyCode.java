package LeetCode_Hot100.打家劫舍;

/*
* 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，
* 系统会自动报警。

给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/house-robber
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*
*
* 输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
    偷窃到的最高金额 = 1 + 3 = 4 。
*
*
* 输入：[2,7,9,3,1]，   [2,7,1,1,9,1]->7+9=16，说明不一定是间隔的
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
    偷窃到的最高金额 = 2 + 9 + 1 = 12 。
* 
* 1 <= nums.length <= 100
0 <= nums[i] <= 400
* */


//这样的题目一看就是动态规划
//dp[i]=max(dp[i-1],dp[i-2]+nums[i]),dp[i]代表以i节点结尾最大是多少
//所以，最后要再遍历一遍，答案并不是dp[len-1],比如100,1,1,1，那么答案是dp[2]
public class MyCode {
    public static void main(String[] args) {
//        int[] nums={2,7,1,1,9,1};
//        int[] nums={2,7,9,3,1};
//        int[] nums={1,2,3,1};
        int[] nums={2,1,1,2};
//        int[] nums={10,20,1,1,1,20};
        int rob = rob(nums);
        System.out.println(rob);
    }
    public static int rob(int[] nums) {
        int len=nums.length;
        if(len==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        int[] dp=new int[len];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i]=Math.max(dp[i-2]+nums[i],dp[i-1]);
        }
        return dp[len-1];
    }
    public static int rob2(int[] nums) {
        int len=nums.length;
        if(nums.length==1)
            return nums[0];
        if(len==2)
            return Math.max(nums[0],nums[1]);
        int[] dp=new int[len];
        int[] dp2=new int[len];
        dp[0]=nums[0];
        dp[1]=nums[1];
        dp2[0]=nums[0];
        dp2[1]=Math.max(nums[0],nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i]=Math.max(dp[i-1],dp2[i-2]+nums[i]);
            dp2[i-1]=Math.max(dp[i-1],dp2[i-2]);
        }
        int max=dp[0];
        for (int i = 1; i < len; i++) {
            if(dp[i]>max)
                max=dp[i];
        }
        return max;
    }
}
