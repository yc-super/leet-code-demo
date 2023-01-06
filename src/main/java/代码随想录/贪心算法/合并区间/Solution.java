package 代码随想录.贪心算法.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==1)
            return intervals;
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int beginIndex=0;
        int maxRight=intervals[0][1];
        List<int[]> list=new ArrayList<>();
        int index=1;
        while(index<intervals.length){
            while (index<intervals.length&&intervals[index][0]<=maxRight){
                maxRight=Math.max(maxRight,intervals[index][1]);
                index++;
            }
            list.add(new int[]{intervals[beginIndex][0],maxRight});
            beginIndex=index;
            if(index<intervals.length)
                maxRight=intervals[beginIndex][1];
        }
        return list.toArray(new int[][]{});
    }
}
