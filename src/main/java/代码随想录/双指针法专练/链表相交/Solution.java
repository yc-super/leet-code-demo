package 代码随想录.双指针法专练.链表相交;

import 代码随想录.链表专练.ListNode;

//面试题 02.07. 链表相交 简单
public class Solution {
    public static void main(String[] args) {

    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null)
            return null;

        ListNode tempA=headA;
        ListNode tempB=headB;
        int count_a=0;
        int count_b=0;
        while(tempA!=null){
            count_a++;
            tempA=tempA.next;
        }
        while(tempB!=null){
            count_b++;
            tempB=tempB.next;
        }
        tempA=headA;
        tempB=headB;
        if(count_a>=count_b){
            while(count_a!=count_b){
                tempA=tempA.next;
                count_a--;
            }
        }else{
            while(count_a!=count_b){
                tempB=tempB.next;
                count_b--;
            }
        }
        //同时前进
        while(tempA!=null){
            if(tempA==tempB)
                return tempA;
            tempA=tempA.next;
            tempB=tempB.next;
        }
        return null;
    }
}
