package LeetCode.边界着色;

import java.util.ArrayList;
import java.util.List;

//深度优先搜索，明天再看看广度优先搜索
public class copy {
    public static void main(String[] args) {
        int[][] grid = {{1,1},{1,2}};
        int row = 0, col = 0, color = 3;
        grid=new copy().colorBorder(grid,row,col,color);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                System.out.print(grid[i][j]+",");
            }
            System.out.println();
        }
    }
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int m=grid.length,n=grid[0].length;
        int originColor=grid[row][col];
        int[][] visited=new int[m][n];
        visited[row][col]=1;
        List<int[]> list=new ArrayList<>();
        dfs(row,col,grid,visited,list,originColor);
        for(int[] l:list){
            grid[l[0]][l[1]]=color;
        }
        return grid;
    }

    private void dfs(int row,int col,int[][] grid, int[][] visited, List<int[]> list, int originColor) {
        int m=grid.length,n=grid[0].length;
        int[][] array={{0,1},{0,-1},{1,0},{-1,0}};
        boolean flag=false;
        for (int i = 0; i < 4; i++) {
            int cm=row+array[i][0],cn=col+array[i][1];
            if(!(cm>=0&&cm<m&&cn>=0&&cn<n&&grid[cm][cn]==originColor)){
                flag=true;
            }else if(visited[cm][cn]==0){
                visited[cm][cn]=1;
                dfs(cm,cn,grid,visited,list,originColor);
            }
        }
        if(flag){
            list.add(new int[]{row,col});
        }
    }
}
