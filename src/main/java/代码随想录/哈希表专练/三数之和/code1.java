package 代码随想录.哈希表专练.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class code1 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(new code1().threeSum(nums));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0)
                return result;
            if (i != 0 && nums[i - 1] == nums[i]) {
                continue;
            }
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int temp = nums[left] + nums[right] + nums[i];
                if (temp == 0) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (temp < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
