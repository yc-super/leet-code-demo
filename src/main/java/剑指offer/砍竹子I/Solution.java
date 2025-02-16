package 剑指offer.砍竹子I;

/*
* 动态规划
* */
public class Solution {
    public int cuttingBamboo(int bamboo_len) {
        int[] bp = new int[bamboo_len + 1];
        bp[1] = 1;
        bp[2] = 1;
        for (int i = 3; i <= bamboo_len; i++) {
            for (int j = 1; j <= i / 2; j++) {
                bp[i] = Math.max(bp[i], Math.max(bp[j], j) * Math.max(bp[i - j], i - j));
            }
        }
        return bp[bamboo_len];
    }
}
