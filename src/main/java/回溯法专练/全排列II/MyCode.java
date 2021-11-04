package 回溯法专练.全排列II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
//        int[] nums = {1,1,2};//[[1,1,2], [1,2,1], [2,1,1]]
        int[] nums = {2,1,2,1};
//        int[] nums = {1,2,3};
        List<List<Integer>> result = new MyCode().permuteUnique(nums);
        for (List<Integer> list :
                result) {
            System.out.println(list);
        }
    }
    List<List<Integer>> res;
    boolean[] vis;
    public List<List<Integer>> permuteUnique(int[] nums) {
        res=new ArrayList<>();
        vis=new boolean[nums.length];
        Arrays.sort(nums);
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> list) {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i]||(i>0&&!vis[i-1]&&nums[i]==nums[i-1]))
                continue;
            list.add(nums[i]);
            vis[i]=true;
            backTrack(nums,i+1,list);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }
}
