package 宫水三叶.DFS.解数独;

public class Solution {
    public void solveSudoku(char[][] board) {
        myDFS(0, 0, board);
    }

    private boolean myDFS(int i, int j, char[][] board) {
        if (i == board.length)
            return true;

        if ('.' != board[i][j]) {
            if (j == board[0].length - 1) {
                return myDFS(i + 1, 0, board);
            } else {
                return myDFS(i, j + 1, board);
            }
        }
        for (char k = '1'; k <= '9'; k++) {
            if (myCheck(i, j, k, board)) {
                board[i][j] = k;
                if (j == board[0].length - 1) {
                    boolean b = myDFS(i + 1, 0, board);
                    if (b) {
                        return true;
                    }
                } else {
                    boolean b = myDFS(i, j + 1, board);
                    if (b) {
                        return true;
                    }
                }
                board[i][j] = '.';
            }
        }
        return false;
    }

    private boolean myCheck(int row, int col, char val, char[][] board) {
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
