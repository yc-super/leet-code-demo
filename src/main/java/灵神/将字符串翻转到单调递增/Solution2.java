package 灵神.将字符串翻转到单调递增;

public class Solution2 {
    public static void main(String[] args) {
        int i=new Solution2().minFlipsMonoIncr("1111");
        System.out.println(i);
    }

    // 三叶的题解，只有3种情况，00000,11111,00.。。11，找到分割点，分割点左边都是0，右边都是1，
    // 那么问题的答案就是所有分割点左边1的个数加右边0的个数中的最小值
    // 左边1的个数、右边0的个数，可以利用前缀和优化
    public int minFlipsMonoIncr(String s) {
        int len = s.length();
        int result = len;
        int[] count = new int[len + 1];
        for (int i = 1; i <= len; i++) {
            count[i] = count[i - 1];
            if (s.charAt(i - 1) == '1')
                count[i]++;
        }
        for (int i = 1; i <= len; i++) {
            int l = count[i-1] + len - i - (count[len] - count[i]);
            result = Math.min(result, l);
        }
        return result;
    }
}
