package LeetCode.回溯法专练.递增子序列;

import java.util.ArrayList;
import java.util.List;

class code {
    public static void main(String[] args) {
//        int[] nums={4,6,7,7};
//        int[] nums={4,4,1,1,2};
//        int[] nums={1,3,2,2};
//        int[] nums={1,2,3,1,1,1,1};
//        int[] nums={1,2,3,1,1,1,1,2,2};
        int[] nums={-100,0,0,0,0,100,100,0,0};
        //[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        List<List<Integer>> subsequences = new code().findSubsequences(nums);
        for (List<Integer> list:
                subsequences) {
            System.out.println(list);
        }
    }
    private List<Integer> path = new ArrayList<>();
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums,0);
        return res;
    }

    private void backtracking (int[] nums, int start) {
        if (path.size() > 1) {
            res.add(new ArrayList<>(path));
        }

        int[] used = new int[201];
        for (int i = start; i < nums.length; i++) {
            if (!path.isEmpty() && nums[i] < path.get(path.size() - 1) ||
                    (used[nums[i] + 100] == 1)) continue;
            used[nums[i] + 100] = 1;
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
