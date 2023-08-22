package 代码随想录.栈与队列.用栈实现队列;

import java.util.LinkedList;
import java.util.Stack;

/*
 * 思路：1个用来进，1个用来出
 * */
class MyQueue1 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue1() {
        stack2 = new Stack();
        stack1 = new Stack();
    }

    public void push(int x) {
        stack1.push(x);
    }

    public int pop() {
        fixStack2(stack1, stack2);
        return stack2.pop();
    }

    public int peek() {
        fixStack2(stack1, stack2);
        return stack2.peek();
    }

    public boolean empty() {
        return stack2.isEmpty() && stack1.isEmpty();
    }

    private void fixStack2(Stack<Integer> stack1, Stack<Integer> stack2) {
        if (!stack2.isEmpty()) {
            return;
        }
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }

}
