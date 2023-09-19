package LeetCode.打家劫舍IV;

public class Solution2 {
    public static void main(String[] args) {
        int[] nums = {2, 3,5,9};
        int k = 2;
        System.out.println(new Solution2().minCapability(nums, k));
    }

    public int minCapability(int[] nums, int k) {
        int left = 0, right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, k, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }

    private boolean check(int[] nums, int k, int mid) {
        int f1 = 0, f2 = 0;
        for (int x : nums) {
            if (x > mid) {
                f1 = f2;
            } else {
                int temp = f2;
                f2 = Math.max(f2, f1 + 1);
                f1 = temp;
            }
        }
        return f2 >= k;
    }
}
