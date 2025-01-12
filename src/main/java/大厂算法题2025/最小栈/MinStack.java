package 大厂算法题2025.最小栈;

import java.util.Deque;
import java.util.LinkedList;

// 力扣155
// 考察对栈的理解程度
class MinStack {

    private Deque<Integer> q1;
    //辅助栈，用于存放最小值。原有的栈每放入一个元素，辅助栈就放入一个当前的最小值，这样主要是为了方便pop
    private Deque<Integer> minQ;

    public MinStack() {
        q1 = new LinkedList<>();
        minQ = new LinkedList<>();
        minQ.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        q1.push(val);
        minQ.push(Math.min(minQ.peek(), val));
    }

    public void pop() {
        q1.pop();
        minQ.pop();
    }

    public int top() {
        return q1.peek();
    }

    public int getMin() {
        return minQ.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
