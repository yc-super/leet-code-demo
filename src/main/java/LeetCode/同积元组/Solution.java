package LeetCode.同积元组;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums={1,2,3,4,5,6,10,12,36};
        System.out.println(new Solution().tupleSameProduct(nums));
    }
    public int tupleSameProduct(int[] nums) {
        int len = nums.length;
        if (len < 4)
            return 0;
        Arrays.sort(nums);
        int count = 0;
        for (int i = 0; i < len - 3; i++) {
            for (int j = i + 3; j < len; j++) {
                int temp = nums[i] * nums[j];
                int left = i + 1, right = j - 1;
                if (nums[left] * nums[left + 1] > temp)
                    continue;
                if (nums[right] * nums[right - 1] < temp)
                    continue;
                while (left < right) {
                    int ll = nums[left] * nums[right];
                    if (ll == temp) {
                        count++;
                        left++;
                        right--;
                    } else if (ll < temp) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return count * 8;
    }

    public int tupleSameProduct2(int[] nums) {
        if (nums.length < 4)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int key = nums[i] * nums[j];
                map.put(key, map.getOrDefault(key, 0)+1);
            }
        }
        int result = 0;
        for (Integer value : map.values()) {
            result += value * (value - 1) * 4;
        }
        return result;
    }
}
