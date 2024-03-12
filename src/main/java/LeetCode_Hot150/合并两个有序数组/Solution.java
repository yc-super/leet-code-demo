package LeetCode_Hot150.合并两个有序数组;

public class Solution {
    public static void main(String[] args) {
        int[] nums1={1,2,3,0,0,0};
        int[] nums2={-1,5,6};
        int m=3;
        int n=3;
        new Solution().merge(nums1,m,nums2,n);
        System.out.println();
    }

    //后序双指针，很简单
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int index = nums1.length - 1;
        int index1 = m - 1;
        int index2 = n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] >= nums2[index2]) {
                nums1[index] = nums1[index1];
                index1--;
            } else {
                nums1[index] = nums2[index2];
                index2--;
            }
            index--;
        }
        while (index2 >= 0) {
            nums1[index--]=nums2[index2--];
        }
        return;
    }
}
