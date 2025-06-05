package 灵神.第k大第k小题单.找出第K小的数对距离;

import java.util.Arrays;

public class reviewCode {
    public static void main(String[] args) {
        int[] nums = {9, 10, 7, 10, 6, 1, 5, 4, 9, 8};
        int k = 18;
        System.out.println(new reviewCode().smallestDistancePair(nums, k));
    }

    // 复习，二分+二分
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int left = 0, right = nums[n - 1] - nums[0];
        while (left < right) {
            int mid = right + left >> 1;
            // 距离为mid的有多少个
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                int index = getIndex(i, nums, nums[i] - mid);
                cnt += i - index;
            }
            if (k > cnt) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int getIndex(int right, int[] nums, int target) {
        int left = 0;
        while (left < right) {
            int mid = left + right >> 1;
            if (target > nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
