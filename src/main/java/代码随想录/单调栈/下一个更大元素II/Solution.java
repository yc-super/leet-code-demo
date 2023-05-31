package 代码随想录.单调栈.下一个更大元素II;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 1};//2,-1,2
        int[] nums = {1, 2};//-1,3,3
        System.out.println(new Solution().nextGreaterElements(nums));
    }

    public int[] nextGreaterElements(int[] nums) {
        int len = nums.length;
        int[] result = new int[len];
        Arrays.fill(result, -1);
        Deque<Integer> deque = new LinkedList<>();
        deque.push(0);
        for (int i = 1; i < len; i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                result[deque.poll()] = nums[i];
            }
            deque.push(i);
        }
        for (int i = 0; i < len && !deque.isEmpty(); i++) {
            while (!deque.isEmpty() && nums[i] > nums[deque.peek()]) {
                result[deque.poll()] = nums[i];
            }
        }
        return result;
    }
}
