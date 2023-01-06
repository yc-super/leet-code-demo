package LeetCode.数组乘积中的不同质因数数目;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[] nums={310,126,540,780,809,917,514,547,217,930,299,723,801,827,4,506,711,646,792,904,92,378,861,995,765,896,85,429,288,111,744,216,163,805,891,109,91,625,454,588,688,606,866,5,558,487,854,274,390,469,511,579,692,514,433,20,79,60,456,876,366,958,445,304,930,832,142,123,761,325,698,227,265,839,125,420,207,583,715,202,799,664,990,915,677,356,349,734,117,56,774,894,666,360,372,844,995,275,95,560,761,585,515,190,190,950,832,336,218,577,674,309,157,719,677,457,430,763,421,692,191,604,351,953,814,305,548,255,532,453,201,814,169,501,745,360,617,734,287,429,417,287,250,794,775,182,905,791,229,482,491,944,749,429,305,116,78,733,163,933,159,390,808,882,625,33,41,993,100,180,302,191,438,623,366,309,736,573,285,146,22,689,674,800,134,644,135,163,28,342,994,484,600,149,689,290,88,555,735,406,337,214,491,189,465,143,612,766,428,157,495,100,353,694,983,302,262,659,151,217,213,13,792,998,802,694,783,445,504,365,172,385,81,923,210,96,806,751,768,848,527,994,760,331,773,777,956};
                System.out.println(new Solution().distinctPrimeFactors(nums));

    }
    public int distinctPrimeFactors(int[] nums) {
        int sum = 1;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (isValid(nums[i])) {
                set.add(nums[i]);
            } else {
                sum = nums[i];
                int num = 2;
                while (!isValid(sum) && sum != 1&&num<=sum/2) {
                    if (sum % num == 0) {
                        set.add(num);
                        while (sum % num == 0) {
                            sum /= num;
                        }
                    }
                    num = nextVal(num);
                }
                if (sum != 1)
                    set.add(sum);
            }
        }


        return set.size();
    }

    private boolean isValid(int num) {
        if (num == 1)
            return false;
        int n = num / 2;
        for (int i = 2; i <= n; i++) {
            if (num % i == 0)
                return false;
        }
        return true;
    }

    private int nextVal(int num) {
        num++;
        while (!isValid(num)) {
            num++;
        }
        return num;
    }
}
