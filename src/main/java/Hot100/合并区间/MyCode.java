package Hot100.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//对第一个元素排序，后面就好处理了
public class MyCode {
    public static void main(String[] args) {
//        int[][] intervals = {{1,3},{2,6},{8,10},{7,18}};
        int[][] intervals = {{0,0},{0,0}};
//        int[][] intervals = {{1,3},{8,10},{15,18},{2,6}};
//        int[][] intervals = {{1,10},{2,6},{8,10},{15,18}};
        //[[1,6],[8,10],[15,18]]
        int[][] merge = new MyCode().merge(intervals);
        for(int[] in:merge){
            for(int i:in) {
                System.out.print(i+",");
            }
            System.out.println();
        }
    }
    public int[][] merge(int[][] intervals) {
        quickSort(intervals,0,intervals.length-1);
        List<List<Integer>> lists=new ArrayList<>();
        List<Integer> list=new ArrayList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        lists.add(list);
        for (int i = 1; i < intervals.length; i++) {
            if(intervals[i][0]>lists.get(lists.size()-1).get(1)){
                List<Integer> list1=new ArrayList<>();
                list1.add(intervals[i][0]);
                list1.add(intervals[i][1]);
                lists.add(list1);
            }else{
                Integer i1 = lists.get(lists.size() - 1).get(1);
                Integer i2 = intervals[i][1];
                if(i1<i2) {
                    lists.get(lists.size() - 1).remove(1);
                    lists.get(lists.size() - 1).add(i2);
                }
            }
        }
        int[][] result=new int[lists.size()][2];
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < 2; j++) {
                result[i][j]=lists.get(i).get(j);
            }
        }

        return result;
    }

    private void quickSort(int[][] intervals,int left,int right) {
        if(left>=right)
            return;
        int l=left;
        int r=right;
        int[] temp=intervals[l];
        while(l<r){
            while(l<r&&intervals[r][0]>=temp[0])
                r--;
            intervals[l]=new int[]{intervals[r][0],intervals[r][1]};
            while(l<r&&intervals[l][0]<=temp[0]){
                l++;
            }
            intervals[r--]=new int[]{intervals[l][0],intervals[l][1]};
        }
        intervals[l]=new int[]{temp[0],temp[1]};
        quickSort(intervals,left,l-1);
        quickSort(intervals,l+1,right);

    }

}
