package Hot100.排序链表;

import 链表专练.ListNode;

public class MyCode2 {
    public static void main(String[] args) {
//        ListNode head=new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
        ListNode head = new ListNode(2,new ListNode(3));
        ListNode listNode = sortList(head);
        while(listNode!=null) {
            System.out.println(listNode.val);
            listNode=listNode.next;
        }
    }

    private static ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;
        ListNode h=head;
        int len=1;
        while(h.next!=null){
            h=h.next;
            len++;
        }
        int[] temp=new int[len];
        mergeSort(head,h,temp,len);
        return head;
    }

    private static void mergeSort(ListNode head,ListNode tail, int[] temp, int len ) {
        if(len<=1)
            return;
        int new_len=len/2;
        int l=0;
        ListNode middle=head;
        int l_index=len%2==0?new_len:new_len+1;
        while(l<l_index-1){
            middle=middle.next;
            l++;
        }
        mergeSort(head,middle,temp,l_index);
        mergeSort(middle.next,tail,temp,new_len);
        mergeSort(head,middle,tail,temp);
    }

    private static void mergeSort(ListNode head, ListNode middle, ListNode tail, int[] temp) {
        ListNode left=head;
        ListNode right=middle.next;
        int i=0;

        while(left!=middle.next&&right!=tail.next){
            while(left!=middle.next&&left.val<=right.val){
                temp[i++]=left.val;
                left=left.next;
            }
            while(right!=tail.next&&left.val>right.val){
                temp[i++]=right.val;
                right=right.next;
            }
        }
        while(left!=middle.next){
            temp[i++]=left.val;
            left=left.next;
        }
        while(right!=tail.next){
            temp[i++]=right.val;
            right=right.next;
        }
        int ii=0;
        left=head;
        while(ii!=i){
            left.val=temp[ii++];
            left=left.next;
        }
    }

}
