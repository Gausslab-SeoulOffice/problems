/*
79. Word Search

Given an m x n grid of characters board and a string word, return true if word exists in the grid.

The word can be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally or vertically neighboring. The same letter cell may not be used more than once.


Example 1:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
Output: true

Example 2:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
Output: true

Example 3:
Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
Output: false
 */

class Solution {
    boolean result = false;
    boolean[][] visited;
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    visited = new boolean[m][n];
                    compute(board, word, i, j, 0);
                }
            }
        }
        return result;
    }

    private void compute(char[][] board, String word, int row, int col, int index) {
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return;
        }
        if (board[row][col] != word.charAt(index)) {
            return;
        }
        if (index == word.length() - 1 && board[row][col] == word.charAt(index)) {
            result = true;
            return;
        }
        visited[row][col] = true;
        compute(board, word, row - 1, col, index + 1);
        compute(board, word, row + 1, col, index + 1);
        compute(board, word, row, col - 1, index + 1);
        compute(board, word, row, col + 1, index + 1);
        visited[row][col] = false;
    }
}

/***
 * 이 문제는 board가 주어지고 string이 주어졌을때 board에서 옮겨다니면서 string을 만들 수 있는지 확인하는 문제이다.
 *
 * board문제를 풀떄 대부분 visited를 사용한다는걸 잊지말아야겠다.
 * 일단 visited를 board의 mxn만큼 만들어주고 compute라는 함수를 만든다.
 * compute는 board랑 word, 현재 지금 있는 row와 col를 받아야하고 글자를 어디 읽고 있는지 알아야해서 index도 필요로하다.
 * 그리고 상하좌우를 살피기 떄문에 예외처리를 할때 마이너스가 나오니까 이 부분까지 처리해야한다.
 * row가 범위 안에, col이 범위 안에, visited가 이미 간 곳, 이것중에 하나라도 만족하면 return;을 한다.
 * 그리고 board안에 단어가 내가 지금 찾는 단어랑 맞지 않아도 return;을 한다.
 * 그리고 끝까지 다 찾으면 result를 true로 바꾸고 return;한다.
 * 찾는 과정은 visited를 일단 true로 바꾸고 compute를 상하좌우로 다 돌린다. 이때는 지금 있는 곳은 visite가 true인 상태고 그 다음을 찾는 것이기 때문에 index+1로 단어를 다음걸로 바꿔주고, 상하좌우는 row, col에 +,-를 해주면 된다.
 */