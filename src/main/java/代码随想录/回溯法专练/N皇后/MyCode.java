package 代码随想录.回溯法专练.N皇后;

import java.util.*;

public class MyCode {
    public static void main(String[] args) {
        int n=4;
        List<List<String>> lists= NQueen(n);
//        System.out.println(list);
        for (List<String> list: lists) {
            for (String s :list) {
                System.out.println(s);
            }
            System.out.println();
        }
    }
    private static List<List<String>> NQueen(int n) {
        List<List<String>> res=new ArrayList<>();
        Integer[] list=new Integer[n];
        Set<Integer> diagonals1=new HashSet<>();
        Set<Integer> diagonals2=new HashSet<>();
        Set<Integer> colums=new HashSet<>();

        NQueens(n,0,res,colums,diagonals1,diagonals2,list);

        return res;
    }

    private static void NQueens(int n, int row, List<List<String>> res, Set<Integer> colums, Set<Integer> diagonals1, Set<Integer> diagonals2, Integer[] list) {
        if(row==n){
//            res.add(list);//list是个数组，存储n个数据，第一个值是第1行的第几个为Q，第二个值是第2行的第几个为Q
            List<String> board=generateBoard(list,n);
            res.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if(colums.contains(i))
                continue;
            int dia1=row+i;
            if(diagonals1.contains(dia1))
                continue;
            int dia2=row-i;
            if(diagonals2.contains(dia2))
                continue;

            colums.add(i);
            diagonals1.add(dia1);
            diagonals2.add(dia2);

            list[row]=i;

            NQueens(n,row+1,res,colums,diagonals1,diagonals2,list);

            colums.remove(i);
            diagonals1.remove(dia1);
            diagonals2.remove(dia2);
        }
    }

    private static List<String> generateBoard(Integer[] list, int n) {
        List<String> res=new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] chars=new char[n];
            Arrays.fill(chars,'.');
            chars[list[i]]='Q';
            res.add(new String(chars));
        }
        return res;
    }
}
