package 剑指offer.删除链表的节点;

import 代码随想录.链表专练.ListNode;

public class Solution {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode root = new ListNode();
        root.next = head;
        ListNode l = root, r = head;
        while (r != null) {
            if (r.val == val) {
                l.next = r.next;
                break;
            }
            l = r;
            r = r.next;
        }
        return root.next;
    }
}
