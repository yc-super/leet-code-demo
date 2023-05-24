package 代码随想录.动态规划专练.代码随想录.最长连续递增序列;

public class Solution {
    public static void main(String[] args) {
        int[] nums={1,3,5,7};
        System.out.println(new Solution().findLengthOfLCIS(nums));
    }

    //贪心，O(n),O(1)。本题也可用动态规划，主要是用来和 最长递增子序列 一块思考，更好理解dp数组的含义，O(n),O(n)
    public int findLengthOfLCIS(int[] nums) {
        int pre = -10 ^ 9 - 1, max = 0, result = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > pre) {
                max++;
            } else {
                result = Math.max(result, max);
                max = 1;
            }
            pre = nums[i];
        }
        result=Math.max(result,max);
        return result;
    }
}
