package LeetCode_Hot100.单词搜索;

/*
* 输入：board = [
* ["A","B","C","E"],
* ["S","F","C","S"],
* ["A","D","E","E"]
* ], word = "ABCCED"
输出：true

* 输入：board = [
* ["A","B","C","E"],
* ["S","F","C","S"],
* ["A","D","E","E"]
* ], word = "SEE"
输出：true
*
* 输入：board = [
* ["A","B","C","E"],
* ["S","F","C","S"],
* ["A","D","E","E"]
* ], word = "ABCB"
输出：false
* */
public class MyCode {
    public static void main(String[] args) {
//        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
////        char[][] board = {{'A'}};
////        char[][] board = {{'A'}, {'S'}, {'A'}};
//        String word = "ABCCEDf";

//        char[][] board={{'a','a','a','a'},{'a','a','a','a'},{'a','a','a','a'}};
//        String word="aaaaaaaaaaaaa";

//        char[][] board={{'a','b','c'},
//            {'a','e','d'},
//            {'a','f','g'}};
//        String word="abcdefg";


        char[][] board={{'C','A','A'},
                        {'A','A','A'},
                        {'B','C','D'}};
        String word="AAB";
        boolean exist = new MyCode().exist(board, word);
        System.out.println(exist);
    }

    boolean flag =false;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        if(board.length*board[0].length<word.length())
            return false;
        visited=new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                ifExit(board, word, i, j, 0);
                if(flag)
                    return true;
            }
        }
        return false;
    }

    private void ifExit(char[][] board, String word, int m, int n,int count) {
        if(count==word.length()-1){
            if(board[m][n]==word.charAt(word.length()-1)&&!visited[m][n]){
                flag=true;
                return;
            }else{
                return;
            }
        }
        if(word.charAt(count)==board[m][n]&&!visited[m][n]) {
            visited[m][n]=true;
            if (!flag&&m < board.length - 1 ) {
                ifExit(board, word, m + 1, n, count + 1);
            }
            if (!flag&&n < board[0].length - 1) {
                ifExit(board, word, m, n + 1,  count + 1);
            }
            if (!flag&&m > 0 ) {
                ifExit(board, word, m - 1, n,  count + 1);
            }
            if (!flag&&n > 0) {
                ifExit(board, word, m, n - 1,  count + 1);
            }
            visited[m][n]=false;
        }
    }
}
