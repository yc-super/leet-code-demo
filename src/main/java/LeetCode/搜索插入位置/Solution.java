package LeetCode.搜索插入位置;

public class Solution {
    public static void main(String[] args) {
        int[] nums={1,3};
        int target=4;
        System.out.println(new Solution().searchInsert(nums,target));
    }
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        int middle = 0;
        while (l <= r) {
            middle = (l + r) / 2;
            if (nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                l = middle + 1;
            } else {
                r = middle - 1;
            }
        }
        return l;
    }
}
