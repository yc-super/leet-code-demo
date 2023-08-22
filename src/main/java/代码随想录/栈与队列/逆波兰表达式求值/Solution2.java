package 代码随想录.栈与队列.逆波兰表达式求值;

import java.util.Stack;

public class Solution2 {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int temp;
        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                Integer s2 = stack.pop();
                Integer s1 = stack.pop();
                temp = 0;
                if (s.equals("+")) {
                    temp += s1 + s2;
                } else if (s.equals("-")) {
                    temp += s1 - s2;
                } else if (s.equals("*")) {
                    temp += s1 * s2;
                } else {
                    temp += s1 / s2;
                }
                stack.push(temp);
            } else {
                stack.push(Integer.valueOf(s));
            }
        }
        return stack.pop();
    }
}
