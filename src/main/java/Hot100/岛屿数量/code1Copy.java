package Hot100.岛屿数量;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/*
*
* Queue的一些方法：
* add:在队列末尾添加一个元素，返回boolean
remove:获取队首的元素，并从队列移除
element:获取队首的元素，但不从队列移除

offer:添加一个元素到队尾
poll:获取队首的元素，并从队列移除
peek:获取队首的元素，但不从队列移除
* */


//有问题，再看一看，和官方答案的广度优先搜索有一点不一样
public class code1Copy {
    public static void main(String[] args) {
        char[][] grid = {
                {'1', '1', '1', '1', '1'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '1'},
                {'1', '0', '0', '1', '1'}
        };
//
//        char[][] grid = {
//                {'1','0'},
//                {'0','1'}
//        };
//        char[][] grid = {
//                {'1','1','1'},
//                {'0','0','0'},
//                {'1','1','1'}
//        };
//
//        char[][] grid = {
//                {'0'}
//        };
        System.out.println(numIslands(grid));
    }
    public static int numIslands(char[][] grid) {
        Queue<Integer> queue = new LinkedList<>();//普通的单端队列，先进先出，FIFO。一些方法：https://blog.csdn.net/qq_22985751/article/details/82896454
//        Deque<Integer> queue2 = new LinkedList<>();//双端队列，先进先出，FIFO
//        Stack<Integer> stack = new Stack<>();//栈，后进先出

        int m=grid.length;
        int n=grid[0].length;
        int num=0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j]=='1'){
                    num++;
                    queue.add(i*n+j);
                    grid[i][j]='0';
                    while(!queue.isEmpty()){
                        Integer temp = queue.remove();
                        int ii=temp/n;
                        int jj=temp%n;
                        if(ii-1>=0&&grid[ii-1][jj]=='1'){
                            queue.add((ii-1)*n+jj);
                            grid[ii-1][jj]='0';
                        }
                        if(jj-1>=0&&grid[ii][jj-1]=='1'){
                            queue.add(ii*n+(jj-1));
                            grid[ii][jj-1]='0';
                        }
                        if(ii+1<m&&grid[ii+1][jj]=='1'){
                            queue.add((ii+1)*n+jj);
                            grid[ii+1][jj]='0';
                        }
                        if(jj+1<n&&grid[ii][jj+1]=='1'){
                            queue.add(ii*n+(jj+1));
                            grid[ii][jj+1]='0';
                        }
                    }
                }
            }

        }
        return num;
    }
}
