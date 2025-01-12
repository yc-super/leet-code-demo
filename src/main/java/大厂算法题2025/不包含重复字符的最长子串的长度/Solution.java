package 大厂算法题2025.不包含重复字符的最长子串的长度;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String str = "abcbbadcba";//4
        int method = new Solution().method(str);
        System.out.println(method);
    }

    // 思路，双指针(或者说滑动窗口也行)，map记录字符和对应的下标，遇到重复的更新left指针
    public int method(String str) {
        int left = 0;
        int result = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(str.charAt(0), 0);
        for (int right = 1; right < str.length(); right++) {
            char c = str.charAt(right);
            if (map.containsKey(c)) {
                Integer i1 = map.get(c);
                // 从map中清除掉left到i1之间的数据，前闭后开
                for (int j = left; j < i1; j++) {
                    map.remove(str.charAt(j));
                }
                // 更新当前重复的元素的下标
                map.put(c,right);
                // 更新left的值
                left = i1 + 1;
            } else {
                map.put(c,right);
                result = Math.max(result, right - left + 1);
            }
        }
        return result;
    }
}
