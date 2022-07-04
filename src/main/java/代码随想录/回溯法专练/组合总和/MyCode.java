package 代码随想录.回溯法专练.组合总和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        int[] candidates={2,3,6,7};//[[7],[2,2,3]]
        int target=7;
        long l = System.currentTimeMillis();
        Arrays.sort(candidates);
        List<List<Integer>> list=new MyCode().combinationSum(candidates,target);
        System.out.println("所需时间："+(System.currentTimeMillis()-l));
        for (List<Integer> a :list) {
            System.out.println(a);
        }
    }

    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res=new ArrayList<>();
        Arrays.sort(candidates);
        backTrack(0,candidates,target,0,new ArrayList<>());
        return res;
    }

    private void backTrack(int start,int[] candidates, int target,int sum,List<Integer> list){
        if(sum==target){
            res.add(new ArrayList<>(list));
            return;
        }else {
            for (int i = start; i <candidates.length&&sum+candidates[i]<=target; i++) {
                sum += candidates[i];
                list.add(candidates[i]);
                backTrack(i, candidates, target, sum, list);
                sum -= candidates[i];
                list.remove(list.size() - 1);
            }
        }
    }
}
