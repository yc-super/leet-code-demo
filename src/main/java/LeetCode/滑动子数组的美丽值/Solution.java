package LeetCode.滑动子数组的美丽值;
// 看了灵神的题解才做出来的：
// https://leetcode.cn/problems/sliding-subarray-beauty/solutions/2241294/hua-dong-chuang-kou-bao-li-mei-ju-by-end-9mvl/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -1, -3, -2, 3};
        int k = 3, x = 2;
        System.out.println(new Solution().getSubarrayBeauty(nums, k, x));
    }

    // 本题元素的最大值和最小值之间就101，并且都是整数，可以考虑计数排序
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        final int BIAS = 50;
        int[] cnt = new int[BIAS * 2 + 1];
        // 先把k-1个元素放入cnt
        for (int i = 0; i < k - 1; i++) {
            cnt[nums[i] + BIAS]++;
        }
        // 定义返回结果数组
        int[] result = new int[nums.length - k + 1];
        // 开始滑动窗口
        for (int i = k - 1; i < nums.length; i++) {
            cnt[nums[i] + BIAS]++;
            // 从cnt中获取第x小的数
            int left = x;
            for (int j = 0; j < BIAS; j++) {
                left -= cnt[j];
                if (left <= 0) {//找到美丽值
                    result[i - k + 1] = j - BIAS;
                    break;
                }
            }
            cnt[nums[i - k + 1] + BIAS]--;
        }
        return result;
    }
}
