package 代码随想录.回溯法专练.全排列II;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        List<List<Integer>> permute = new Solution2().permuteUnique(new int[]{1, 2, 1});
        System.out.println();
    }

    private List<List<Integer>> result;

    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        boolean[] isRead = new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums, isRead, new LinkedList<>());
        return result;
    }

    private void backTrack(int[] nums, boolean[] isRead, LinkedList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

//        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (isRead[i])
                continue;

            //去重方法1，利用set
//            if (set.contains(nums[i]))
//                continue;
//            set.add(nums[i]);

            //去重方法2，需要提前排序，关键点：isRead[i - 1] == false
            if (i > 0 && nums[i] == nums[i - 1] && isRead[i - 1] == false) {
                continue;
            }

            isRead[i] = true;
            list.add(nums[i]);
            backTrack(nums, isRead, list);
            isRead[i] = false;
            list.removeLast();
        }
    }
}
