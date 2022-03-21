package Hot100.括号生成;

import java.util.ArrayList;
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
        
        String s="abc";
        char[] chars = s.toCharArray();
        backTrack(0,chars,new StringBuilder());
    }

    private static List<String> list=new ArrayList<>();
    private static void backTrack(int start, char[] chars, StringBuilder sb) {
        if(start==chars.length){
            list.add(sb.toString());
        }
        for (int i = 0; i < chars.length; i++) {
            
        }
    }
}
