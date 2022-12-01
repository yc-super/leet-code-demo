package LeetCode_Hot100.多数元素;

import java.util.Arrays;

public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
