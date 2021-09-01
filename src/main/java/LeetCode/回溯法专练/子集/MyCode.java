package LeetCode.回溯法专练.子集;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        int[] nums = {1,2,3};//[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
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
        res.add(new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> list) {
        if(list.size()==Math.pow(2,nums.length)){

            return;
        }
        for (int i = start; i < nums.length; i++) {
            for (int j = start; j <= i; j++) {
                list.add(nums[j]);
            }
            backTrack(nums,i+1,list);
            for (int j = start; j <= i; j++) {
                list.remove(nums[j]);
            }
        }
    }
}
