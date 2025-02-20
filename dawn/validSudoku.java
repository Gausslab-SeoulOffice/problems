/*
36. Valid Sudoku

Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

Note:
A Sudoku board (partially filled) could be valid but is not necessarily solvable.
Only the filled cells need to be validated according to the mentioned rules.

Input: board =
[["5","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: true
Example 2:

Input: board =
[["8","3",".",".","7",".",".",".","."]
,["6",".",".","1","9","5",".",".","."]
,[".","9","8",".",".",".",".","6","."]
,["8",".",".",".","6",".",".",".","3"]
,["4",".",".","8",".","3",".",".","1"]
,["7",".",".",".","2",".",".",".","6"]
,[".","6",".",".",".",".","2","8","."]
,[".",".",".","4","1","9",".",".","5"]
,[".",".",".",".","8",".",".","7","9"]]
Output: false
Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.

 */

class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Integer>[] rowSet = new HashSet[9];
        Set<Integer>[] colSet = new HashSet[9];
        Set<Integer>[][] boxSet = new HashSet[3][3];

        for(int i = 0; i <9; i++){
            rowSet[i] = new HashSet<>();
            colSet[i] = new HashSet<>();
            boxSet[i/3][i%3] = new HashSet<>();
        }

        for(int i =0; i<9; i++){
            for(int j = 0; j<9;j++){
                if(board[i][j] != '.'){
                    int num = board[i][j];
                    if(!rowSet[i].contains(num)&&!colSet[j].contains(num)&&!boxSet[i/3][j/3].contains(num)){
                        rowSet[i].add(num);
                        colSet[j].add(num);
                        boxSet[i/3][j/3].add(num);
                    }else{
                        return false;
                    }
                }
            }
        }
        return true;
    }
}

/***
 * 이 문제는 스도쿠가 유요한가를 묻는 문제이다.
 * 스도쿠는 각 행, 열, 박스에 1~9까지의 숫자가 들어가야하고, 중복되어선 안된다는 규칙을 가지고 있다.
 *
 * 중복을 금지한다고 하니 set을 이용할 생각이다.
 * row, col,box들의 각각 set을 선언해주었다.
 * box에서 좀 다른게 box는 결국 행과 열로 이루어져 있다.
 * board[0][0], board[0][1], board[0][2] ~ board[2][0], board[2][1], board[2][2] => boxSet[0][0] 이렇게 되기 때문에 boxSet[i/3][i%3] 이렇게 하였다.
 * 그 후 for문을 돌면서 확인하면 된다. board[i][j]가 . 이 아니라면 어떤 숫자가 들어있었을 거고, 그게 set안에 없다면 각 set에 추가하면 된다. 만약 있다면 숫자 중복으로 false가 되는것이다.
 */