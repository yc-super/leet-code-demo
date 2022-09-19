package 代码随想录.栈与队列.有效的括号;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {
    public static void main(String[] args) {
//        String s="()[]{}";//true
//        String s="(]";//false
//        String s="({)[}]";//false
//        String s="[({(){}})]";//false
        String s="}}()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        char[] chars = s.toCharArray();
        for(char c:chars){
            if(c=='('||c=='['||c=='{'){
                stack.push(c);
            }else{
                if(stack.size()==0||c!=map.get(stack.peek())){
                    return false;
                }
                stack.pop();
            }
        }
        return stack.size()==0;
    }
}
