package LeetCode.最接近的三数之和;

import java.util.Arrays;

public class Solution {
    public int threeSumClosest(int[] nums,int target){
        int len=nums.length;
        int l,r;
        int result=nums[0]+nums[1]+nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < len-2; i++) {
            l=i+1;
            r=len-1;
            while(l<r){
                int temp=nums[i]+nums[l]+nums[r];
                if(Math.abs(temp-target)<Math.abs(result-target))
                    result=temp;
                if(temp>target){
                    r--;
                }else if(temp<target){
                    l++;
                }else{
                    return target;
                }
            }
        }

        return result;
    }
}
