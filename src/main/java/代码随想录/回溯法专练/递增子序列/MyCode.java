package 代码随想录.回溯法专练.递增子序列;

import java.util.ArrayList;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
//        int[] nums={4,6,7,7};
//        int[] nums={4,4,1,1,2};
//        int[] nums={1,3,2,2};
//        int[] nums={1,2,3,1,1,1,1};
//        int[] nums={1,2,3,1,1,1,1,2,2};
        int[] nums={-100,-100,0,0,0,100,100,0,0};
        //[[4,6],[4,6,7],[4,6,7,7],[4,7],[4,7,7],[6,7],[6,7,7],[7,7]]
        List<List<Integer>> subsequences = new MyCode().findSubsequences(nums);
        for (List<Integer> list:
        subsequences) {
            System.out.println(list);
        }
    }
    List<List<Integer>> res;
    public List<List<Integer>> findSubsequences(int[] nums) {
        res=new ArrayList<>();
        backTrack(nums,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int[] nums, int start, ArrayList<Integer> list) {
        if(list.size()>=2){
            res.add(new ArrayList<>(list));
        }
        int[] vis=new int[201];
        for (int i = start; i < nums.length; i++) {
            if(list.size()>=1&&nums[i]<list.get(list.size()-1)||(vis[nums[i]+100]==1)) {
                continue;
            }
            /*if(i>start&&nums[i]==nums[i-1]) {
                continue;
            }*/
            vis[nums[i]+100]=1;
            list.add(nums[i]);
            backTrack(nums,i+1,list);
            list.remove(list.size() - 1);
        }
    }
}
