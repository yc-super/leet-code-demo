package 链表.移除链表元素;

import 链表.ListNode;


public class code {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(4);
        ListNode node3=new ListNode(1);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode result=new code().removeElements3(node1,4);
        System.out.println();
    }
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null){
            return null;
        }
        ListNode node=head;
        ListNode node1=head.next;
        while (node1!=null){
            if(node1.val==val){
                while (node1!=null&&node1.val==val){
                    node1=node1.next;
                }
                if(node1==null){
                    node.next=null;
                    return head;
                }
                node.next=node1;
                node=node.next;
                node1=node1.next;
            }else{
                node=node1;
                node1=node1.next;
            }
        }
        return head;
    }

    //代码随想录答案1，无虚拟节点
    public ListNode removeElements2(ListNode head, int val) {
        while(head!=null&&head.val==val){
            head=head.next;
        }
        if(head==null)
            return null;
        ListNode pre=head,cur=head.next;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        return head;
    }

    //代码随想录，答案2，有虚拟节点
    public ListNode removeElements3(ListNode head, int val) {
        if(head==null)
            return null;
        ListNode dummy=new ListNode(-1,head);
        ListNode pre=dummy,cur=head;
        while(cur!=null){
            if(cur.val==val){
                pre.next=cur.next;
            }else{
                pre=cur;
            }
            cur=cur.next;
        }
        return dummy.next;
    }
}

