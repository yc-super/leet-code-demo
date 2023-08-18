package 代码随想录.字符串.左旋转字符串;

public class code {
    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        swap(0,n-1,chars);
        swap(0,chars.length-1,chars);
        swap(0,chars.length-n-1,chars);
        return String.valueOf(chars);
    }
    private void swap(int left, int right, char[] chars) {
        while (left < right) {
            chars[left] ^= chars[right];
            chars[right] ^= chars[left];
            chars[left] ^= chars[right];
            left++;
            right--;
        }
    }
}
