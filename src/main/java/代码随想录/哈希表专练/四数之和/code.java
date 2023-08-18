package 代码随想录.哈希表专练.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code {
    public static void main(String[] args) {
        System.out.println(new code().fourSum(new int[]{1000000000,1000000000,1000000000,1000000000},-294967296));

    }
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        int len = nums.length;
        Arrays.sort(nums);
        Long temp;
        for (int i = 0; i < len - 3; i++) {
            long a=nums[i];
            if (nums[i] > target && nums[i] > 0)
                break;
            //去重
            if (i != 0 && nums[i] == nums[i - 1])
                continue;

            //优化1
            if(a+nums[i+1]+nums[i+2]+nums[i+3]>target)
                break;

            //优化2
            if(a+nums[len-1]+nums[len-2]+nums[len-3]<target)
                continue;

            for (int j = i + 1; j < len - 2; j++) {
                long b=nums[j];

                //去重
                if (j != i + 1 && nums[j] == nums[j - 1])
                    continue;

                //优化1
                if(a+b+nums[j+1]+nums[j+2]>target)
                    break;

                //优化2
                if(a+b+nums[len-1]+nums[len-2]<target)
                    continue;

                int left = j + 1, right = len - 1;
                while (left < right) {
                    temp = Long.valueOf(nums[i]) + Long.valueOf(nums[j]) + Long.valueOf(nums[left]) + Long.valueOf(nums[right]);
                    if (temp == target) {
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if (temp < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
