package 代码随想录.双指针法专练.反转字符串中的单词;
//力扣 151. 颠倒字符串中的单词
/*
* 示例：
* 输入：s = "the sky is blue"
输出："blue is sky the"
* */
public class Solution {
    public static void main(String[] args) {
        String s = "the";
        System.out.println(reverseWords2(s));
    }
    public static String reverseWords(String s) {
        StringBuilder sb=new StringBuilder();
        int right;
        for (int left = s.length()-1; left >=0; left--) {
            while(left>=0&&s.charAt(left)==' '){
                left--;
            }
            right=left;
            while(left>=0&&s.charAt(left)!=' '){
                left--;
            }
            sb.append(s, left+1, right+1);
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        if(sb.charAt(sb.length()-1)==' ')
            sb.deleteCharAt(sb.length()-1);
        return sb.toString();

    }

    public static String reverseWords2(String s) {
        //1,将s从 " the sky     is blue  "处理成 "the sky     is blue"的规范格式
        StringBuilder sb=new StringBuilder();
        int left=0,right=s.length()-1;
        while (left<s.length()&& s.charAt(left)==' '){
            left++;
        }
        while (right>=0&& s.charAt(right)==' '){
            right--;
        }
        int temp_index;
        while (left <= right) {
            temp_index = right;
            while (left <= right && s.charAt(right) != ' ') {
                right--;
            }
            sb.append(s, right+1, temp_index+1);
            while (left <= right && s.charAt(right) == ' ') {
                right--;
            }
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    public static String reverseWords3(String s) {
//        the sky is   blue
        if (s == null || s.length() == 0) {
            return s;
        }
        int left=0,right=s.length()-1;
        while(left<s.length()&&s.charAt(left)==' ')
            left++;
        while(right>=0&&s.charAt(right)==' '){
            right--;
        }
        StringBuilder sb=new StringBuilder();
        int temp_index;
        while(right>=left){
            temp_index=right;
            while(s.charAt(right)!=' '){
                right--;
            }
            sb.append(s,left,right);
        }

        return "";
    }

}
