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
        for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    System.out.print(board[k][l]);
                }
                System.out.println();
            }

    }
    char[][] board=new char[9][9];
    public void solveSudoku(char[][] b2) {
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                board[k][l]=b2[k][l];
            }
        }
        backTrack(b2,board,0,0,0);
    }

    private void backTrack(char[][] b2,char[][] board, int i, int j ,int start) {
        if(i==9){
            for (int k = 0; k < 9; k++) {
                for (int l = 0; l < 9; l++) {
                    b2[k][l]=board[k][l];
                }
            }
            return;
        }


        if(board[i][j]!='.'){
            if(j==8){
                backTrack(b2,board,i+1,0,0);
            }else {
                backTrack(b2,board, i, j + 1, 0);
            }
        }else {
            for (int k = i; k < 9; k++) {
                for (int l = j; l < 9; l++) {

                    List<Character> list = getList(board, i, j);
                    while(list.size()>start){
                        board[k][l] = list.get(start);
                        start++;
                        if(l==8){
                            backTrack(b2,board,k+1,0,0);
                        }else {
                            backTrack(b2,board, k, l + 1, 0);
                        }
                        board[k][l] ='.';

                    }
                    return;
                }
            }

        }
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
