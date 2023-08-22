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
        Stack<Character> stack=new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c=s.charAt(i);
            if(c=='('||c=='['||c=='{') {
                stack.push(c);
                continue;
            }
            if(stack.isEmpty()){
                return false;
            }
            if(c==')'){
                if(stack.pop()!='('){
                    return false;
                }
            }else if(c==']'){
                if(stack.pop()!='['){
                    return false;
                }
            }else if(c=='}'){
                if(stack.pop()!='{'){
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
