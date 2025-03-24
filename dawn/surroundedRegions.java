/*
130. Surrounded Regions

You are given an m x n matrix board containing letters 'X' and 'O', capture regions that are surrounded:

Connect: A cell is connected to adjacent cells horizontally or vertically.
Region: To form a region connect every 'O' cell.
Surround: The region is surrounded with 'X' cells if you can connect the region with 'X' cells and none of the region cells are on the edge of the board.
To capture a surrounded region, replace all 'O's with 'X's in-place within the original board. You do not need to return anything.



Example 1:

Input: board = [["X","X","X","X"],["X","O","O","X"],["X","X","O","X"],["X","O","X","X"]]

Output: [["X","X","X","X"],["X","X","X","X"],["X","X","X","X"],["X","O","X","X"]]

Explanation:


In the above diagram, the bottom region is not captured because it is on the edge of the board and cannot be surrounded.

Example 2:

Input: board = [["X"]]

Output: [["X"]]
 */

class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            if (board[i][0] == 'O') {
                find(i, 0, rows, cols, board);
            }
            if (board[i][cols - 1] == 'O') {
                find(i, cols - 1, rows, cols, board);
            }
        }
        for (int j = 0; j < cols; j++) {
            if (board[0][j] == 'O') {
                find(0, j, rows, cols, board);
            }
            if (board[rows - 1][j] == 'O') {
                find(rows - 1, j, rows, cols, board);
            }
        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void find(int i, int j, int rows, int cols, char[][] board) {
        if (i < 0 || j < 0 || i >= rows || j >= cols || board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        find(i, j - 1, rows, cols, board);
        find(i, j + 1, rows, cols, board);
        find(i - 1, j, rows, cols, board);
        find(i + 1, j, rows, cols, board);
    }
}

/***
 * 이 문제는 둘러싸인 O를 x로 바꾸는 문제이다.
 * 제약이 있다면 테두리에 있는건 바꿀 수 없다는 것이다.
 *
 * 일단 전 문제랑 거의 비슷한데 제약이 있다는 것이다.
 * 그 특징을 가지고 풀면 될거 같았다.
 * 일단 rows, cols를 선언해주고, 테두리에 있는 것들을 처리하려고 했다.
 * 각 테두리에 있는게 O가 있으면 그 구역은 절대로 X가 될 수 없기에 그 구역을 찾아야한다.
 * 그 구역을 가서 일단 상하좌우를 살핀다.
 * 다 #으로 바꾸면 그 구역은 절대 x가 될 수 없는 구역이라는 것을 의미하며, 방문했다는 걸 나타낸다.
 * 그리고 다시 돌아와서 #으로 되어 있는 구역은 O로 다 바꾸고, 그냥 O로 되어 있는 경우는 둘러싸인걸 의미하기 때문에 X로 바꾸면 된다.
 */