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
    int m, n;
    boolean[][] visited;

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
 * 이 문제는 문자열 판에 내가 찾는 word가 연결되어 있는지 구하는 문제이다.
 *
 * 백트래킹을 사용하는 문제이다.
 * 일단 방문을 했는지 사용하는 visited를 만들어주고, 결과를 나타내는 result를 선언해준다.
 * 그리고  m,n을 설정해준다.
 * compute함수를 사용해서 맨처음 찾고싶은 단어를 먼저 row, col로 넘기고 인덱스는 0부터 검색한다.
 * 현재 위치를 온것이기 때문에 visited를 true로 옮겨준다.
 * 이 함수가 끝나는 조건은 범위를 넘어선 경우, 지금 값과 있는 위치에서 글자가 다른경우이다.
 * 그리고 true가 되는 조건은 모든 단어를 찾은경우이다.
 * 그게 아니라면 검색중이라는 것이다.
 * 상하좌우로 옮겨다니면서 값이 있는지 검색하고, 없는 경우에는 다시 돌아와야하기 때문에 visited를 다시 false로 옮겨줘야한다.
 * 이후 result를 반환하면 된다.
 */