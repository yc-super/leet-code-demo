package 代码随想录.双指针法专练.颠倒字符串中的单词;
//力扣 151. 颠倒字符串中的单词
/*
* 示例：
* 输入：s = "the sky is blue"
输出："blue is sky the"
* */
public class Solution {
    public static void main(String[] args) {
        String s = "    the";
        System.out.println(reverseWords(s));
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
}
