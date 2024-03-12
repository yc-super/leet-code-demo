package LeetCode_Hot100.找到字符串中所有字母异位词;

import java.util.*;

public class Solution2 {
    public static void main(String[] args) {
        String s = "abab", p = "ab";
        List<Integer> anagrams = new Solution2().findAnagrams(s, p);
        System.out.println();
    }

    //s = "cbaebabacd", p = "abc"
    public List<Integer> findAnagrams(String s, String p) {
        int len1 = s.length();
        int len2 = p.length();
        List<Integer> result = new ArrayList<>();
        if (len2 > len1) {
            return result;
        }
        char[] sArray = s.toCharArray();
        char[] pArray = p.toCharArray();
        boolean[] check = new boolean[len1 + 1];
        int[] array = new int[26];
        for (char ch : pArray) {
            array[ch - 'a']++;
        }
        int[] tempArray = new int[26];
        for (int i = 0; i < len2; i++) {
            tempArray[sArray[i] - 'a']++;
        }
        for (int i = 0; i <= len1 - len2; i++) {
            if (i > 0) {
                tempArray[sArray[i - 1] - 'a']--;
                tempArray[sArray[i + len2 - 1] - 'a']++;
            }
            if (check[i]) {
                if (sArray[i - 1] == sArray[i + len2 - 1]) {
                    result.add(i);
                    check[i + 1] = true;
                }
            } else {
                if (i > 0 && sArray[i - 1] == sArray[i + len2 - 1]) {
                    continue;
                }
                boolean flag = true;

                for (int j = 0; j < array.length; j++) {
                    if (array[j] != tempArray[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.add(i);
                    check[i + 1] = true;
                }
            }
        }
        return result;
    }
}
