package LeetCode.统计异或值在范围内的数对有多少;

public class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,3};
        System.out.println(new Solution().countPairs(nums,0,1));
    }
    public int countPairs(int[] nums, int low, int high) {
        if(nums.length==1)
            return 0;
        int count=0;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                if(((nums[i]^nums[j])>=low)&&((nums[i]^nums[j])<=high)){
                    count++;
                }
            }
        }
        return count;
    }
}
