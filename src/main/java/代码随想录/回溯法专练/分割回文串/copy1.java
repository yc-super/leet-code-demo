package 代码随想录.回溯法专练.分割回文串;

import java.util.ArrayList;
import java.util.List;

public class copy1 {
    public static void main(String[] args) {
        String s="abcc";
        System.out.println(new copy1().partition(s));
    }
    private List<List<String>> res=new ArrayList<>();
    private List<List<String>> partition(String s) {
        if(s==null||s.equals("")){
            return res;
        }
        operate(s,0,new ArrayList<String>());
        return res;
    }

    private void operate(String s, int start, ArrayList<String> list) {
        if(start==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start ; i < s.length(); i++) {
            String str=s.substring(start,i+1);
            if(huiwen(str)){
                list.add(str);
                operate(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }
    //判断字符串是否是回文
    public static boolean huiwen(String s){
        if(s==null||s.length()==0){
            return false;
        }
        else{
            int start=0,end=s.length()-1;
            while(start<=end){
                if(s.charAt(start)==s.charAt(end)){
                    start++;
                    end--;
                }
                else{
                    return false;
                }
            }
            return true;
        }
    }
}
