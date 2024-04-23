package LeetCode_Hot100.螺旋矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{3}};
        System.out.println(new Solution().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int tempDirection = 1;
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        int maxJ = n - 1, maxI = m - 1, minJ = 0, minI = 1;
        while (count < m * n) {
            result.add(matrix[i][j]);
            count++;
            if (tempDirection == 1) {
                j++;
                if(j==maxJ){
                    tempDirection = 2;
                    maxJ--;
                }else if (j > maxJ) {
                    tempDirection = 2;
                    j--;
                    result.remove(result.size()-1);
                    count--;
                }
            } else if (tempDirection == 2) {
                i++;
                if (i == maxI) {
                    tempDirection = 3;
                    maxI--;
                }
            } else if (tempDirection == 3) {
                j--;
                if (j == minJ) {
                    tempDirection = 4;
                    minJ++;
                }
            } else {
                i--;
                if (i == minI) {
                    tempDirection = 1;
                    minI++;
                }
            }
        }
        return result;
    }
}
