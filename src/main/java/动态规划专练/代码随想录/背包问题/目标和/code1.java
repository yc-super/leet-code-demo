package 动态规划专练.代码随想录.背包问题.目标和;
/*
* 回溯法-官方答案
* 我本来也想的是回溯法，但是想的不够全面，而这个代码就完全模拟了题目的要求
* */
public class code1 {
    public static void main(String[] args) {
        //        int[] nums = {1,1,1,1,1};
//        int[] nums = {1,2,3};
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int target = 0;
        int result = new code1().findTargetSumWays(nums, target);
        System.out.println(result);
    }
    int count = 0;

    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums, target, 0, 0);
        return count;
    }

    public void backtrack(int[] nums, int target, int index, int sum) {
        if (index == nums.length) {
            if (sum == target) {
                count++;
            }
        } else {
            backtrack(nums, target, index + 1, sum + nums[index]);
            backtrack(nums, target, index + 1, sum - nums[index]);
        }
    }
}
