/*
63. Unique Paths II

You are given an m x n integer array grid. There is a robot initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
An obstacle and space are marked as 1 or 0 respectively in grid. A path that the robot takes cannot include any square that is an obstacle.
Return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The testcases are generated so that the answer will be less than or equal to 2 * 109.


Example 1:
Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
Output: 2
Explanation: There is one obstacle in the middle of the 3x3 grid above.
There are two ways to reach the bottom-right corner:
1. Right -> Right -> Down -> Down
2. Down -> Down -> Right -> Right

Example 2:
Input: obstacleGrid = [[0,1],[0,0]]
Output: 1
 */

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        int[][] dp = new int[row][col];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        dp[0][0] = 1;

        for (int i = 1; i < row; i++) {
            dp[i][0] = (obstacleGrid[i][0] == 0 && dp[i - 1][0] == 1) ? 1 : 0;
        }

        for (int j = 1; j < col; j++) {
            dp[0][j] = (obstacleGrid[0][j] == 0 && dp[0][j - 1] == 1) ? 1 : 0;
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[row - 1][col - 1];
    }
}


/***
 * 이 문제는 경로의 경우의 수를 구하는 문제이다. 중간에 1이라고 장애물이 있는데 여기로는 못간다는 제약이 있다.
 *
 * dp[i][j]는 (i,j)에 도달하는 경로의 수를 저장하는 배열이다.
 * 시작점(0,0)이 장애물이면 아무 데도 못 가니까 return 0을 반환한다.
 * 시작점이 비어 있다면 도달 가능한 경로는 1개이다.
 * 첫 열(dp[1][0], dp[2][0], ...)은 위쪽 칸에서만 올 수 있다.
 * 장애물 만나기 전까진 1, 그 뒤는 모두 0이다.
 * 첫 행도 마찬가지로 왼쪽에서만 올 수 있다.
 * 장애물 만나면 이후는 다 0이다.
 * obstacleGrid[i][j] == 0 → 장애물이 없다면
 * 위에서 오는 경로 수 dp[i-1][j]
 * 왼쪽에서 오는 경로 수 dp[i][j-1]
 * 둘을 더한 것이 현재 칸까지 오는 총 경로 수
 * 장애물이 있다면 dp[i][j] = 0
 */