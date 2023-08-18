package 代码随想录.链表专练.两两交换链表中的节点;

import 代码随想录.链表专练.ListNode;

public class code1 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        //a b c d e
        ListNode a = head;
        ListNode b = head.next;
        ListNode dummy = b;
        ListNode c;
        while (a != null) {
            c = b.next;
            if (c == null||c.next==null) {
                a.next = c;
                b.next = a;
                break;
            } else {
                a.next = c.next;
                b.next = a;
            }
            a = c;
            b = a.next;
        }
        return dummy;
    }
}
