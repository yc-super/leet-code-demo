package LeetCode_Hot100.移动零;

public class Solution {
    public void moveZeroes(int[] nums) {
        int slow=0;
        int fast=0;
        while(fast!=nums.length){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
            }
            fast++;
        }
        while(slow!=nums.length){
            nums[slow++]=0;
        }
    }
}
