package 代码随想录.回溯法专练.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        List<List<Integer>> subsets = new Solution2().subsetsWithDup(new int[]{1, 2, 2});
        System.out.println();
    }

    List<List<Integer>> result;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int start, List<Integer> list) {
        result.add(new ArrayList<>(list));


        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1])
                continue;
            list.add(nums[i]);
            backTrack(nums, i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
