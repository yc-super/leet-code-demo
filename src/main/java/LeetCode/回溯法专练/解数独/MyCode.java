package LeetCode.回溯法专练.解数独;

import java.util.ArrayList;
import java.util.List;

/*
* 数字1-9在每一行只能出现一次。
数字1-9在每一列只能出现一次。
数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。（请参考示例图）
数独部分空格内已填入了数字，空白格用'.'表示。

* board =
* [['5','3','.','.','7','.','.','.','.'],
* ['6','.','.','1','9','5','.','.','.'],
* ['.','9','8','.','.','.','.','6','.'],
* ['8','.','.','.','6','.','.','.','3'],
* ['4','.','.','8','.','3','.','.','1'],
* ['7','.','.','.','2','.','.','.','6'],
* ['.','6','.','.','.','.','2','8','.'],
* ['.','.','.','4','1','9','.','.','5'],
* ['.','.','.','.','8','.','.','7','9']]
输出：
* [['5','3','4','6','7','8','9','1','2'],
* ['6','7','2','1','9','5','3','4','8'],
* ['1','9','8','3','4','2','5','6','7'],
* ['8','5','9','7','6','1','4','2','3'],
* ['4','2','6','8','5','3','7','9','1'],
* ['7','1','3','9','2','4','8','5','6'],
* ['9','6','1','5','3','7','2','8','4'],
* ['2','8','7','4','1','9','6','3','5'],
* ['3','4','5','2','8','6','1','7','9']]
* */
public class MyCode {
    public static void main(String[] args) {
        char[][] board=
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        new MyCode().solveSudoku(board);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        backTrack(board,0,0,0,new ArrayList<>());
    }

    private void backTrack(char[][] board, int i, int j ,int start,List<Character> list) {
//        for (int k = 0; k < i; k++) {
//            for (int l = 0; l < j; l++) {
        if(i==9)
            return;
        if(board[i][j]!='.'){
            if(j==8){
                backTrack(board,i+1,0,0,new ArrayList<>());
            }else {
                backTrack(board, i, j + 1, 0, new ArrayList<>());
            }
        }else {
            list = getList(board, i, j);
            if(list==null||list.size()==0)
                return;
            board[i][j] = list.get(start);
            if(j==8){
                backTrack(board,i+1,0,0,new ArrayList<>());
            }else {
                backTrack(board, i, j + 1, 0, new ArrayList<>());
            }
            board[i][j] = list.get(++start);
        }
//            }
//
//        }
    }

    private List<Character> getList(char[][] board, int i, int j) {
        List<Character> result=new ArrayList<>();
        for (int k = 1; k <= 9; k++) {
            result.add((char)(k+'0'));
        }
        for (int k = 0; k < 9; k++) {
            if(board[i][k]!='.')
                result.remove((Character) board[i][k]);
        }
        for (int k = 0; k < 9; k++) {
            if(board[k][j]!='.')
                result.remove((Character) board[k][j]);
        }
        for (int k = 0; k < 9; k++) {
            if(board[k][j]!='.')
                result.remove((Character) board[k][j]);
        }
        int ii=i/3;
        int jj=j/3;
        for (int k = 3*ii; k <=3*ii+2 ; k++) {//此处可改进：k <=3*ii+2&&k!=i
            for (int l = 3*jj; l <=3*jj+2 ; l++) {//此处可改进
                if(board[k][l]!='.')
                    result.remove((Character) board[k][l]);
            }
        }
        return result;
    }
}
