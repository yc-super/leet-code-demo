package LeetCode.删除有序数组中的重复项;

public class Solution {
    public int removeDuplicates(int[] nums){
        int l=1,r=1;
        int pre=nums[0];
        while(r!=nums.length){
            if(nums[r]!=pre){
                nums[l]=nums[r];
                l++;
                pre=nums[r];
            }
            r++;
        }
        return l;
    }
}
