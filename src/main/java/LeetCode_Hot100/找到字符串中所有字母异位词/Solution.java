package LeetCode_Hot100.找到字符串中所有字母异位词;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "beeaaedcbc", p = "c";
        List<Integer> anagrams = new Solution().findAnagrams(s, p);
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
        boolean[] check = new boolean[len1+1];
        Map<Character, Integer> map = new HashMap<>();
        for (char ch : pArray) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i <= len1 - len2; i++) {
            if (check[i]) {
                if (sArray[i - 1] == sArray[i + len2 - 1]) {
                    result.add(i);
                    check[i + 1] = true;
                }
            } else {
                if (i>0&&sArray[i - 1] == sArray[i + len2 - 1]) {
                    continue;
                }
                HashMap<Character, Integer> m2 = new HashMap<>(map);
                boolean flag = true;
                for (int j = i; j < i + len2; j++) {
                    if (!m2.containsKey(sArray[j])) {
                        flag = false;
                        break;
                    } else {
                        if (m2.get(sArray[j]) == 0) {
                            flag = false;
                            break;
                        }
                        m2.put(sArray[j], m2.get(sArray[j]) - 1);
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
