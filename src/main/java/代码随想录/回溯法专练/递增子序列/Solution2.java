package 代码随想录.回溯法专练.递增子序列;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        List<List<Integer>> subsequences = new Solution2().findSubsequences(new int[]{1,2,3,1,1,1});
        for(List<Integer> list:subsequences){
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i));
            }
            System.out.println();
        }
        System.out.println();
    }

    List<List<Integer>> result;

    public List<List<Integer>> findSubsequences(int[] nums) {
        result = new ArrayList<>();
        if (nums.length < 2)
            return result;
        backTrack(nums, 0, Integer.MIN_VALUE, new ArrayList<>());
        return result;
    }

    private void backTrack(int[] nums, int start, int pre, List<Integer> list) {
        if (list.size() > 1) {
            result.add(new ArrayList<>(list));
        }

        Set<Integer> set=new HashSet<>();
        for (int i = start; i < nums.length; i++) {
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
//            if (i > start && nums[i] == nums[i - 1])
//                continue;
            if (nums[i] >= pre) {
                list.add(nums[i]);
                backTrack(nums, i + 1, nums[i], list);
                list.remove(list.size() - 1);
            }
        }
    }
}
