package 代码随想录.贪心算法.划分字母区间;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(new Solution().partitionLabels2(s));
    }

    //自己想的，模拟找圈的过程，比较冗余拉杂
    public List<Integer> partitionLabels(String s) {
        //ababcbaca defegde hijhklij
        List<Integer> list = new ArrayList<>();
        Set<Character> set = new HashSet<>();
        int beginIndex = 0;
        set.add(s.charAt(0));

        int count = set.size() - 1;
        int rightIndex = s.length() - 1;
        int tempRight = 0;
        while (tempRight < s.length()) {
            while (count != set.size()) {
                count = set.size();
                rightIndex = s.length() - 1;
                while (!set.contains(s.charAt(rightIndex))) {
                    rightIndex--;
                }
                if (tempRight == rightIndex) {
                    break;
                } else {
                    for (int i = tempRight; i <= rightIndex; i++) {
                        set.add(s.charAt(i));
                    }
                }
                tempRight = rightIndex;
            }
            list.add(rightIndex - beginIndex + 1);
            if (rightIndex + 1 >= s.length())
                break;
            beginIndex = rightIndex + 1;
            tempRight = beginIndex;
            set.clear();
            set.add(s.charAt(beginIndex));
            count = -1;
        }

        return list;
    }

    //代码随想录，利用了字典。这道题目不是贪心，而是像dp，不断更新需要到达的最远下标，知道打到了最远下标。以后遇到字母相关可以想一下字典。
    public List<Integer> partitionLabels2(String S) {
        List<Integer> list = new LinkedList<>();
        int[] edge = new int[26];
        char[] chars = S.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i] - 'a'] = i;
        }
        int idx = 0;
        int last = -1;
        for (int i = 0; i < chars.length; i++) {
            idx = Math.max(idx, edge[chars[i] - 'a']);
            if (i == idx) {
                list.add(i - last);
                last = i;
            }
        }
        return list;
    }
}
