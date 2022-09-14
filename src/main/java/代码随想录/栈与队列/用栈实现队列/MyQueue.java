package 代码随想录.栈与队列.用栈实现队列;

import java.util.Stack;

public class MyQueue {

    Stack<Integer> stackIn;
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        dumpStackIn();
        return stackOut.pop();
    }


    public int peek() {
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackOut.empty() && stackIn.empty();
    }

    private void dumpStackIn() {
        if (!stackOut.empty())
            return;
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }

    public static void main(String[] args) {

    }

}
