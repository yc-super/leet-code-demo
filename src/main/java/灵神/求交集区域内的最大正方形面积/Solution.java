package 灵神.求交集区域内的最大正方形面积;

public class Solution {
    public static void main(String[] args) {
        int[][] bottomLeft = {{1, 1}, {2, 7}, {4, 3}};
        int[][] topRight = {{5, 10}, {3, 9}, {8, 9}};
        System.out.println(new Solution().largestSquareArea(bottomLeft, topRight));
    }

    // 测试用例[[2,1],[4,15],[17,6],[19,5]]
    // [[3,17],[10,23],[23,11],[22,13]]
    // 没通过\
    // 不知道哪里错了
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int result = 0;
        int a, b;
        for (int i = 0; i < bottomLeft.length; i++) {
            for (int j = 0; j < bottomLeft.length; j++) {
                if (i == j)
                    continue;
                if (bottomLeft[j][0] < bottomLeft[i][0])
                    continue;
                if (bottomLeft[j][0] >= topRight[i][0])
                    continue;
                // 交集有3*2种情况
                if (bottomLeft[j][1] >= bottomLeft[i][1] && bottomLeft[j][1] < topRight[i][1]) {
                    if (topRight[j][0] >= topRight[i][0]) {
                        a = topRight[i][0] - bottomLeft[j][0];
                    } else {
                        a = topRight[j][0] - bottomLeft[j][0];
                    }
                    if (topRight[j][1] >= topRight[i][1]) {
                        b = topRight[i][1] - bottomLeft[j][1];
                    } else {
                        b = topRight[j][1] - bottomLeft[j][1];
                    }
                } else if (topRight[j][1] <= topRight[i][1] && topRight[j][1] > bottomLeft[i][1]) {
                    if (topRight[j][0] >= topRight[i][0]) {
                        a = topRight[i][0] - bottomLeft[j][0];
                    } else {
                        a = topRight[j][0] - bottomLeft[j][0];
                    }
                    if (bottomLeft[i][1] >= bottomLeft[j][1]) {
                        b = topRight[j][1] - bottomLeft[i][1];
                    } else {
                        b = topRight[j][1] - bottomLeft[j][1];
                    }
                } else {
                    continue;
                }
                a = Math.min(a, b);
                result = Math.max(result, a * a);
            }
        }
        return result;
    }
}
