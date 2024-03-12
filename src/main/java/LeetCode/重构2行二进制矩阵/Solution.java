package LeetCode.重构2行二进制矩阵;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>());
        result.add(new ArrayList<>());
        for (int i = 0; i < colsum.length; i++) {
            if (colsum[i] == 0) {
                result.get(0).add(0);
                result.get(1).add(0);
            } else if (colsum[i] == 2) {
                result.get(0).add(1);
                result.get(1).add(1);
                upper--;
                lower--;
            } else {
                if (upper >= lower) {
                    result.get(0).add(1);
                    result.get(1).add(0);
                    upper--;
                } else {
                    result.get(0).add(0);
                    result.get(1).add(1);
                    lower--;
                }
            }
        }
        if(upper<0||lower<0){
            return new ArrayList<>();
        }
        return result;
    }
}
