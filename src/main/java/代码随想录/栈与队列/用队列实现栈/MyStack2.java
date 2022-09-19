package 代码随想录.栈与队列.用队列实现栈;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

//方法1，使用两个Deque实现
//代码随想录里的思路是：push就用Deque的addLast方法
//                  然后pop处理下：deque1和队列相同顺序，deque2作为辅助队列，把deque1里除了最后一个元素外全部暂时转移到deque2中，然后deque1.popFirst就是结果，最后把deque1和deque2调换
            //      top方法：居然直接用的Deque的peekLast方法，力扣题目里命名说只能用最基本的push to back、peek/pop from front、size 和 is empty，按理来说应该和pop方法一样的处理的
public class MyStack2 {

    Deque<Integer> deque1;
    Deque<Integer> deque2;

    public MyStack2(){
        deque1=new ArrayDeque<>();
        deque2=new ArrayDeque<>();
    }

    public void push(int x) {
//        deque1.push(x);//双端队列Deque的push方法，将元素添加到队首，相当于addFirst方法
//        deque1.add(x);//双端队列的add方法来自于Collection接口，添加元素到队尾。相对应的是remove方法，从队首删除
        deque1.addLast(x);
    }

    public int pop() {
        int size=deque1.size();
        size--;
        while(size-->0){
            deque2.addLast(deque1.pollFirst());
        }
        int res=deque1.pollFirst();
        //将deque1和deque2调换
        Deque<Integer> temp_deque;
        temp_deque=deque1;
        deque1=deque2;
        deque2=temp_deque;

        return res;
    }

    public int top() {
        return deque1.peekLast();
    }

    public boolean empty() {
        return deque1.isEmpty();
    }

    public static void main(String[] args) {
        MyStack2 st = new MyStack2();
        Integer integer = st.deque1.pollFirst();
        st.push(1);
        st.push(2);
        st.push(3);
        st.top();
        st.pop();
        st.pop();
        st.top();
    }
}
