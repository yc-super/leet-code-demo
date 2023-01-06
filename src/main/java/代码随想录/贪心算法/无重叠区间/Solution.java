package 代码随想录.贪心算法.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public static void main(String[] args) {
//        int[][] intervals=new int[][]{{1,2},{2,3},{3,4},{1,3}};
//        int[][] intervals=new int[][]{{1,2},{1,2},{1,2}};
        int[][] intervals=new int[][]{{0,2},{1,3},{1,3},{2,4},{3,5},{3,5},{4,6}};
        System.out.println(new Solution().eraseOverlapIntervals3(intervals));
    }

    //思路2：dp。思路是对的，但是需要优化，测试用例超时了
    public int eraseOverlapIntervals2(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int length=intervals.length;
        int[] temp=new int[length];
        for (int i = length-1; i >=0; i--) {
            int max=0;
            for (int j = i+1; j < length; j++) {
                if(intervals[i][1]<=intervals[j][0]){
                    max=Math.max(max,temp[j]);
                }
            }
            temp[i]=max+1;
        }
        int max=1;
        for (int i = 0; i < length; i++) {
            max=Math.max(max,temp[i]);
        }
        return length-max;
    }

    //代码随想录，按照右边界排序，然后不断选择右边界较小的（这样右边剩下的空间比较大，有更多选择）
    public int eraseOverlapIntervals3(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        int count=1;
        int preRight=intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>=preRight){
                count++;
                preRight=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}
