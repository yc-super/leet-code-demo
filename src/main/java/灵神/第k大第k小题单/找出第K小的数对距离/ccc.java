package 灵神.第k大第k小题单.找出第K小的数对距离;

import java.util.Arrays;

public class ccc {

    public static void main(String[] args) {
        int[] nums = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        int k = 18;
        System.out.println(new ccc().smallestDistancePair2(nums, k));
    }


    // 题解2，排序+二分+双指针
    public int smallestDistancePair2(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int middle = (left + right) >> 1;
            int cnt = 0;

            int j = 0;
            for (int i = 0; i < n; i++) {
                while (nums[i] - nums[j] > middle) {
                    j++;
                }
                cnt += i - j;
            }

//            for (int i = 0; i < n; i++) {
//                int j = myBinarySearch(nums, i, nums[i] - middle);
//                cnt += i - j;
//            }
            if (cnt >= k) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }


    // 题解1，排序+二分+二分
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int middle = (left + right) >> 1;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int j = myBinarySearch(nums, i, nums[i] - middle);
                cnt += i - j;
            }
            if (cnt >= k) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    private int myBinarySearch(int[] nums, int right, int target) {
        int left = 0;
        while (left < right) {
            int middle = (left + right) >> 1;
            if (target > nums[middle]) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
