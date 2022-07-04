package 代码随想录.回溯法专练.组合;

import java.util.ArrayList;
import java.util.List;

public class Mycode {
    public static void main(String[] args) {
        int n=4;
        int k=3;
        List<List<Integer>> list=new Mycode().combain(n,k);
        System.out.println(list);
    }

    List<List<Integer>> res;
    private List<List<Integer>> combain(int n, int k) {
        res=new ArrayList<>();
        backTrack(n,k,0,new ArrayList<Integer>());
        return res;
    }

    private void backTrack(int n, int k,int i,List<Integer> list) {
        if(list.size()==k){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i; j <n-(k-list.size())+1; j++) {
            if(i==1){
                System.out.println(i);
            }
            /*
            * 关于j <n-(k-list.size())+1;剪枝操作
            * 为了限制开始的位置
            * 实际上j<n-k+1就可以实现限制开始的位置，不满足这个条件的开头都是无意义的，因为后面的个数已经不够k个了
            * 但j<n-k+1会导致后面的数不能选到，是错误的
            * 那么就要求，既能限制开始的位置，又能灵活地增大结束的位置
            * */
            list.add(j+1);
            backTrack(n,k,j+1,list);
            list.remove(list.size()-1);
        }
    }
}
