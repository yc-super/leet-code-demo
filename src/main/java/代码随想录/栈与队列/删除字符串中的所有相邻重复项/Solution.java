package 代码随想录.栈与队列.删除字符串中的所有相邻重复项;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        String s="abbaca";
        String s="aba";
        System.out.println(removeDuplicates(s));
    }
    public static String removeDuplicates(String s) {
        Deque<Character> stack=new ArrayDeque<>();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c=s.charAt(i);
            if(!stack.isEmpty()&&stack.peek()==c){
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!stack.isEmpty()){
            sb.append(stack.pollLast());
        }
        return sb.toString();
    }
}
