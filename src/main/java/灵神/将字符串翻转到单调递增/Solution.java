package 灵神.将字符串翻转到单调递增;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().minFlipsMonoIncr("00110"));
    }

    public int minFlipsMonoIncr(String s) {
        // 一共两种情况，0000.。。，或者000111，只有1的情况属于第二种
        // 如果1的个数大于0，那就不考虑第一种情况了
        int len = s.length();
        int[] count1 = new int[len];// 前缀和，用于记录到i下标有多少个1
        if (s.charAt(0) == '1') {
            count1[0] = 1;
        }
        for (int i = 1; i < len; i++) {
            count1[i] = count1[i - 1];
            if (s.charAt(i) == '1') {
                count1[i]++;
            }
        }
        return fix(s, len - 1, count1);
    }

    private int fix(String s, int right, int[] count1) {
        if (0 == right) {
            return 0;
        }
        int result = 0;
        int index = right;

        while (index >= 0 && s.charAt(index) == '0') {
            result++;
            index--;
        }
        if (index >= 0) {
            while (index >= 0 && s.charAt(index) == '1') {
                index--;
            }
            if (index >= 0) {
                result += fix(s, index, count1);
            }
        }

        result = Math.min(count1[right], result);
        return result;
    }


}
