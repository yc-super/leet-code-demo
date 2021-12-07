package LeetCode.最长递增子序列;

import java.util.ArrayList;
import java.util.List;

/*
* 明显是要用动态规划
* dp[i]:从0到i，最长递增子序列的长度
* 递推公式：
*
*
* */
public class code {
    public static void main(String[] args) {
//        int[] nums = {10,9,2,5,3,7,101,18};
//        int[] nums = {0,1,0,3,2,3};
        int[] nums = {7,7,7,7,7,7,7};
        System.out.println(new code().lengthOfLIS(nums));
    }
    //动态规划不太好想出来，先用暴力解法理清思路
    int max=1;
    public int lengthOfLIS(int[] nums) {
        List<Integer> list=new ArrayList<>();
        backTrack(0,nums,list);
        return max;
    }

    //0,1,0,3,2,311
    private void backTrack(int start, int[] nums, List<Integer> list) {
        max=Math.max(max,list.size());
        for (int i = start; i < nums.length; i++) {
            if(list.size()>0&&nums[i]<=list.get(list.size()-1)){
                continue;
            }
            list.add(nums[i]);
            backTrack(i+1,nums,list);
            list.remove(list.size()-1);
        }
    }
}
