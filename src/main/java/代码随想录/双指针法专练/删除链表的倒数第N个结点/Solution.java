package 代码随想录.双指针法专练.删除链表的倒数第N个结点;

import 代码随想录.链表专练.ListNode;

import java.util.HashSet;
import java.util.Set;

//19. 删除链表的倒数第 N 个结点  中等
public class Solution {
    /*
    * 输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]
    * */
    public static void main(String[] args) {

    }
    //双指针法--快慢指针
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode();
        temp.next=head;
        ListNode left=temp;
        ListNode right=temp;

        while(n!=0) {
            right = right.next;
            n--;
        }
        while(right.next!=null){
            left=left.next;
            right=right.next;
        }

        left.next=left.next.next;
        return temp.next;
    }

    public ListNode removeNthFromEnd2(ListNode head, int n) {
        //思路：快慢指针
        ListNode temp=new ListNode();//辅助指针，便于处理移除头结点的情况
        temp.next=head;
        ListNode slow=temp;
        ListNode fast=head;
        for (int i = 0; i < n-1; i++) {
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
         slow.next=slow.next.next;
        return temp.next;
    }
}
