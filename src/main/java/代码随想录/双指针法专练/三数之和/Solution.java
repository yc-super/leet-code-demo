package 代码随想录.双指针法专练.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    /*
    * 输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]\
*
* 排序后是 -4 -2 -1 -1 0 1 1 2
    * */
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new Solution().threeSum(nums));
    }

    //双指针法
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int sum;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0)
                return result;

            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int left = i + 1;
            int right = nums.length - 1;

            while (right > left) {
                sum = nums[i] + nums[left] + nums[right];
                if (sum < 0) {
                    do {
                        left++;
                    } while (right > left && left == left + 1);
                } else if (sum > 0) {
                    do {
                        right--;
                    } while (right > left && right == right - 1);
                } else {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (right > left && nums[right] == nums[right - 1])
                        right--;
                    while (right > left && nums[left] == nums[left + 1])
                        left++;

                    right--;
                    left++;
                }
            }
        }
        return result;
    }
}
