package 剑指offer.最小栈;

import java.util.Stack;

class MinStack {

    Stack<Integer> stack;
    Stack<Integer> stack1;

    /** initialize your data structure here. */
    public MinStack() {
        stack=new Stack<>();
        stack1=new Stack<>();
        stack1.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
        stack.push(x);
        stack1.push(Math.min(x,stack1.peek()));
    }

    public void pop() {
        stack.pop();
        stack1.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return stack1.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
