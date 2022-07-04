package LeetCode_Hot100.最小栈;

import java.util.ArrayList;
import java.util.List;

//题目：实现一个栈，实现push，pop，top方法，以及getMin方法，getMin方法要求时间复杂度O（1）
//我的思路：维护一个双向链表当做栈存储数据，再维护一个list存储排序好的数据，
public class MinStack {
    private DLinkedList head;
    private DLinkedList tail;

    private List<Integer> list;

    class DLinkedList{
        int val;
        DLinkedList pre;
        DLinkedList next;
        DLinkedList(){}
        DLinkedList(Integer val){
            this.val=val;
        }
    }
    public MinStack() {
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next=tail;
        tail.pre=head;//第一个双向链表，用来存储数据，也就是栈

        list=new ArrayList<>();//第二个链表，用来存储排序好的数据，从小到大
    }
//
    public void push(int val) {
        //先添加到双向链表头部
        DLinkedList dLinkedList = new DLinkedList(val);
        dLinkedList.pre=head;
        dLinkedList.next=head.next;
        head.next.pre=dLinkedList;
        head.next=dLinkedList;

        //再添加到有序链表
        int i=0;
        while(i<list.size()&&list.get(i)<val){
            i++;
        }
        list.add(i,val);
    }


    public void pop() {
        //先删除双向链表头部
        int a=head.next.val;
        head.next.next.pre=head;
        head.next=head.next.next;

        //再删除有序链表中该元素
        list.remove(a);
    }

    public int top() {
        return head.next.val;
    }

    public int getMin() {
        return list.get(0);
    }

}
