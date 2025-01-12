package 灵神.构成交替字符串需要的最小交换次数;

public class Solution {

    // 我这里还考虑了奇数、偶数，实际上，交替字符串一定是0101.。。或者是1010.。。，直接拿s和这两种比较一下取小值就行了
    public int minSwaps(String s) {
        int len = s.length();
        int count0 = 0, count1 = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '0') {
                count0++;
            } else {
                count1++;
            }
        }
        if (len % 2 == 0) {
            if (count0 != count1)
                return -1;
            int count = 0;
            for (int i = 0; i < len; i += 2) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }

            if (count > len / 4) {
                return len / 2 - count;
            } else {
                return count;
            }
        } else {
            if (Math.abs(count0 - count1) > 1)
                return -1;
            int count = 0;

            for (int i = 0; i < len; i += 2) {
                if (s.charAt(i) == '0') {
                    count++;
                }
            }

            if (count0 > count1) {
                return (len + 1) / 2 - count;
            } else {
                return count;
            }
        }
    }
}
