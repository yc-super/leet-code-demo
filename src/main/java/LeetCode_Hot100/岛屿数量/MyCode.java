package LeetCode_Hot100.岛屿数量;
/*
* 新建一个visited数组，用于存储是否遍历过该节点。递归，从该节点往右、下、左、上遍历，遇到visited为true或遇到’0‘return。效率一般，应该可以剪枝的
* */
public class MyCode {
    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
//        char[][] grid = {
//                {'1','1','0','0','0'},
//                {'1','1','0','0','0'},
//                {'0','0','1','0','0'},
//                {'0','0','0','1','1'}
//        };
//        char[][] grid = {
//                {'1','0'},
//                {'0','1'}
//        };
        char[][] grid = {
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
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
        boolean[][] visited=new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='0'||visited[i][j])
                    continue;
                num++;
                method(grid,i,j,visited);
            }
        }
        return num;
    }

    private static void method(char[][] grid, int i, int j, boolean[][] visited) {
        if(!(i<grid.length&&i>=0)||!(j<grid[0].length&&j>=0))
            return;
        if(visited[i][j])
            return;
        visited[i][j]=true;
        if(grid[i][j]=='0')
            return;
        method(grid,i+1,j,visited);
        method(grid,i-1,j,visited);
        method(grid,i,j+1,visited);
        method(grid,i,j-1,visited);
    }
}
