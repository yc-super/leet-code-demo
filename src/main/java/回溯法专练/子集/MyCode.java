package 回溯法专练.子集;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        int[] nums = {1,2,3};//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
//        int[] nums = {-10};
        List<List<Integer>> result=new MyCode().subsets(nums);
        for (List<Integer> list :
                result) {
            System.out.println(list);
        }
    }
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res=new ArrayList<>();
        backTrack(nums,0,new ArrayList<Integer>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> list) {
        res.add(new ArrayList<>(list));
        for (int i = start; i < nums.length; i++) {
            list.add(nums[i]);
            backTrack(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }
}
