package 代码随想录.栈与队列.用队列实现栈;

import java.util.LinkedList;
import java.util.Queue;

/*
* 可以用两种方法：
1.两个队列实现栈：pop操作时，把第一个队列所有元素放到第二个队列（除了最后一个），pop后再把元素移过来
2.用1个队列实现栈，实际上，把队列头部一个一个移到队列尾部，最后原本队列尾部的元素就到了头部，pop就好了
* */

//方法1，使用两个Queue实现
public class MyStack {
    Queue<Integer> queue1;//和栈中保持一样的队列
    Queue<Integer> queue2;//辅助队列

    public MyStack(){
        queue1=new LinkedList<>();
        queue2=new LinkedList<>();
    }

    public void push(int x) {
        queue2.offer(x);
        while(!queue1.isEmpty()){
            queue2.offer(queue1.poll());
        }
        Queue<Integer> temp_queue;
        temp_queue=queue1;
        queue1=queue2;//queue1最终存储的顺序和栈相同
        queue2=temp_queue;
    }

    public int pop() {
        return queue1.poll();
    }

    public int top() {
        return queue1.peek();
    }

    public boolean empty() {
        return queue1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.queue1.size();
        int size=1;
        while(size-->0){
            System.out.println(22);
        }
        System.out.println(size);
    }

}
