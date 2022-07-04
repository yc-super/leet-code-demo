package 代码随想录.回溯法专练.全排列;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
//        int[] nums = {1,2,3};//[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = new MyCode().permute(nums);
        for (List<Integer> list :
                result) {
            System.out.println(list);
        }
    }
    List<List<Integer>> res;
    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        res=new ArrayList<>();
        vis=new boolean[nums.length];
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> list) {
        if(list.size()==nums.length){
            res.add(new ArrayList<>(list));
        }
        for (int i = 0; i < nums.length; i++) {
            if(vis[i])
                continue;
            list.add(nums[i]);
            vis[i]=true;
            backTrack(nums,i+1,list);
            list.remove(list.size()-1);
            vis[i]=false;
        }
    }
}
