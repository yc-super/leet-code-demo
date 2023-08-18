package 代码随想录.链表专练.环形链表II;

import 代码随想录.链表专练.ListNode;

public class code2 {
    /*
    * slow路程：a+b,b<c
    * fast路程：a+n*c+b,b<c
    *
    * a+n*c+b=(a+b)*2
    * n*c=a+b
    * */
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        ListNode slow=head,fast=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next==null)
                break;
            fast=fast.next.next;
            if(slow==fast){
                //有环
                ListNode temp=head;
                while(temp!=slow){
                    temp=temp.next;
                    slow=slow.next;
                }
                return temp;
            }
        }
        return null;
    }
}
