package 代码随想录.回溯法专练.全排列;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution2().permute(new int[]{1, 2, 3});
        System.out.println();
    }
    private List<List<Integer>> result;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        boolean[] isRead = new boolean[nums.length];
        backTrack(nums, isRead, new LinkedList<>());
        return result;
    }

    private void backTrack(int[] nums, boolean[] isRead, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (isRead[i])
                continue;
            isRead[i] = true;
            list.add(nums[i]);
            backTrack(nums, isRead, list);
            isRead[i] = false;
            list.removeLast();
        }
    }
}
