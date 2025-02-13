package 剑指offer.用两个栈实现队列;

import java.util.Stack;

class CQueue {
    final private Stack<Integer> s1;
    final private Stack<Integer> s2;

    public CQueue() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void appendTail(int value) {
        while(!s2.empty()){
            s1.push(s2.pop());
        }
        s1.push(value);
    }

    public int deleteHead() {
        if(!s2.empty()){
            return s2.pop();
        }
        while(!s1.empty()){
            s2.push(s1.pop());
        }

        return s2.empty()?-1:s2.pop();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
