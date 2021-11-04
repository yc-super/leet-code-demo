package 回溯法专练.分割回文串;

import java.util.ArrayList;
import java.util.List;
/*
* 回溯法应用
* */
public class code {
    public static void main(String[] args) {
        String s="abcc";
        System.out.println(new code().partition(s));
    }

    static List<List<String>> res=new ArrayList<List<String>>();
    public List<List<String>> partition(String s) {
        if(s==null||s.length()==0)
            return res;
        List<String> list=new ArrayList<String>();
        operater(s,0,list);
        return res;
    }
    //回溯法找所有满足条件的集合
    private static void operater(String s,int start,List<String> list){
        if(start==s.length()){
            res.add(new ArrayList<String>(list));
            return;
        }
        for(int i=start;i<s.length();i++){
            String str=s.substring(start,i+1);
            if(huiwen(str)){
                list.add(str);
                operater(s,i+1,list);
                list.remove(list.size()-1);
            }
        }
        return;
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
