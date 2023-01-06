package 代码随想录.贪心算法.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    //自己写的，贪心算法还真是常识啊。这道题贪心在一直更新共同区间，如果到了某个下标，没有共同区间了，那么count++，共同区间初始化为该下标对应的区间。
    //看了代码随想录，可以优化下，只要不断更新右边界就行了。
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });
        int start=points[0][0];
        int end=points[0][1];
        int count=0;
        for (int i = 1; i < points.length; i++) {
            if(points[i][0]<=end&&points[i][1]>=start){
                start=Math.max(start,points[i][0]);
                end=Math.min(end,points[i][1]);
            }else{
                count++;
                start=points[i][0];
                end=points[i][1];
            }
        }
        return ++count;
    }
}
