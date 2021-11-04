package 回溯法专练.子集II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        int[] nums={1,2,2};//[[],[1],[1,2],[1,2,2],[2],[2,2]]
//        int[] nums={0};//[[],[0]
        List<List<Integer>> result = new MyCode().subsetsWithDup(nums);
        for (List<Integer> list :
                result) {
            System.out.println(list);
        }
    }
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res=new ArrayList<>();
        Arrays.sort(nums);
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            if(i>start&&nums[i]==nums[i-1])
                continue;
            list.add(nums[i]);
            backTrack(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
