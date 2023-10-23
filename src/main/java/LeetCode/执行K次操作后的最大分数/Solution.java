package LeetCode.执行K次操作后的最大分数;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000};
        int k = 100;
        System.out.println(new Solution().maxKelements(nums, k));
    }

    // 自己写的，每次除以3后二分查找，超时了
    public long maxKelements(int[] nums, int k) {
        long result = 0;
        final int index = nums.length - 1;
        if (index == 0) {
            while (k != 0 && nums[0] != 0) {
                result += nums[0];
                nums[0] = getResult(nums[0]);
                k--;
            }
            return result;
        }
        Arrays.sort(nums);
        while (k != 0) {
            if (nums[index] == 1)
                break;
            result += nums[index];
            nums[index] = getResult(nums[index]);
            k--;
            if (nums[index] >= nums[index - 1]) {
                continue;
            } else {
                middleSort(nums, index);
            }
        }
        return result + k;
    }

    private int getResult(int num) {
        if (num % 3 == 0) {
            return num / 3;
        }
        return num / 3 + 1;
    }

    // 只对最后一个元素进行排序，二分查找
    private void middleSort(int[] nums, int index) {
        int left = 0, right = index - 1;
        int middle;
        while (left <= right) {
            middle = (left + right) / 2;
            if (nums[middle] == nums[index]) {
                break;
            } else if (nums[middle] < nums[index]) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        int tempIndex = left;
        int tempValue = nums[index];
        for (int i = index; i > tempIndex; i--) {
            nums[i] = nums[i - 1];
        }
        nums[tempIndex] = tempValue;
    }


    // 官方，Pro
    public long maxKelements2(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((o1, o2) -> o2-o1);
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        long result = 0;
        while (k != 0) {
            Integer temp = priorityQueue.poll();
            result += temp;
            priorityQueue.offer((temp + 2) / 3);
            k--;
        }
        return result;
    }
}
