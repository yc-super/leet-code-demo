package 宫水三叶.DFS.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        Arrays.sort(candidates);
        myDFS(candidates, 0, 0, target, new ArrayList<>());
        return ans;
    }

    private void myDFS(int[] candidates, int start, int total, int target, List<Integer> list) {
        if (total == target) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (start == candidates.length)
            return;

        for (int i = start; i < candidates.length; i++) {
            if (i > start && candidates[i] == candidates[i - 1])
                continue;
            total += candidates[i];
            if (total > target) {
                break;
            }
            list.add(candidates[i]);
            myDFS(candidates, i + 1, total, target, list);
            list.remove(list.size() - 1);
            total -= candidates[i];
        }
    }
}
