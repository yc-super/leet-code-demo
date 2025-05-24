package 宫水三叶.游戏中弱角色的数量;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        int[][] properties={{1,10},{1,3},{2,8},{2,3},{2,6},{3,10},{3,2}};
        int[][] properties={{7,9},{10,7},{6,9},{10,4},{7,5},{7,10}};
        int i = new Solution().numberOfWeakCharacters(properties);
        System.out.println(i);
    }
    public int numberOfWeakCharacters(int[][] properties) {
        Arrays.sort(properties, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int max = 0;
        int currentMax = 0;
        int count = 0;
        int i = properties.length - 1;
        while (i >= 0 && properties[i][0] == properties[properties.length - 1][0]) {
            currentMax = Math.max(currentMax, properties[i][1]);
            i--;
        }
        max = Math.max(max, currentMax);
        while (i >= 0) {
            currentMax = 0;
            int j = i;
            while (i >= 0 && properties[i][0] == properties[j][0]) {
                currentMax = Math.max(currentMax, properties[i][1]);
                if (properties[i][1] < max) {
                    count++;
                }
                i--;
            }
            max=Math.max(max,currentMax);
        }
        return count;
    }
}
