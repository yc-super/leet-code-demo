package 代码随想录.链表专练.环形链表II;

import 代码随想录.链表专练.ListNode;

import java.util.HashSet;
import java.util.Set;

public class code {
    public static void main(String[] args) {

    }

    //双重循环，超时
    public ListNode detectCycle(ListNode head) {
        if(head==null)
            return null;
        if(head.next==head)
            return head;
        ListNode node=head;
        ListNode head1=head;
        ListNode now_node;
        while(node!=null){
            head1=head;
            now_node=node.next;
            while(head1!=null){
                if(head1==node){
                    break;
                }else if(now_node==head1){
                    return head1;
                }
                head1=head1.next;
            }
            node=node.next;
        }
        return null;
    }
    //用Set存储
    public ListNode detectCycle2(ListNode head) {
        ListNode node=head;
        Set<ListNode> set=new HashSet<>();
        while(head!=null){
            if(set.contains(head)){
                return head;
            }
            set.add(head);
            head=head.next;
        }
        return null;
    }
    //代码随想录，快慢指针。快指针每次走两步，慢指针每次走一步。
    public ListNode detectCycle3(ListNode head){
        ListNode fast=head;
        ListNode low=head;
        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            low=low.next;
            if(fast==low){
                //有环
                while(fast!=head){
                    fast=fast.next;
                    head=head.next;
                }
                return head;
            }
        }
        return null;

    }

}
