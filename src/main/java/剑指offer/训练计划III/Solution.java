package 剑指offer.训练计划III;

import 代码随想录.链表专练.ListNode;

public class Solution {
    public ListNode trainningPlan(ListNode head) {
        if (head == null)
            return null;
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
