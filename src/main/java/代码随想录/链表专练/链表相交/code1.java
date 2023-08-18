package 代码随想录.链表专练.链表相交;

import 代码随想录.链表专练.ListNode;

public class code1 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;
        int numA=0,numB=0;
        ListNode tempA=headA;
        ListNode tempB=headB;
        while(tempA!=null){
            numA++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            numB++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(numA>numB){
            int num=numA-numB;
            while(num!=0){
                tempA=tempA.next;
                num--;
            }
        }else{
            int num=numB-numA;
            while(num!=0){
                tempB=tempB.next;
                num--;
            }
        }
        while(tempA!=null){
            if(tempA==tempB){
                break;
            }
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return tempA;
    }
}
