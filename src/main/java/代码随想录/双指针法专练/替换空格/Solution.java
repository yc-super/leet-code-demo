package 代码随想录.双指针法专练.替换空格;

//剑指 Offer 05. 替换空格
public class Solution {
    /*
    * 输入：s = "We are happy."
输出："We%20are%20happy."
    * */
    public static void main(String[] args) {
        String s = "We are happy.";
        System.out.println(replaceSpace3(s));
    }

    public static String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char temp;
        for (int i = 0; i < s.length(); i++) {
            temp = s.charAt(i);
            if (temp == ' ') {
                sb.append("%20");
            } else {
                sb.append(temp);
            }
        }
        return sb.toString();
    }

    //双指针法
    public static String replaceSpace2(String s) {
        if (s == null || s.length() == 0)
            return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ')
                sb.append("  ");
        }
        //不存在空格
        if (sb.length() == 0)
            return s;
        //存在空格
        int left = s.length() - 1;
        s += sb.toString();
        int right = s.length() - 1;
        char[] chars = s.toCharArray();
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            } else {
                chars[right] = chars[left];
            }
            left--;
            right--;
        }
        return new String(chars);
    }

    public static String replaceSpace3(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                sb.append("  ");
            }
        }
        //不存在空格
        if (sb.length() == 0)
            return s;
        //存在空格
        int left = s.length() - 1;
        s += sb.toString();
        char[] chars = s.toCharArray();
        int right = s.length() - 1;
        while (left >= 0) {
            if (chars[left] == ' ') {
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right--] = '%';
            } else {
                chars[right--] = chars[left];
            }
            left--;
        }
        return new String(chars);
    }
}
