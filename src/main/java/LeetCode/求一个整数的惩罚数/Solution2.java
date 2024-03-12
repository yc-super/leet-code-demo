package LeetCode.求一个整数的惩罚数;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution2 {
    public static void main(String[] args) {
        int i = new Solution2().punishmentNumber(1000);
        System.out.println();
    }

    public int punishmentNumber(int n) {
        int result = 0;
        Map<Integer, Set<Integer>> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        set.add(0);
        map.put(0, set);
        for (int i = 1; i <= n; i++) {
            int aa = i * i;
            Set<Integer> set2 = map.get(aa);
            if (set2 == null) {
                getMap2(aa, map);
                set2 = map.get(aa);
            }
            for (Integer b : set2) {
                if (b == i) {
                    result += aa;
                    break;
                }
            }

        }
        return result;
    }
    //36    1296
    //1297,1000000

    private void getMap2(int aa, Map<Integer, Set<Integer>> map) {
        int temp = aa;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }
//        String target = aa + "";
        Set<Integer> set = new HashSet<>();
        set.add(aa);
        for (int j = 0; j < count - 1; j++) {
//            String s1 = target.substring(0, j + 1);
//            String s2 = target.substring(j + 1);
//            Integer a1 = Integer.valueOf(s1);
//            Integer a2 = Integer.valueOf(s2);

            int jj=j;
            temp=1;
            while(jj>=0) {
                temp*=10;
                jj--;
            }
            Integer a1=aa%temp;
            Integer a2=aa-a1;

            Set<Integer> set1 = map.get(a1);
            Set<Integer> set2 = map.get(a2);
            if (set1 == null) {
                getMap2(a1, map);
                set1 = map.get(a1);
            }
            if (set2 == null) {
                getMap2(a2, map);
                set2 = map.get(a2);
            }
            for (Integer b1 : set1) {
                for (Integer b2 : set2) {
                    set.add(b1 + b2);
                }
            }
        }
        map.put(aa, set);
    }

    /*
     * 1 1
     * 2 4
     * 3 9
     * 4 16  1+6/16
     *
     * */
}
