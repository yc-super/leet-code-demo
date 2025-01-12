package LeetCode.字符串的排列;

public class Solution {
    public static void main(String[] args) {
        boolean b = new Solution().checkInclusion("abd", "cba");
        System.out.println(b);
    }

    // abc  yubanbnancab
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length())
            return false;
        int[] array = new int[26];
        boolean[] array2 = new boolean[26];
        int count = s1.length();
        for (char ch : s1.toCharArray()) {
            array[ch - 'a']++;
            array2[ch - 'a'] = true;
        }
        char[] chars = s2.toCharArray();
        int left = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (array[ch - 'a'] == 0) {
                if (array2[ch - 'a']) {
                    // 从left到当前下标，找到和ch相等的下标，并将该下标+1设置为新left，同时处理旧left到新left之间的array的值（都+1）
                    for (int j = left; j < i; j++) {
                        array[chars[j] - 'a']++;
                        count++;
                        if (chars[j] == ch) {
                            left = j + 1;
                            break;
                        }
                    }
                } else {
                    // 处理left 到当前节点的array值
                    for (int j = left; j < i; j++) {
                        array[chars[j] - 'a']++;
                    }
                    left = i + 1;
                    count = s1.length();
                    continue;
                }
            }
            array[ch - 'a']--;
            count--;
            if (count == 0) {
                return true;
            }
            if (count > chars.length - i)
                return false;
        }
        return false;
    }

    // 方法2，滑动窗口
    public boolean checkInclusion2(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        if (m > n)
            return false;
        int[] cnt = new int[26];
        int[] cur = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            cnt[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < m; i++) {
            cur[s2.charAt(i) - 'a']++;
        }
        if (check(cnt, cur)) {
            return true;
        }
        for (int i = m; i < n; i++) {
            cur[s2.charAt(i) - 'a']++;
            cur[s2.charAt(i - m) - 'a']--;
            if (check(cnt, cur)) {
                return true;
            }
        }
        return false;
    }

    private boolean check(int[] cnt, int[] cur) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] != cur[i])
                return false;
        }
        return true;
    }
}
