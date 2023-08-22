package 代码随想录.字符串.找出字符串中第一个匹配项的下标;

public class KMP {
    public static void main(String[] args) {
//        String haystack = "aabaabaafa";
        String haystack = "aabaabaafaccccccccccccccc";
//        String needle = "aabaaf";
        String needle = "abcdefabcabc";
        System.out.println(strStr(haystack, needle));
    }


    public static int strStr(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len1 < len2)
            return -1;
        int[] next = new int[len2];
        getNext(next, needle);
        int j = 0;
        for (int i = 0; i < len1; i++) {
            while (j >= 1 && needle.charAt(j) != haystack.charAt(i)) {
                j = next[j - 1];
            }
            if (needle.charAt(j) == haystack.charAt(i)) {
                j++;
            }
            if (j == len2) {
                return (i - len2) + 1;
            }
        }
        return -1;
    }

    private static void getNext(int[] next, String s) {
        int j = 0;
        next[0] = j;
        for (int i = 1; i < s.length(); i++) {

            while (j >= 1 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }

            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }

            next[i] = j;
        }
    }


    public static int strStr2(String haystack, String needle) {
        int len1 = haystack.length(), len2 = needle.length();
        if (len2 > len1)
            return -1;
        int[] next = new int[len2];
        getNext2(next, needle);
        int j = 0;
        for (int i = 0; i < len1; i++) {
            while (j >= 1 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == len2)
                return i - len2 + 1;
        }
        return -1;
    }


    private static void getNext2(int[] next, String s) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < s.length(); i++) {
            while (j >= 1 && s.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s.charAt(i) == s.charAt(j)) {
                j++;
            }
            next[i] = j;
        }
    }

}
