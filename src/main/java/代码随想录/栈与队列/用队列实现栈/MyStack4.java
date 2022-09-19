package 代码随想录.栈与队列.用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

public class MyStack4 {
    Queue<Integer> queue;
    
    public MyStack4(){
        queue=new LinkedList<>();
    }

    public void push(int x) {
        queue.offer(x);
    }

    public int pop() {
        int size=queue.size();
        while (size!=1){
            queue.offer(queue.poll());
            size--;
        }
        return queue.poll();
    }

    public int top() {
        int size=queue.size();
        while (size!=1){
            queue.offer(queue.poll());
            size--;
        }
        int res=queue.peek();
        queue.offer(queue.poll());
        return res;
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}
