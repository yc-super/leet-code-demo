package 链表专练.翻转链表;

public class code {
    public static void main(String[] args) {
        ListNode node1=new ListNode(1);
        ListNode node2=new ListNode(2);
        ListNode node3=new ListNode(3);
        ListNode node4=new ListNode(4);

        node1.next=node2;
        node2.next=node3;
        node3.next=node4;

        ListNode listNode = new code().reverseList2(node1);
        while(listNode!=null){
            System.out.print(listNode.val+",");
            listNode=listNode.next;
        }
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode l;
        ListNode r=head.next;
        head.next=null;
        //1,2,3,4
        //l h r
        //  l h r
        //    l h r
        //      l h
        while(r!=null){
            l=head;
            head=r;
            r=r.next;
            head.next=l;
        }
        return head;
    }

    //代码随想录，双指针。思路比我清晰
    public ListNode reverseList2(ListNode head) {
        ListNode prev=null,temp=head,cur=head;
        while(cur!=null){
            temp=cur.next;//临时保存
            cur.next=prev;
            prev=cur;
            cur=temp;
        }
        return prev;
    }
}
class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
