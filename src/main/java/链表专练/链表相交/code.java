package 链表专练.链表相交;

import 链表专练.ListNode;

public class code {
    public static void main(String[] args) {
        
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        int m=1,n=1;
        //1,2
        //0,1,2
        ListNode a=headA,b=headB;
        while (a.next!=null){
            a=a.next;
            m++;
        }
        while (b.next!=null){
            b=b.next;
            n++;
        }
        if(m>=n){
            while(m-n!=0){
                headA=headA.next;
                n++;
            }
            while(headA!=null){
                if(headA==headB)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
        }else{
            while(n-m!=0){
                headB=headB.next;
                m++;
            }
            while(headA!=null){
                if(headA==headB)
                    return headA;
                headA=headA.next;
                headB=headB.next;
            }
        }
        return null;
    }
}
