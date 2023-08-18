package 代码随想录.字符串.找出字符串中第一个匹配项的下标;

public class code {
    public static void main(String[] args) {
        System.out.println(new code().strStr("abcd","cd"));
    }
    public int strStr(String haystack, String needle) {
        int len1 = haystack.length();
        int len2 = needle.length();
        if (len2 > len1)
            return -1;
        int index ,temp;
        for (int i = 0; i <= len1 - len2; i++) {
            index = 0;
            temp=i;
            while (index < len2 && haystack.charAt(temp) == needle.charAt(index)) {
                temp++;
                index++;
            }
            if(index==len2)
                return i;
        }
        return -1;
    }
}
