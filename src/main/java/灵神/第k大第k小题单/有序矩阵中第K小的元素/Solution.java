package 灵神.第k大第k小题单.有序矩阵中第K小的元素;

import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return matrix[o1[0]][o1[1]]-matrix[o2[0]][o2[1]];
            }
        });
        int result=0;
        int count=0;

        priorityQueue.add(new int[]{0,0});

        while (count<k){
            int[] poll = priorityQueue.poll();
            int i=poll[0];
            int j=poll[1];
            count++;
            result=matrix[i][j];

            if(i==0&&j<matrix[0].length-1){
                priorityQueue.add(new int[]{i,j+1});
            }

            if(i<matrix.length-1){
                priorityQueue.add(new int[]{i+1,j});
            }
        }
        return result;
    }
}
