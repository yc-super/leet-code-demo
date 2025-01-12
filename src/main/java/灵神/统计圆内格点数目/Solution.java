package 灵神.统计圆内格点数目;

public class Solution {
    public static void main(String[] args) {
        int[][] circles={{2,2,2},{3,4,1}};
        System.out.println(new Solution().countLatticePoints(circles));
    }

    // 枚举圆，找点，同时用哈希映射数组，过了
    // 灵神的题解中，是枚举点找圆，并且提前按照圆大小排好序，这样能更快找到包含当前枚举点的圆，找到一个圆、当前点就认为是满足条件的圆
    public int countLatticePoints(int[][] circles) {
        int[][] temp = new int[201][201];
        for (int i = 0; i < circles.length; i++) {
            int len = circles[i][2];
            int left1 = circles[i][0] - len;
            int left2 = circles[i][1] - len;
            int right1 = circles[i][0] + len;
            int right2 = circles[i][1] + len;
            for (int j = left1; j <= right1; j++) {
                for (int k = left2; k <= right2; k++) {
                    int a = Math.abs(j - circles[i][0]);
                    int b = Math.abs(k - circles[i][1]);
                    int c = circles[i][2] * circles[i][2];
                    if (a * a + b * b <= c) {
                        temp[j][k] = 1;
                    }
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 201; i++) {
            for (int j = 0; j < 201; j++) {
                if (temp[i][j] == 1) {
                    result++;
                }
            }
        }
        return result;
    }
}
