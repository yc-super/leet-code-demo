package 代码随想录.回溯法专练.组合总和III;

import java.util.ArrayList;
import java.util.List;

//力扣216
public class MyCode {
    public static void main(String[] args) {
        int k=3;
        int n=9;
        /*
        * 1,2,3,4,5,6,7,8,9
        *
        * 找3个数使其和为7
        * 找k个数使其和为n
        * */
        List<List<Integer>> list=new MyCode().combinationSum3(k,n);
        System.out.println(list.size());
        System.out.println(list);
    }
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res=new ArrayList<>();
        backTrack(k,n,1,new ArrayList<Integer>(),0);
        return res;
    }

    private void backTrack(int k, int n, int start, ArrayList<Integer> list,int sum) {
        if(list.size()==k){
            if(sum==n){
                res.add(new ArrayList<>(list));
            }
            return;
        }
        for (int i = start; i <= 9-(k-list.size())+1; i++) {
            list.add(i);
            sum+=i;
            backTrack(k, n, i + 1, list,sum);
            list.remove(list.size() - 1);
            sum-=i;
        }
    }

    private int sumList(ArrayList<Integer> list) {
        int sum=0;
        for (int a : list) {
            sum+=a;
        }
        return sum;
    }
}
