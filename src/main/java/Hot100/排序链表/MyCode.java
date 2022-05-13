package Hot100.排序链表;

import 链表专练.ListNode;

import java.util.List;

public class MyCode {
    public static void main(String[] args) {
        ListNode head=new ListNode(4,new ListNode(2,new ListNode(1,new ListNode(3))));
//        ListNode listNode = new MyCode().sortList(head);
        ListNode listNode = new MyCode().sortList(null);
        System.out.println();
    }
    //冒泡排序，超时了
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)
            return head;

        ListNode h=head;
        ListNode k;
        ListNode tail=null;
        int temp;
        while(h.next!=null){
            k=head;
            while(k.next!=tail){
                if(k.val>k.next.val){
                    temp=k.val;
                    k.val=k.next.val;
                    k.next.val=temp;

                }
                k=k.next;
            }
            tail=k;
            h=h.next;
        }
        return head;
    }

    //排序问题，先来复习下快速排序和冒泡排序
    public void quickSort(int[] nums,int left,int right){
        if(left>=right)
            return;
        int temp=nums[left];
        int l=left;
        int r=right;
        while(l<r){
            while(l<r&&nums[r]>=temp)
                r--;
            nums[l]=nums[r];
            while(l<r&&nums[l]<=temp)
                l++;
            nums[r]=nums[l];
            r--;
        }
        nums[l]=temp;
        quickSort(nums,left,l-1);
        quickSort(nums,l+1,right);
    }

    //冒泡排序
    public void bubbleSort(int[] nums){
        if(nums==null||nums.length==0)
            return;
        int temp;
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if(nums[j]>nums[j+1]){
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }
}
