package Hot100.环形链表;

import 链表专练.ListNode;

import java.util.*;

public class MyCode {
    public static void main(String[] args) {
        ListNode node=new ListNode(3);
        ListNode n1=new ListNode(2);
        ListNode n2=new ListNode(0);
        ListNode n3=new ListNode(-4);

        n3.next=n1;
        n2.next=n3;
        n1.next=n2;
        node.next=n1;
        boolean b = new MyCode().hasCycle2(node);
        System.out.println(b);
    }
    //思路：之前做过环形链表II，但是忘记了，看了下，有map思路，有快慢指针思路。我现在状态不好，先用简单的map试试
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        Set<ListNode> set=new HashSet<>();
        set.add(head);
        while(head.next!=null){
            head=head.next;
            if(set.contains(head)){
                return true;
            }else{
                set.add(head);
            }
        }
        return false;
    }

    //快慢指针,快指针一次走两步，慢指针一次走一步
    public boolean hasCycle2(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode slow=head.next;
        ListNode fast=head.next.next;
        while(fast!=null){
            if(slow==fast) {
                return true;
            } else{
                if(fast.next==null){
                    return false;
                } else {
                    slow=slow.next;
                    fast=fast.next.next;
                }
            }
        }
        return false;
    }

}
