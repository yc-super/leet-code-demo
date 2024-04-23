package LeetCode.找到冠军I;

public class Solution {
    /*
     * \
     * 0,0,1,1
     * 1,0,1,1
     * 0,0,0,0
     * 0,0,1,0
     *
     * */
    // 找不到对手
    public int findChampion(int[][] grid) {
        for (int i = 0; i < grid[0].length; i++) {
            boolean flag = true;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return i;
            }
        }
        return 0;
    }

    // continue的另一种写法，之前没接触过
    public int findChampion3(int[][] grid) {
        next:
        for (int i = 0; i < grid[0].length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] == 1) {
                    continue next;
                }
            }
            return i;
        }
        return 0;
    }

    // 打擂台
    public int findChampion2(int[][] grid) {
        int result = 0;
        for (int i = 1; i < grid.length; i++) {
            if (grid[i][result] == 1) {
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue;//只要这个语句执行，当前本次循环停止，直接进入下一次循环“继续”执行
            }
            System.out.println("i -->" + i);//0 1 2 3 4 6 7 8 9
        }

        System.out.println("HelloWorld!");

        System.out.println("===============================");
        myfor:
        for (int i = 0; i < 10; i++) {
            if (i == 5) {
                continue myfor;
            }
            System.out.println("i -->" + i);
        }

        System.out.println("HelloWorld!");
    }
}
