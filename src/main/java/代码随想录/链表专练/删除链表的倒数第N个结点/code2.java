package 代码随想录.链表专练.删除链表的倒数第N个结点;

import 代码随想录.链表专练.ListNode;

public class code2 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode();
        dummy.next=head;
        ListNode fast=dummy;
        ListNode tempHead=dummy;
        int temp=n;
        while(temp!=-1){
            fast=fast.next;
            temp--;
        }
        while(fast!=null){
            dummy=dummy.next;
            fast=fast.next;
        }
        dummy.next=dummy.next.next;
        return tempHead.next;
    }
}
