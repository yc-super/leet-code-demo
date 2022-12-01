package LeetCode_Hot100.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println(new Solution().findDisappearedNumbers(nums));
    }

    //鸽笼原理，利用原有数组，真的很巧妙啊（看的官方答案）
    //自己写的：
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] % n != 0) {
                nums[nums[i] % n - 1] += n;
            } else {
                nums[n - 1] += n;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }

    //官方答案（比我的优化了下）
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] <= n) {
                result.add(i + 1);
            }
        }
        return result;
    }
}
