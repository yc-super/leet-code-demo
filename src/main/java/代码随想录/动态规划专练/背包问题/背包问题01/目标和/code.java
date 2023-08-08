package 代码随想录.动态规划专练.背包问题.背包问题01.目标和;

/*
* 把数组分成两部分，一部分的是a1,一部分的和是a2
* a1-a2=target
* a1+a2=sum
* 2a1=target+sum
* a1=(target+sum)/2
* 实际上就是求：从nums数组中，有多少种 取若干元素，使其和等于a1  的组合
* 最先想到的是回溯法
* 但是我老是按照回溯法的模板来，没有完全把题目要求模拟进去。
* 正确的回溯法代码见code1
*
* */
public class code {
    public static void main(String[] args) {
//        int[] nums = {1,1,1,1,1};
//        int[] nums = {1,2,3};
        int[] nums = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
        int target = 0;
        int result = new code().findTargetSumWays(nums, target);
        System.out.println(result);
    }
    int ways=0;
    public int findTargetSumWays(int[] nums, int target) {
        int sum=0;
        for(int num:nums){
            sum+=num;
        }
        if((sum+target)%2!=0)
            return 0;
        int tar=(sum+target)/2;
        backTrack(nums,tar,0,0);
        return ways;
    }

    private void backTrack(int[] nums, int tar, int start,int sum) {
        for (int i = start; i < nums.length; i++) {
            sum+=nums[i];
            if(sum==tar){
                ways++;
            }
            backTrack(nums,tar,i+1,sum);
            sum-=nums[i];
        }
    }
}
