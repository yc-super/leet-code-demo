package 代码随想录.链表专练.移除链表元素;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import 代码随想录.链表专练.ListNode;

import java.util.Map;

public class code1 {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(7, new ListNode(7, new ListNode(7)));
        System.out.println(removeElements(listNode,7));
    }
        public static ListNode removeElements(ListNode head, int val) {
            ListNode result=new ListNode();
            result.next=head;
            ListNode pre=result;
            ListNode fast=head;
            while(fast!=null){
                if(fast.val==val){
                    pre.next=fast.next;
                    fast=fast.next;
                }else{
                    pre=pre.next;
                    fast=fast.next;
                }

            }
            return result.next;
        }
}
