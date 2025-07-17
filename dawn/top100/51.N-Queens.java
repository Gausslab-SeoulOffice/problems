/*
51. N-Queens

The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle. You may return the answer in any order.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space, respectively.


Example 1:
Input: n = 4
Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above

Example 2:
Input: n = 1
Output: [["Q"]]
 */

class Solution {
    private boolean issafe(int n, char[][] nqueens, int row, int col) {
        for(int i=0;i<n;i++) {
            if(nqueens[i][col] == 'Q') return false;
        }
        for(int i=row-1,j=col-1; i>=0&&j>=0; i--,j--) {
            if(nqueens[i][j] == 'Q') return false;
        }
        for(int i=row-1,j=col+1;i>=0&&j<n;i--,j++) {
            if(nqueens[i][j] == 'Q') return false;
        }
        return true;
    }
    private void solve(int n, List<List<String>> answer, char[][] nqueens, int row) {
        if(row==n) {
            List<String> sol = new ArrayList<>();
            for(char[] queen : nqueens) {
                sol.add(new String(queen));
            }
            answer.add(sol);
            return;
        }


        for(int col=0;col<n;col++) {
            if(issafe(n,nqueens, row,col)) {
                nqueens[row][col] = 'Q';
                solve(n,answer, nqueens,row+1);
                nqueens[row][col] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> answer = new ArrayList<>();
        char[][] nqueens = new char[n][n];

        for(int i=0;i<n;i++) {
            Arrays.fill(nqueens[i], '.');
        }
        int row = 0;
        solve(n,answer,nqueens,row);
        return answer;
    }
}

/***
 * 이 문제는 q를 놓을 수 있는 경우의 수를 찾아서 반환하라는 문제이다.
 *
 * 일단 시작은 체스판 전체를 .으로 채우는 과정이다.
 * 그리고 row를 0부터 검색하는 과정을 거친다.
 * 만약 row가 n이랑 같으면 끝까지 온것이기에 list를 만들어서 그 안에 nqueens를 순서대로 넣어서 answer에 넣어주면 된다.
 * 그게 아니라면 검색하는 과정이다.
 * 백트래킹을 이용해서 Q를 놓을 수 있는지 검색하게 된다.
 * 가능하면 Q를 넣고 다시 삭제하면서 검색하게 된다.
 * Q를 놓을 수 있는지 확인해봐야하기 때문에 issafe라는 함수가 사용된다.
 * queen은 가로 세로 대각선에 있는 수를 잡을 수 있기 때문에 확인해야한다.
 * for(int i= 0; i < n; i++) 이건 같은 열에 q가 있는지 확인하는 것이다.
 * 그리고 왼쪽 대각선을 살피고 그리곤 오른쪽 대각선을 살피게 된다.
 * 모두 없다면 true를 반환한다.
 * 이후 answer를 반환하면 된다.
 */