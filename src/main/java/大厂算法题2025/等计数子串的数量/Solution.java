package 大厂算法题2025.等计数子串的数量;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        int method = new Solution().method4("aaabcbbcc", 2);
        System.out.println(method);
    }

    // 这种方法只用了2个限制，不能很好地处理遍历过程中某个字母数目已经大于count，因为没有记录各个字母出现的次数
    private int method(String s, int count) {
        if (count > s.length())
            return 0;
//        int len = s.length();
        char[] charArray = s.toCharArray();
        // 前缀和，记录26个字母从0到下标i的数量
//        int[][] array=new int[26][len];
//        array[charArray[0]-'a'][0]=1;
//        for (int i = 1; i < charArray.length; i++) {
//            array[charArray[i]-'a'][i]=array[charArray[i]-'a'][i-1]+1;
//        }

        int result = 0;
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < charArray.length - count + 1; i++) {
            for (int j = i + count - 1; j < charArray.length; j++) {
                if (j == i + count - 1) {
                    set.clear();
                    for (int k = i; k <= j; k++) {
                        set.add(charArray[k]);
                    }
                } else {
                    set.add(charArray[j]);
                }
                // 检查区间是否是count的倍数
                if ((j - i + 1) % count != 0)
                    continue;
                // 检查字母种类乘以count是否等于区间
                if (set.size() * count != (j - i + 1))
                    continue;
                result++;
            }
        }
        return result;
    }

    // 记录了各个字母出现的次数,可以处理遍历过程中某个字母数目已经大于count。但是时间复杂度为O(n2)
    public int method3(String s, int count) {
        if (s.length() < count)
            return 0;
        int[] array = new int[26];// 记录各个小写字母出现的次数
        int num = 0;// 记录区间内小写字母的种类数
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
//            if(i!=0){
//                char c = s.charAt(i);
//                array[c-'a']--;
//                if(array[c-'a']==0)
//                    num--;
//
//            }
            num = 0;
            Arrays.fill(array, 0);
            for (int j = i; j < s.length(); j++) {
                char c = s.charAt(j);
                if (array[c - 'a'] == 0) {
                    num++;
                }
                if (array[c - 'a'] == count) {
                    break;
                }
                array[c - 'a']++;
                if ((j - i + 1) % count != 0)
                    continue;
                if (num * count == (j - i + 1))
                    result++;
            }
        }
        return result;
    }

    //题解方法，滑动窗口，遍历的同时记录出现的次数，同时进行左指针右移
    public int equalCountSubstrings(String s, int count) {
        int n = s.length();
        if (n < count) {
            return 0;
        }
        int ans = 0;
        // 等计数子串的长度为count的整数倍，有多少不同的字母，其长度就是count的多少倍
        // 最多有26种字母，所以长度最多为count的26倍
        for (int i = 1; i * count <= n && i <= 26; i++) {
            int len = i * count;
            int left = 0;
            int right = 0;
            // 记录窗口内各种字母的数量
            int[] window = new int[26];
            // 记录窗口内 字母种类 的数量
            int valid = 0;
            while (right < n) {
                if (window[s.charAt(right) - 'a'] == 0) {
                    valid++;
                }
                window[s.charAt(right) - 'a']++;
                // 如果滑动窗口内的某个字母数量超过count，则此窗口已经不符合要求，左指针右移
                while (window[s.charAt(right) - 'a'] > count) {
                    window[s.charAt(left) - 'a']--;
                    if (window[s.charAt(left) - 'a'] == 0) {
                        valid--;
                    }
                    left++;
                }
                // 窗口长度为i * count时，检查其字母种类数是否为i
                if (right - left + 1 == len) {
                    if (valid == i) {
                        ans++;
                    }
                    window[s.charAt(left) - 'a']--;
                    if (window[s.charAt(left) - 'a'] == 0) {
                        valid--;
                    }
                    left++;
                }
                right++;
            }
        }
        return ans;
    }

    // 看了题解做出来的
    public int method4(String s, int count) {
        if (s.length() < count)
            return 0;
        int len = s.length();
        int result = 0;// 最终结果
        // i的含义：不同字符个数。那么最长的子串长度即为 不同字符个数*count，不同字符最多有26个
        for (int i = 1; i * count <= len && i <= 26; i++) {
            int left = 0;
            int right = 0;
            int[] array = new int[26];// 记录各个字符出现的次数，滑动窗口
            int num = 0;// 记录有多少个不同字符
            while (right < len) {
                char c = s.charAt(right);
                if (array[c - 'a'] == 0) {// 如果第一次出现，则不同字符个数+1
                    num++;
                }
                array[c - 'a']++;// 该字母个数+1
                while (array[c - 'a'] > count) {// 如果新出现的字母个数大于count，则当前子串不符合要求，那么左指针就要右移。
                    // 循环直到右指针所在字符个数小于等于count
                    char c1 = s.charAt(left);
                    array[c1 - 'a']--;// 右移之前需要把左指针所在字符出现个数-1
                    if (array[c1 - 'a'] == 0)// 如果变为0，那么不同字符个数要-1
                        num--;
                    left++;
                }
                if (right - left + 1 == i * count) {// 如果区间大小刚好等于 不同字符个数*count，那么检查下是否满足要求
                    if (num == i) {// 实际不同字符个数=期待的不同字符个数
                        result++;
                    }
                    // 左指针右移
                    char c1 = s.charAt(left);
                    array[c1 - 'a']--;// 右移之前需要把左指针所在字符出现个数-1
                    if (array[c1 - 'a'] == 0)// 如果变为0，那么不同字符个数要-1
                        num--;
                    left++;
                }
                right++;
            }
        }
        return result;
    }

}
