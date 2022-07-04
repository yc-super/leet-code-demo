package 代码随想录.回溯法专练.分割回文串;

import java.util.ArrayList;
import java.util.List;

public class code_copy {
    public static void main(String[] args) {
        String s="aab";
        System.out.println(partition(s));
    }
    static List<List<String>> res=new ArrayList<>();

    public static List<List<String>> partition(String s) {
        if(s==null||s.length()==0)
            return res;

        operate(s,0,new ArrayList());
        return res;
    }
    public static void operate(String s,int start,List<String> list){
        if(start==s.length()){
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            String str=s.substring(start,i+1);
            if(huiwen(str)){
                list.add(str);
                operate(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
    }

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
