package 代码随想录.双指针法专练.反转字符串;

//力扣344 简单
public class Solution {
    public static void reverseString(char[] s) {
        int l=0;
        int r=s.length-1;
        char temp;
        while(l<r){
            temp=s[l];
            s[l]=s[r];
            s[r]=temp;
            l++;
            r--;
        }
    }

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println();
    }

    public static void reverseString2(char[] s) {
        int left=0,right=s.length-1;
        char temp;
        while(left<right){
            temp=s[left];
            s[left]=s[right];
            s[right]=temp;
            left++;
            right--;
        }
    }
}
