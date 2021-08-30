package LeetCode.回溯法专练.分割回文串;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class copy2 {
    public static void main(String[] args) {
        String ss="abcc";
        List<List<String>> list=new copy2().partition(ss);
        System.out.println(list);
    }

    List<List<String>> res;
    private List<List<String>> partition(String ss) {
        res=new ArrayList<>();
        operate(ss,0,new ArrayList<String>());
        return res;
    }

    private void operate(String ss,int i,List<String> list) {
        if(i==ss.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int j = i+1; j <= ss.length(); j++) {
            String str=ss.substring(i,j);
            if(huiwen(str)){
                list.add(str);
                operate(ss,j,list);
                list.remove(list.size()-1);
            }

        }
    }

    private boolean huiwen(String str) {
        int right=str.length()-1;
        int left=0;
        while(left<right){
            if(str.charAt(left)!=str.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }


}
