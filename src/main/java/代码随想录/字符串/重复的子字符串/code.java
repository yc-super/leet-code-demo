package 代码随想录.字符串.重复的子字符串;

public class code {
    public static void main(String[] args) {
        System.out.println(new code().repeatedSubstringPattern("abab"));
    }
    // abababc abababc
    // 利用KMP，可以发现，如果一个字符串可以由某个字符串组成，那么next数组，会是这样的：000123456
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        int j = 0;
        int[] next = new int[len];
        for (int i = 1; i < len; i++) {
            while (j > 0 && s.charAt(j) != s.charAt(i)) {
                j = next[j - 1];
            }
            if (s.charAt(j) == s.charAt(i)) {
                j++;
            }
            next[i] = j;
        }
        if (next[len - 1] > 0 && next[len - 1] % (len - next[len - 1]) == 0)
            return true;
        return false;
    }

    private int str1Str(String s) {
        int len = s.length();
        int[] next = new int[len];
        getNext(next, s);
        int j = 0;
        String s1 = s + s;
        for (int i = 1; i < len*2; i++) {
            while (j >= 1 && s1.charAt(i) != s.charAt(j)) {
                j = next[j - 1];
            }
            if (s1.charAt(i) == s.charAt(j)) {
                j++;
            }
            if (j == len)
                return i - len + 1;
        }
        return len;
    }

    // abadabaab
    // 001012312
    private void getNext(int[] next, String s2) {
        int j = 0;
        next[0] = 0;
        for (int i = 1; i < next.length; i++) {
            while (j > 0 && s2.charAt(i) != s2.charAt(j)) {
                j = next[j - 1];
            }
            if (s2.charAt(i) == s2.charAt(j))
                j++;
            next[i] = j;
        }
    }
}
