package 代码随想录.栈与队列.删除字符串中的所有相邻重复项;

import java.util.Stack;

public class Solution2 {
/*
* "abbaca"
输出："ca"
* */
    public static String removeDuplicates(String s) {
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        int len=stack.size();
        char[] chars=new char[len];
        for (int i = len-1; i >=0; i--) {
            chars[i]=stack.pop();
        }
        return String.valueOf(chars);
    }
}
