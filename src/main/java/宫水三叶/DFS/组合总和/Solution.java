package 宫水三叶.DFS.组合总和;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) {
        List<List<Integer>> lists = new Solution().combinationSum(new int[]{2, 3, 6, 7}, 7);
        System.out.println();
    }

    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        myDFS(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void myDFS(int[] candidates, int target, int start, int total, List<Integer> list) {
        if (target == total) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if (target < total)
            return;

        for (int i = start; i < candidates.length; i++) {
            list.add(candidates[i]);
            total += candidates[i];

            myDFS(candidates, target, i, total, list);

            total -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
}
