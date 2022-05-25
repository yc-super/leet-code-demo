package Hot100.排序链表;

import 链表专练.ListNode;
//自己再写一遍，快慢指针+归并排序
public class codeCopy {
    public static void main(String[] args) {
//        ListNode head=new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3,new ListNode(5)))));
        ListNode head=new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1,new ListNode(6,new ListNode(7)))))));
//        ListNode head=new ListNode(4);
        ListNode listNode = sortList(head);
        System.out.println();
    }
    public static ListNode sortList(ListNode head) {
        if(head==null)
            return null;
        return mergeSort(head,null);
    }

    private static ListNode mergeSort(ListNode head,ListNode tail) {
        if(head==null)
            return null;
        if(head.next==tail) {
            head.next=null;
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=tail){
            slow=slow.next;
            fast=fast.next;
            if(fast!=tail)
                fast=fast.next;
        }
//        ListNode middle=slow;//此处把slow赋值给middle是因为

        ListNode node1 = mergeSort(head, slow);
        ListNode node2 = mergeSort(slow, tail);
        return mergeSort2(node1,node2);
    }

    private static ListNode mergeSort2(ListNode node1, ListNode node2) {
        ListNode hh=new ListNode();
        ListNode h=hh;
        while(node1!=null&&node2!=null){
            if(node1.val<=node2.val){
                h.next=node1;
                node1=node1.next;
            }else{
                h.next=node2;
                node2=node2.next;
            }
            h=h.next;
        }
        if(node1!=null){
            h.next=node1;
        }
        if(node2!=null){
            h.next=node2;
        }
        return hh.next;
    }
}
