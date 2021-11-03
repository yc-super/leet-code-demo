package LeetCode.合并两个有序列表;

public class code {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode listNode = mergeTwoLists(l1, l2);
        while (listNode.next!=null){
            System.out.println(listNode.val);
            listNode=listNode.next;
        }

    }
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;
        ListNode listNode1;
        ListNode listNode;
        if(l1.val<=l2.val){
            listNode=l1;
            l1=l1.next;
        }else{
            listNode=l2;
            l2=l2.next;
        }
        listNode1=listNode;
        while(l1!=null&&l2!=null){
            if(l1.val<=l2.val){
                listNode.next=l1;
                listNode=listNode.next;
                l1=l1.next;
            }else{
                listNode.next=l2;
                listNode=listNode.next;
                l2=l2.next;
            }
        }
        if(l1!=null) {
            listNode.next =l1;
        }
        if(l2!=null){
            listNode.next=l2;
        }
        return listNode1;
    }
}
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
 }
