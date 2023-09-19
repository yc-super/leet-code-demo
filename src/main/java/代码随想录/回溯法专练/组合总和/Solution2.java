package 代码随想录.回溯法专练.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Solution2().combinationSum(candidates, target));
    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(candidates, target, 0, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] candidates, int target, int start, List<Integer> list) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            list.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i, list);
            list.remove(list.size() - 1);
        }
    }
}
