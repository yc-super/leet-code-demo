package 代码随想录.链表专练.两两交换链表中的节点;

import 代码随想录.链表专练.ListNode;

public class code {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode result=new code().swapPairs2(node1);
        System.out.println();
    }
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return null;
        if(head.next==null)
            return head;
        ListNode a=head;
        ListNode b=head.next;
        ListNode c=b.next;
        head=b;
        b.next=a;
        while(c!=null){
            if(c.next!=null) {
                a.next = c.next;
            }else{
                a.next=c;
                return head;
            }
            a=c;
            b=c.next;
            c=c.next.next;
            b.next=a;
        }
        a.next=null;
        return head;
    }

    //代码随想录，总体思路一样（引入了虚拟节点），代码更简洁
    public ListNode swapPairs2(ListNode head) {

        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode prev = dummyNode;

        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next; // 缓存 next
            prev.next = head.next;          // 将 prev 的 next 改为 head 的 next
            head.next.next = head;          // 将 head.next(prev.next) 的next，指向 head
            head.next = temp;               // 将head 的 next 接上缓存的temp
            prev = head;                    // 步进1位
            head = head.next;               // 步进1位
        }
        return dummyNode.next;
    }
}
