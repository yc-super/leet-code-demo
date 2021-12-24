package LeetCode.删除链表的倒数第N个结点;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class code {
    public static void main(String[] args) {
        //head = [1,2,3,4,5], n = 2
        //[1,2,3,5]
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next=l2;
//        l2.next=l3;
//        l3.next=l4;
//        l4.next=l5;
        int n=1;
        ListNode ll=new code().removeNthFromEnd3(l1,n);
    }
    //遍历统计数量
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p=head;
        int num=1;
        while(p.next!=null){
            p=p.next;
            num++;
        }
        if(num-n==0){
            return head.next==null?null:head.next;
        }
        p=head;
        for (int i = 1; i <= num-n-1; i++) {
            p=p.next;
        }
        p.next=p.next.next==null?null:p.next.next;
        return head;
    }
    //方法2，栈
    public ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode p=head;
        Deque<ListNode> stark=new LinkedList<>();
        while (p!=null){
            stark.push(p);
            p=p.next;
        }
        for (int i = 0; i < n; i++) {
            stark.pop();
        }
        ListNode l=stark.peek();
        if(l==null)
            return head.next;
        l.next=l.next.next;
        return head;
    }

    //方法3，双指针（快慢指针）
    public ListNode removeNthFromEnd3(ListNode head, int n) {
        ListNode p1=head;
        ListNode p2=head;
        //1,2,3,4,5  2
        for (int i = 0; i < n; i++) {
            p2=p2.next;
        }
        if(p2==null)
            return head.next;
        while(p2.next!=null){
            p1=p1.next;
            p2=p2.next;
        }
        p1.next=p1.next.next;
        return head;

    }


    //一开始看错题目，这是n为2的情况
    public ListNode removeNthFromEndnnnn(ListNode head, int n) {
        ListNode p=head;
        ListNode q1;
        ListNode q2;
        if(p.next==null)
            return new ListNode();
        if(p.next.next==null){
            p.next=null;
            return p;
        }
        //1,2,3,4
        //1,2,4
        q1=p.next;
        q2=q1.next;
        while(q2.next!=null){
            p=p.next;
            q1=q1.next;
            q2=q2.next;
        }
        p.next=q2;
        return head;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
