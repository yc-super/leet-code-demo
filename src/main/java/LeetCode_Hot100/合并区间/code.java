package LeetCode_Hot100.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class code {
    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{7,18}};
//        int[][] intervals = {{0,0},{0,0}};
//        int[][] intervals = {{1,3},{8,10},{15,18},{2,6}};
//        int[][] intervals = {{1,10},{2,6},{8,10},{15,18}};
        //[[1,6],[8,10],[15,18]]
        int[][] merge = new code().merge(intervals);
        for(int[] in:merge){
            for(int i:in) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        //排序
        Arrays.sort(intervals, (o1, o2) -> o1[0]-o2[0]);
        List<int[]> merged =new ArrayList<>();
        for(int i = 0; i < intervals.length; ++i) {
            int L = intervals[i][0], R = intervals[i][1];
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < L) {
                merged.add(new int[]{L, R});
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], R);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

}
