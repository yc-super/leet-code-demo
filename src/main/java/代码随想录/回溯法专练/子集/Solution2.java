package 代码随想录.回溯法专练.子集;

import LeetCode.检查骑士巡视方案.Solution;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution2().subsets(new int[]{1, 2, 3});
        System.out.println();
    }
    List<List<Integer>> result;

    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        backTrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int start, List<Integer> list) {
        result.add(new ArrayList<>(list));


        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
