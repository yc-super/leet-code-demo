package LeetCode.回溯法专练.组合总和II;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        //1,1,2,5,6,7,10
        int target = 8;
        /*
        * [
            [1,1,6],
            [1,2,5],
            [1,7],
            [2,6]
           ]
        * */
        List<List<Integer>> result=new MyCode().combinationSum2(candidates,target);
        for (List<Integer> l : result) {
            System.out.println(l);
        }
    }

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0,candidates,target,new ArrayList<>(),0);
        return res;
    }
    private void backTrack(int start,int[] candidates, int target,List<Integer> list,int sum){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < candidates.length&&sum+candidates[i]<=target; i++) {
            if(i>start&&candidates[i]==candidates[i-1]){
                continue;
            }
            list.add(candidates[i]);
            sum+=candidates[i];
            backTrack(i+1,candidates,target,list,sum);
            list.remove(list.size()-1);
            sum-=candidates[i];
        }
    }
}
