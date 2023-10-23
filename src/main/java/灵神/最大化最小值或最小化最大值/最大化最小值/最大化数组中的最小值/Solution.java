package 灵神.最大化最小值或最小化最大值.最大化最小值.最大化数组中的最小值;

public class Solution {
    public static void main(String[] args) {
//        int[] nums={8,0,16};
        int[] nums = {3, 7, 1, 6};
        System.out.println(new Solution().minimizeArrayValue(nums));
    }

    // 二分法
    public int minimizeArrayValue(int[] nums) {
        int left = nums[0], right = 0;
        for (int x : nums) {
            right = Math.max(right, x);
        }
        while (left < right) {
            int mid = (left + right) >>> 1;
            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
    private boolean check(int[] nums, int mid) {
        long sum = 0;
        for (int x : nums) {
            if (x < mid) {
                sum += mid - x;
            } else {
                sum -= x - mid;
                if (sum < 0) {
                    return false;
                }
            }
        }
        return true;
    }


    // 模拟
    public int minimizeArrayValue2(int[] nums) {
        long sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, (sum + i) / (i + 1));
        }
        return (int) max;
    }
}
