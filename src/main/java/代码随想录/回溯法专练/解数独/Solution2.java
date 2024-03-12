package 代码随想录.回溯法专练.解数独;

public class Solution2 {

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                        {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                        {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                        {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                        {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                        {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                        {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                        {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                        {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        new Solution2().solveSudoku(board);
        for (int k = 0; k < 9; k++) {
            for (int l = 0; l < 9; l++) {
                System.out.print(board[k][l]);
            }
            System.out.println();
        }
    }

    public void solveSudoku(char[][] board) {
        backTrack(board, 0, 0);
    }

    private boolean backTrack(char[][] board, int a, int b) {
        if(a==9)
            return true;
        int i = a;
        int j = b;
        if (board[i][j] != '.') {
            return backTrack(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1);
        }
        for (char k = '1'; k <= '9'; k++) {
            if (isValidSudoku(i, j, k, board)) {
                board[i][j] = k;
                if (backTrack(board, j == 8 ? i + 1 : i, j == 8 ? 0 : j + 1))
                    return true;
                board[i][j] = '.';
            }
        }
        return false;
//        return true;
    }

    private boolean isValidSudoku(int row, int col, char val, char[][] board) {
        // 同行是否重复
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }
        // 同列是否重复
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }
        // 9宫格里是否重复
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }
}
