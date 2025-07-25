/*
62. Unique Paths

There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.

Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.

The test cases are generated so that the answer will be less than or equal to 2 * 109.


Example 1:
Input: m = 3, n = 7
Output: 28

Example 2:
Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            result[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            result[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                result[i][j] = result[i - 1][j] + result[i][j - 1];
            }
        }
        return result[m - 1][n - 1];
    }
}

/***
 * 이 문제는 goal까지 갈 수 있는 경우의 수를 구하는 문제이다.
 *
 * 맨 윗줄과 맨 왼쪽은 가는 방법이 한개밖에 없기 때문에 result[i][0]과 result[0][i]는 1로 초기화 시켜준다.
 * 이후 갈 수 있는 방법은 왼쪽과 위쪽을 더한 경우의 수만큼 갈 수 있다.
 * 이중 for문으로 result[i][j]는 result[i-1][j]+result[i][j-1]을 해주면 된다.
 * 이후 goal은 result[m-1][n-1]위치에 있기때문에 반환하면 된다.
 */