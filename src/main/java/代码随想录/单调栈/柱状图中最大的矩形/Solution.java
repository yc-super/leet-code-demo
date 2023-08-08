package 代码随想录.单调栈.柱状图中最大的矩形;

public class Solution {
    public static void main(String[] args) {
        int[] heights={2,1,5,6,2,3};
        System.out.println(new Solution().largestRectangleArea(heights));
    }
    //第一想到的是暴力遍历，O(n2)
    //果然超时了
    //优化了下也还是不行，看来O(n2)时间复杂度是不行的
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        int len = heights.length;
        for (int i = 0; i < len; i++) {
            result = Math.max(result, heights[i]);
        }
        int min;
        for (int i = 0; i < len - 1; i++) {
            min = heights[i];
            for (int j = i + 1; j < len; j++) {
                if (heights[j] >= min) {
                    int temp = j;
                    while (temp < len && heights[temp] >= min) {
                        temp++;
                    }
                    temp--;
                    result = Math.max(result, (temp - i + 1) * min);
                    j =  temp;
                } else {
                    min = heights[j];
                    result = Math.max(result, (j - i + 1) * min);
                }
            }
        }
        return result;
    }
}
