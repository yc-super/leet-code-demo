package LeetCode_Hot100.回文链表;

import 代码随想录.链表专练.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    //举例：122331
    //方法1，存到List中，然后双指针
    public boolean isPalindrome(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode tempHead=head;
        while(tempHead!=null){
            list.add(tempHead.val);
            tempHead=tempHead.next;
        }
        int n=list.size();
        int first,second;
        if(n%2==0){
            //偶数个节点
            first=n/2-1;
            second=first+1;

        }else{
            //奇数个节点
            first=n/2-1;
            second=n/2+1;
        }
        while(first>=0){
            if(list.get(first)!=list.get(second)){
                return false;
            }
            first--;
            second++;
        }
        return true;
    }
}
