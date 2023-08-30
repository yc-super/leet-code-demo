package LeetCode.插入区间;

public class Solution {
    /*
    * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
*
* 1,2  3,6  8,12    14,20     6,14  -3,-1
    * */
    public static void main(String[] args) {
//        int[][] intervals = {{3, 6}, {8, 10}, {14, 19}};
//        int[] newInterval = {20, 23};
        int[][] intervals = {{1,5}};
        int[] newInterval = {2,3};
        int[][] insert = new Solution().insert(intervals, newInterval);
        System.out.println();
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int len = intervals.length;
        int[][] newArray = new int[len + 1][2];
        int index = 0;
        int i;
        for (i = 0; i <= len; i++) {
            if (index < len && intervals[index][0] <= newInterval[0]) {
                newArray[i][0] = intervals[index][0];
                newArray[i][1] = intervals[index][1];
                index++;
            } else {
                break;
            }
        }
        int left = i, right = i;
        newArray[i][0] = newInterval[0];
        newArray[i][1] = newInterval[1];
        i++;
        while (i != len + 1) {
            newArray[i][0] = intervals[index][0];
            newArray[i][1] = intervals[index][1];
            index++;
            i++;
        }
        while (left >= 0 && newInterval[0] <= newArray[left][1]) {
            left--;
        }
        while (right < len + 1 && newInterval[1] >= newArray[right][0]) {
            right++;
        }
        //把left+1,right-1区间内合并
        i = 0;

        int[][] result = new int[len + 1 - (right - left - 1) + 1][2];
        int j;
        for (j = 0; j <= left; j++) {
            result[j][0] = newArray[i][0];
            result[j][1] = newArray[i][1];
            i++;
        }
        result[j][0] = newArray[left + 1][0];
        result[j][1] = Math.max(newArray[right - 1][1], newInterval[1]);
        if(right-2>=0){
            result[j][1] = Math.max(result[j][1],newArray[right - 2][1]);
        }
        j++;
        for (; j < result.length; j++) {
            result[j][0] = newArray[right][0];
            result[j][1] = newArray[right][1];
            right++;
        }
        return result;
    }
}
