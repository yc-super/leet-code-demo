package 链表.两两交换链表中的节点;

import 链表.ListNode;

public class cdoe {
    public static void main(String[] args) {

    }
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode a=head;
        ListNode b=head.next;
        ListNode c=b.next;
        head=b;
        b.next=a;
        while(c!=null){
            if(c.next!=null) {
                a.next = c.next;
            }else{
                a.next=c;
                return head;
            }
            a=c;
            b=c.next;
            c=c.next.next;
            b.next=a;
        }
        a.next=null;
        return head;
    }
}
