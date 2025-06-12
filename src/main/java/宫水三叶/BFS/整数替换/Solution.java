package 宫水三叶.BFS.整数替换;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().integerReplacement(Integer.MAX_VALUE));
    }


    // 三叶姐的题解，相较于我的bfs，加了一个hashmap用于存储已经计算过的数值，另外，我下面写的bfs，实际是dfs
    // dfs
    Map<Long, Integer> map;

    public int integerReplacementDFS(int n) {
        map = new HashMap<>();
        return myDfs(n * 1L);
    }

    private int myDfs(long n) {
        if (n == 1)
            return 0;
        if (map.containsKey(n))
            return map.get(n);
        int ans = (n & 1) == 0 ? myDfs(n >> 1) + 1 : Math.min(myDfs(n - 1), myDfs(n + 1)) + 1;
        map.put(n, ans);
        return ans;
    }

     /*三叶姐的题解，贪心
     * 在n为偶数时，没什么复杂的
     * 在n为奇数时，最低位必定是1，此时看次低位是1还是0，如果是1，优先+1，如果是0，优先-1
     * 当然当n为3时比较特殊，次低位是1，但优先-1
     *
     * */

    public int integerReplacementBFS(int n){
        return 1;
    }


    /*
    我的题解，动态规划，会超出内存限制
     * bp[i]:表示i转成1需要的步数
     * bp[i]为偶数时，bp[i]=bp[i/2]+1，为奇数时，bp[i]=min(bp[i-1]+1,bp[(i+1)/2]+1);
     * */
    public int integerReplacementxx(int n) {
        if (n == Integer.MAX_VALUE) {
            n--;
        }
        int[] bp = new int[n + 1];
        bp[1] = 0;
        bp[2] = 1;
        for (int i = 2; i <= n; i++) {
            if ((i & 1) == 0) {
                bp[i] = bp[i >> 1] + 1;
            } else {
                bp[i] = Math.min(bp[i - 1], bp[(i + 1) / 2] + 1) + 1;
            }
        }
        return bp[n];
    }

    // 我自己的解法，回溯法。其中bfs(n - 1)和bfs(n + 1)会有很多重复，可以考虑使用动态规划
    public int integerReplacement22(int n) {
        if (n == Integer.MAX_VALUE) {
            n--;
        }
        return bfs(n);
    }

    private int bfs(int n) {
        if (n == 1) {
            return 0;
        }
        if ((n & 1) == 0) {
            n >>= 1;
            return bfs(n) + 1;
        } else {
            return Math.min(bfs(n - 1) + 1, bfs(n + 1) + 1);
        }
    }
}
