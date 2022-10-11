package 代码随想录.双指针法专练.反转链表;
//力扣 206 简单
public class Solution {
    public static void main(String[] args) {
        ListNode head =new ListNode(1,new ListNode(2, new ListNode(3)));
        ListNode listNode = reverseList3(head);
        System.out.println();
    }
    //双指针，一个指针记录现在的节点，一个指针记录下一个节点，并将指向方向反转

    public static ListNode reverseList2(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode left=head;
        ListNode right=head.next;
        head=head.next;
        left.next=null;
        while(right!=null) {
            head=head.next;
            right.next = left;

            left=right;
            right=head;
        }
        return left;
    }
    public static ListNode reverseList(ListNode head) {
        //第一想到的是遍历一遍，重新生成一个链表，空间复杂度o(n)
        if(head==null||head.next==null)
            return head;
        ListNode result_head=null;
        while(head!=null){
            result_head=new ListNode(head.val,result_head);
            head=head.next;
        }
        return result_head;
    }

    public static ListNode reverseList3(ListNode head) {
        //a->b->c
        //a->b->c
        if(head==null||head.next==null)
            return head;
        ListNode pre=head.next;
        ListNode next=pre.next;
        head.next=null;
        while(next!=null){
            pre.next=head;
            head=pre;
            pre=next;
            next=next.next;
        }
        pre.next=head;
        return pre;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
