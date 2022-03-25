package Hot100.括号生成;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyCode {
    //数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
    /*
    * 输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]
*
* n=2
* ()()  (())
* 1,-1,1,-1   1,1,-1,-1
*
* 输入：n = 1
输出：["()"]
    *
    *
    * */
    public static void main(String[] args) {
        //先来回顾下排列问题：输入一个字符串，打印出该字符串中字符的所有排列。
        //例如：输入：s = "abc"
        //输出：["abc","acb","bac","bca","cab","cba"]
        
       /* String s="acc";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] vis=new boolean[chars.length];
        //回溯法
        backTrack(chars,new StringBuilder(),vis);
        System.out.println(list);*/



        //利用上面的思路解决这个问题：
       /* String s="((()))";
        char[] chars = s.toCharArray();
        Arrays.sort(chars);*/

        int n=1;
        char[] chars=new char[n*2];
        for (int i = 0; i < n; i++) {
            chars[i]='(';
        }
        for (int i = n; i < n*2; i++) {
            chars[i]=')';
        }

        boolean[] vis=new boolean[chars.length];
        //回溯法
        backTrack(chars,new StringBuilder(),vis,0,0);
        System.out.println(list);
    }

    private static List<String> list=new ArrayList<>();
    private static void backTrack( char[] chars, StringBuilder sb,boolean[] vis,int num1,int num2) {
        if(sb.length()==chars.length){
            list.add(sb.toString());
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if(vis[i]||(i>0&&!vis[i-1]&&chars[i]==chars[i-1])){
                continue;
            }
            if(chars[i]=='('){
                num1++;
            }else {
                num2++;
            }
            if(num1<num2){
                if(chars[i]=='('){
                    num1--;
                }else {
                    num2--;
                }
                continue;
            }
            vis[i]=true;
            sb.append(chars[i]);
            backTrack(chars,sb,vis,num1,num2);
            if(chars[i]=='('){
                num1--;
            }else {
                num2--;
            }
            vis[i]=false;
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
