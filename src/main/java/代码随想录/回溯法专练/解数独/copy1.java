package 代码随想录.回溯法专练.解数独;

public class copy1 {
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
        new copy1().solveSudoku(board);
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                System.out.print(board[k][l]);
            }
            System.out.println();
        }
    }
    public void solveSudoku(char[][] board) {
        backTrack(board);
    }

    private boolean backTrack(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if(board[i][j]!='.')
                    continue;
                for (char k = '1'; k <= '9'; k++) {
                    if(isValid(i,j,k,board)){
                        board[i][j]=k;
                        if(backTrack(board))
                            return true;
                        board[i][j]='.';
                    }

                }
                return false;
            }

        }
        return true;
    }

    private boolean isValid(int i, int j, char k, char[][] board) {
        for (int l= 0; l < 9; l++) {
            if(board[i][l]==k)
                return false;
        }
        for (int l = 0; l < 9; l++) {
            if(board[l][j]==k)
                return false;
        }
        int ii=i/3;
        int jj=j/3;
        for (int l = 3*ii; l <=3*ii+2 ; l++) {//此处可改进：k <=3*ii+2&&k!=i
            for (int m = 3*jj; m <=3*jj+2 ; m++) {//此处可改进
                if(board[l][m]==k)
                    return false;
            }
        }
        return true;
    }
}
