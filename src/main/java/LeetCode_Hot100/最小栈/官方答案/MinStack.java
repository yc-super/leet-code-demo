package LeetCode_Hot100.最小栈.官方答案;

import java.util.Deque;
import java.util.LinkedList;

//思路：在a入栈时，假设栈里还有b,c,d元素，只要a不出栈，那么下面的b,c,d肯定也不会出栈，那么换句话说就是，只要a不出栈，最小值就是确定的，那么a对应一个最小值。
//然后设置一个辅助栈，用于存放最小值，保持和上面的栈元素一一对应
//时间复杂度，所有方法时间复杂度都是O（1），空间复杂度o(n)
public class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    public MinStack() {
        stack=new LinkedList<>();
        minStack=new LinkedList<>();
        minStack.offer(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack.push(val);
        minStack.push(Math.min(minStack.peek(),val));
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
