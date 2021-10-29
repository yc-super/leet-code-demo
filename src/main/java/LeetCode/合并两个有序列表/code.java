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
        ListNode listNode1 = l1;
        ListNode listNode2 = l2;
        while(listNode1.next!=null){
            if(listNode1.val>l2.val){
                l2=l2.next;
            }
            while(listNode2.next!=null) {

            }
        }
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
