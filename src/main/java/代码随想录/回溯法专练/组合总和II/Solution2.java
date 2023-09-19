package 代码随想录.回溯法专练.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(new Solution2().combinationSum2(candidates, target));
    }

    List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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

//        if (start > 0 && candidates[start] == candidates[start - 1])
//            return;

        for (int i = start; i < candidates.length && target - candidates[i] >= 0; i++) {
            if(i>start&&candidates[i]==candidates[i-1])
                continue;
            list.add(candidates[i]);
            backTrack(candidates, target - candidates[i], i + 1, list);
            list.remove(list.size() - 1);
        }
    }
}
