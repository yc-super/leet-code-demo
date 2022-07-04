package 代码随想录.回溯法专练.N皇后;

import java.util.*;

public class Copy {
    public static void main(String[] args) {
        List<List<String>> queensList = new Copy().solveNQueens(5);
        for (List<String> queen : queensList) {
            System.out.println(queen);
        }
    }

    private List<List<String>> solveNQueens(int n){
        List<List<String>> queenList=new ArrayList<>();
        int[] queens=new int[n];
        Arrays.fill(queens,-1);
        Set<Integer> columns=new HashSet<>();
        Set<Integer> diagonals1=new HashSet<>();
        Set<Integer> diagonals2=new HashSet<>();
        backTrack(queenList,0,n,queens,columns,diagonals1,diagonals2);
        return queenList;
    }

    private void backTrack(List<List<String>> queenList, int row, int n, int[] queens, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if(row==n){
            List<String> board = generateBoard(queens, n);
            queenList.add(board);
        }else{
            for (int i = 0; i < n; i++) {
                if(columns.contains(i)){
                    continue;
                }
                int d1=i-row;
                if(diagonals1.contains(d1)){
                    continue;
                }
                int d2=i+row;
                if(diagonals2.contains(d2)){
                    continue;
                }
                columns.add(i);
                diagonals1.add(d1);
                diagonals2.add(d2);
                queens[row]=i;
                backTrack(queenList,row+1,n,queens,columns,diagonals1,diagonals2);
                queens[row]=-1;
                columns.remove(i);
                diagonals1.remove(d1);
                diagonals2.remove(d2);
            }
        }
    }
    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }
}
