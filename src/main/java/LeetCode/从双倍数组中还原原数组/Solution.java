package LeetCode.从双倍数组中还原原数组;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] changed = {4,0,3,0};
        int[] originalArray = new Solution().findOriginalArray(changed);
        System.out.println();
    }
/*
* 1,2,3,4,6,8
* */
    public int[] findOriginalArray(int[] changed) {
        Arrays.sort(changed);
        int length = changed.length;
        if (length % 2 != 0)
            return new int[0];
        int[] result = new int[length / 2];
        Arrays.fill(result, -1);
        int rightIndex = 1;
        int index = 0;
        for (int i = 0; i < length; i++) {
            if (changed[i] == -1)
                continue;
            if (i == rightIndex)
                rightIndex++;
            boolean flag=false;
            for (int j = rightIndex; j < length; j++) {
                if (changed[j] == 2 * changed[i]) {
                    result[index++] = changed[i];
                    changed[j] = -1;
                    rightIndex = j + 1;
                    flag=true;
                    break;
                }else if(changed[j] > 2 * changed[i]){
                    return new int[0];
                }
            }
            if(!flag)
                return new int[0];
        }
        return result;
    }
}
