package 剑指offer.位1的个数;

public class Solution {

    public int hammingWeight(int n) {
        int b=n;
        if (n < 0) {
            b = Integer.MAX_VALUE + n + 1;
        }
        int res = 0;
        while (b != 0) {
            if (b % 2 == 1)
                res++;
            b /= 2;
        }

        return n < 0 ? res + 1 : res;
    }

    // 把n当做无符号数，右移一位
    public int hammingWeight2(int n) {
        int res=0;
        while (n!=0){
            res+=n&1;
            n>>>=1;
        }
        return res;
    }
}
