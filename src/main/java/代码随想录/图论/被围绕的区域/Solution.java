package 代码随想录.图论.被围绕的区域;

public class Solution {
    private int[][] move = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};

    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (i == 0 || i == board.length - 1 || j == 0 || j == board[0].length - 1)
                    if (board[i][j] == 'O') {
                        back(board, i, j);
                    }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == '1') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    private void back(char[][] board, int i, int j) {
        board[i][j] = '1';
        for (int[] a : move) {
            if (i + a[0] >= 0 && i + a[0] < board.length && j + a[1] >= 0 && j + a[1] < board[0].length && board[i + a[0]][j + a[1]] == 'O')
                back(board, i + a[0], j + a[1]);
        }
    }
}
