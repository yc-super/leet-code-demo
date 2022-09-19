package 代码随想录.栈与队列.用队列实现栈;

import java.util.ArrayDeque;
import java.util.Deque;

//方法2，使用1个Deque(1个Queue也可以，一样的)
//思路：push方法就是队列普通的offer方法，pop和top方法则是，不断将首部元素移至尾部，直到原有尾部在首部
public class MyStack3 {
    Deque<Integer> deque;

    public MyStack3() {
        deque=new ArrayDeque<>();
    }

    public void push(int x) {
        deque.offerLast(x);
    }

    public int pop() {
        int size=deque.size();
        while (size!=1){
            deque.offerLast(deque.pollFirst());
            size--;
        }
        return deque.pollFirst();
    }

    public int top() {
        int size=deque.size();
        while (size!=1){
            deque.offerLast(deque.pollFirst());
            size--;
        }
        int res=deque.peekFirst();
        deque.offerLast(deque.pollFirst());
        return res;
    }

    public boolean empty() {
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        MyStack3 stack = new MyStack3();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());

        stack.pop();
        stack.pop();
        stack.pop();
    }
}
