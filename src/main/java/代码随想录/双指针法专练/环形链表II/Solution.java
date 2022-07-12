package 代码随想录.双指针法专练.环形链表II;

import 代码随想录.链表专练.ListNode;
//142. 环形链表 II 中等
public class Solution {
    public static void main(String[] args) {


    }

    //快慢指针，快指针一次走2步，慢指针一次走2步，如果有环最终快慢指针会相遇（慢指针相较于快指针不动，快指针每次走1步，总会和慢指针相遇的）
    /*
    * 2a+2b=a+b+nb+nc
        a+b=nb+nc
        a=（n-1）(b+c)+c
    * */
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null){
            fast=fast.next;
            if(fast==null)
                return null;
            fast=fast.next;
            slow=slow.next;
            if(fast==slow){
                while(head!=fast){
                    head=head.next;
                    fast=fast.next;
                }
                return head;
            }
        }
        return null;
    }
}
