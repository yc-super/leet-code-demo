package Hot100.最小栈;

import java.util.ArrayList;
import java.util.List;

//我的思路：维护一个双向链表当做栈存储数据，再维护一个list存储排序好的数据，
public class MinStack {
    private DLinkedList head1;
    private DLinkedList tail1;

    private List<Integer> list;

    class DLinkedList{
        int val;
        DLinkedList pre;
        DLinkedList next;
        DLinkedList(){}
    }
    public MinStack() {
        head1 = new DLinkedList();
        tail1 = new DLinkedList();
        head1.next=tail1;
        tail1.pre=head1;//第一个双向链表，用来存储数据，也就是栈

        list=new ArrayList<>();//第二个链表，用来存储排序好的数据，从小到大
//        head2 = new DLinkedList();
//        tail2 = new DLinkedList();
//        head2.next=tail2;
//        tail2.pre=head2;//第二个双向链表，用来存储排序好的数据
    }
//
    public void push(int val) {
        addToHead(val);
        addToList(val);
    }


    public void pop() {

    }

    public int top() {
        return head1.next.val;
    }

    public int getMin() {
        return list.get(0);
    }



    private void addToHead(int val) {

    }
    private void addToList(int val) {
        if(list.size()==0){
            list.add(val);
        }
        /*else{
            for (int i = 0; i < list.size(); i++) {

            }
        }*/
        
        
    }
}
