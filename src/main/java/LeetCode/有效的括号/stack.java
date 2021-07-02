package LeetCode.有效的括号;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class stack {
    public static void main(String[] args) {

    }
    public static boolean isValid(String s) {
        int n = s.length();
        if (n % 2 == 1) {
            return false;
        }

        Map<Character, Character> pairs = new HashMap<Character, Character>() {{
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }};
        Deque<Character> stack = new LinkedList<Character>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (pairs.containsKey(ch)) {
                //stack.peek():peek方法取出栈顶原数，而不做出栈操作；而pop则是取出栈顶元素，并出栈
                //push为入栈操作
                //Deque为双端队列，是Queue的子接口，特点是：队列的两端都可以进出元素，入队offer,出队poll
                //若将Deque限制为只能从一端入队和出队，就成了栈的数据结构
                if (stack.isEmpty() || stack.peek() != pairs.get(ch)) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
