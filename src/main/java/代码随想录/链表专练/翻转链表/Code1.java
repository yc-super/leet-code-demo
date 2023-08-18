package 代码随想录.链表专练.翻转链表;

public class Code1 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        // a b c d
        ListNode a = head;
        ListNode b = head.next;
        a.next = null;
        ListNode c;
        while (b != null) {
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }

}
