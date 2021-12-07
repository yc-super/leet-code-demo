package LeetCode.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
* 思路：组合问题，用回溯法
* */
//回溯法写出来了，但是超时了
public class code {
    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> l=new code().threeSum(nums);
        for(List<Integer> list:l){
            System.out.println(list);
        }
    }

    List<List<Integer>> result=new ArrayList<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        //-4,-1,-1,0,1,2
        backTrack(0,nums,new ArrayList<>(),0);
        return result;
    }
    private void backTrack(int start,int[] nums,List list,int sum){
        if(list.size()==3){
            if(sum==0) {
                result.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i < nums.length&&sum+nums[i]<=0; i++) {
            if(i>start&&nums[i]==nums[i-1]){
                continue;
            }
            list.add(nums[i]);
            sum+=nums[i];
            backTrack(i+1,nums,list,sum);
            list.remove(list.size()-1);
            sum-=nums[i];
        }
    }
}
