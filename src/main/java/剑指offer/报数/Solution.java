package 剑指offer.报数;

public class Solution {
    public int[] countNumbers(int cnt) {
        int n = cnt;
        int max = 1;
        while (n != 0) {
            max *= 10;
            n--;
        }
        max--;
        int[] res = new int[max];
        for (int i = 0; i < max; i++) {
            res[i] = i + 1;
        }
        return res;
    }
}
