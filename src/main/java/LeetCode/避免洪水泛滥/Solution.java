package LeetCode.避免洪水泛滥;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] rains = {11, 2, 0, 0, 2, 1};
        System.out.println(new Solution().avoidFlood(rains));
    }

    public int[] avoidFlood(int[] rains) {
        int len = rains.length;
        int[] result = new int[len];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] != 0) {
                if (map.containsKey(rains[i])) {
                    Integer index = map.get(rains[i]);
                    int temp = findZero(index, i, rains);
                    if (temp == -1) {
                        return new int[0];
                    }
                    result[temp] = rains[i];
                    rains[temp] = -1;
                    map.put(rains[i], i);
                } else {
                    map.put(rains[i], i);
                }
                result[i] = -1;
            }
        }
        for (int i = 0; i < len; i++) {
            if (result[i] == 0) {
                result[i] = 1;
            }
        }
        return result;
    }

    private int findZero(Integer index, int i, int[] rains) {
        for (int j = index + 1; j < i; j++) {
            if (rains[j] == 0) {
                return j;
            }
        }
        return -1;
    }

    // 官方题解，主要利用了treeSet的ceiling方法，思路还是哈希+二分查找
    public int[] avoidFlood2(int[] rains) {
        int len = rains.length;
        int[] result = new int[len];
        Arrays.fill(result, 1);
        TreeSet<Integer> set = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (rains[i] == 0) {
                set.add(i);
            } else {
                result[i] = -1;
                if (map.containsKey(rains[i])) {
                    Integer ceiling = set.ceiling(map.get(rains[i]));
                    if (ceiling == null) {
                        return new int[0];
                    } else {
                        result[ceiling] = rains[i];
                        map.put(rains[i], i);
                        set.remove(ceiling);
                    }
                } else {
                    map.put(rains[i], i);
                }
            }
        }
        return result;
    }
}
