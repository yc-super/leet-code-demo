package LeetCode.从两个数字数组里生成最小数字;

public class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] hash = new int[9];
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        int min3 = Integer.MAX_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            hash[nums1[i] - 1] = 1;
            min1 = Math.min(min1, nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (hash[nums2[i] - 1] == 1) {
                min3 = Math.min(min3, nums2[i]);
            }
            min2 = Math.min(min2, nums2[i]);
        }
        if (min3 != Integer.MAX_VALUE) {
            return min3;
        }
        if (min1 < min2) {
            return min1 * 10 + min2;
        }
        return min2 * 10 + min1;
    }
}
