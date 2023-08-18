package 代码随想录.字符串.反转字符串;

public class code {
    public void reverseString(char[] s) {
        int left = 0, right = s.length - 1;
        while (left < right) {
            s[left] ^= s[right];
            s[right] ^= s[left];
            s[left] ^= s[right];
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] aa={2,3,4};
        int i=0,j=2;
        aa[i++]+=aa[j--];
        System.out.println();
    }
}
