package 剑指offer.丑数;

import java.util.HashSet;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        int i = new Solution().nthUglyNumber(10);
        System.out.println(i);
    }

    // 题解，多路归并
    /*
     * 1是第一个丑数，接下来的丑数，将从当前丑数开始，乘以2、3、5，得到的3个数组中得到。需要维护3个下标值
     * 1*2   2*2 3*2 4*2
     * 1*3   2*3 3*3 4*3
     * 1*5   2*5 3*5 4*5
     * */
    public int nthUglyNumber3(int n) {
        if (n == 1)
            return 1;
        int a = 1, b = 1, c = 1;
        int[] aa = new int[1690];
        int[] bb = new int[1690];
        int[] cc = new int[1690];
        int num = 1;
        int index = 1;
        while (index < n) {
            aa[index] = 2 * num;
            bb[index] = 3 * num;
            cc[index] = 5 * num;
            index++;
            num = Math.min(aa[a], Math.min(bb[b], cc[c]));
            if (num == aa[a])
                a++;
            if (num == bb[b])
                b++;
            if (num == cc[c])
                c++;
        }
        return num;
    }

    // 题解，小顶堆，效率一般
    public int nthUglyNumber2(int n) {
        PriorityQueue<Long> queue = new PriorityQueue<>();
        HashSet<Long> set = new HashSet<>();
        queue.add(1L);
        int[] nums = {2, 3, 5};
        for (int i = 1; i <= n; i++) {
            long poll = queue.poll();
            if (i == n)
                return (int) poll;
            for (int num : nums) {
                long x = num * poll;
                if (!set.contains(x)) {
                    set.add(x);
                    queue.add(x);
                }
            }
        }
        return -1;
    }

    // 直接判断一个数是不是丑数，行不通，效率太低，超出时间限制
    public int nthUglyNumber(int n) {
        int num;
        int a = 1;
        for (int i = 1; i < n; i++) {
            num = a + 1;
            a = getNextUgNum(num);
        }
        return a;
    }

    private int getNextUgNum(int num) {
        while (true) {
            boolean b = ifUgNum(num);
            if (b)
                return num;
            num++;
        }
    }

    // 1, 2, 3, 4, 5, 6, 8, 9, 10, 12, 15, 16, 18, 20, 24, 25
    private boolean ifUgNum(int num) {
        if (num % 2 != 0 && num % 3 != 0 && num % 5 != 0)
            return false;
        int a = 1;
        while (num != 1) {
            a++;
            while (num % a == 0) {
                num /= a;
            }
            if (a > 5)
                return false;
        }
        return true;
    }
}
