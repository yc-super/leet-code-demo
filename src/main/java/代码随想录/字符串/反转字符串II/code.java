package 代码随想录.字符串.反转字符串II;

import java.util.Arrays;

public class code {
    // abcdefghij   3
    // cbadefihgj
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int len=chars.length;
        int right;
        for (int i = 0; i < len; i+=2*k) {
            right=i+k-1>=len?len-1:i+k-1;
            swap(i,right,chars);
        }
        return String.valueOf(chars);
    }

    private void swap(int left, int right, char[] chars) {
        while(left<right){
            chars[left]^=chars[right];
            chars[right]^=chars[left];
            chars[left]^=chars[right];
            left++;
            right--;
        }
    }
}
