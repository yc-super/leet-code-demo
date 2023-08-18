package 代码随想录.字符串.反转字符串中的单词;

public class code {
    public static void main(String[] args) {
        System.out.println(new code().reverseWords("the sky is blue"));
    }
    public String reverseWords(String s) {
        int len = s.length();
        int start = 0, end = len - 1;
        while (start < len && s.charAt(start) == ' ') {
            start++;
        }
        if (start == len)
            return "";
        while (end >= start && s.charAt(end) == ' ') {
            end--;
        }
        if (start == end)
            return String.valueOf(s.charAt(start));

        StringBuilder ss=new StringBuilder();
        while(start<=end){
            if(s.charAt(start)!=' '||ss.charAt(ss.length()-1)!=' ')
                ss.append(s.charAt(start));
        }

        String newString = s.substring(start, end + 1);
        int length = newString.length();
        char[] chars = newString.toCharArray();
        swap(0, length - 1, chars);
        end = 0;
        StringBuilder sb=new StringBuilder();
        while (end < length) {
            start = end;
            while (end < length && chars[end] != ' ') {
                end++;
            }
            for (int i = end-1; i >=start ; i--) {
                sb.append(chars[i]);
            }
            sb.append(" ");

            while (end < length && chars[end] == ' ') {
                end++;
            }
        }
        if(sb.length()>0)
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();
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
