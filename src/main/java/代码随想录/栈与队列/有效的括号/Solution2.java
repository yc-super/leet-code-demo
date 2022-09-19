package 代码随想录.栈与队列.有效的括号;

import java.util.LinkedList;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {
//        String s="()[]{}";//true
//        String s="(]";//false
//        String s="({)[}]";//false
//        String s="[({(){}})]";//true
        String s="}}()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack();
        char c;
        for (int i = 0; i < s.length(); i++) {
            c=s.charAt(i);
            if(c=='('){
                stack.push(')');
            }else if(c=='['){
                stack.push(']');
            }else if(c=='{'){
                stack.push('}');
            }else if(stack.size()==0||stack.peek()!=c){
                return false;
            }else{
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}
