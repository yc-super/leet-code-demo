package 链表专练.删除链表的倒数第N个结点;


import 链表专练.ListNode;

public class cdoe {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

//        node1.next=node2;
//        node2.next=node3;
//        node3.next=node4;

        ListNode listNode = new cdoe().removeNthFromEnd(node1, 1);
        System.out.println();
    }
    public ListNode removeNthFromEnd(ListNode head, int n){
        //dummy,1,2,3,4
        ListNode dummy=new ListNode(0,head);
        ListNode l=dummy;
        ListNode r=head;
        while(n!=0){
            r=r.next;
            n--;
        }
        while(r!=null){
            l=l.next;
            r=r.next;
        }
        l.next=l.next.next;
        return dummy.next;
    }
}

