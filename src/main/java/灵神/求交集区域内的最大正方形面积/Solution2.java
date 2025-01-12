package 灵神.求交集区域内的最大正方形面积;

public class Solution2 {
    // 灵神的题解，不用分类考虑
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
       /*  相交的矩形：
       左下角横坐标：两个矩形左下角横坐标的最大值
       左下角纵坐标：两个矩形左下角纵坐标的最大值
       右上角横坐标：两个矩形右上角横坐标的最小值
       右上角纵坐标：两个矩形右上角纵坐标的最小值
        */
        long result = 0l;
        for (int i = 0; i < bottomLeft.length; i++) {
            int[] b1 = bottomLeft[i];
            int[] t1 = topRight[i];
            for (int j = i + 1; j < bottomLeft.length; j++) {
                int[] b2 = bottomLeft[j];
                int[] t2 = topRight[j];
                int a = Math.min(t1[0], t2[0]) - Math.max(b1[0], b2[0]);
                int b = Math.min(t1[1], t2[1]) - Math.max(b1[1], b2[1]);
                long temp = Math.min(a, b);
                if (temp > 0) {
                    result = Math.max(result, temp * temp);
                }
            }
        }
        return result;
    }
}
