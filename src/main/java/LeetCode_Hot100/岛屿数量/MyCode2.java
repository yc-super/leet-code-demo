package LeetCode_Hot100.岛屿数量;
/*
* 看了一眼官方答案，可以直接把数组的1置0的，我还傻乎乎地创建了个visited
* 这叫广度优先搜索
* */
public class MyCode2 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
//        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'0','0','0','0','0'},
//                {'1','0','1','0','0'},
//                {'1','1','1','1','1'}
//        };
//        char[][] grid = {
//                {'1','0'},
//                {'0','1'}
//        };
//        char[][] grid = {
//                {'1','1','1'},
//                {'0','1','0'},
//                {'1','1','1'}
//        };
//
//        char[][] grid = {
//                {'0'}
//        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int num=0;
        int m=grid.length;
        int n=grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='0')
                    continue;
                num++;
                method(grid,i,j);
            }
        }
        return num;
    }

    private static void method(char[][] grid, int i, int j) {
        if(!(i<grid.length&&i>=0)||!(j<grid[0].length&&j>=0))
            return;
        if(grid[i][j]=='0')
            return;
        grid[i][j]='0';
        method(grid,i+1,j);
        method(grid,i-1,j);
        method(grid,i,j+1);
        method(grid,i,j-1);
    }
}
