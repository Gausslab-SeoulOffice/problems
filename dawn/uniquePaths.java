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
 * 이 문제는 갈 수 있는 경우의 수를 찾는 문제이다.
 * 경로는 최단 경로만을 찾는다.
 *
 * 일단 2차원 배열을 만들어서 내가 가는 경로까지 갈 수 있는 경우의 수를 입력해놓을것이다.
 * 맨 윗줄과 맨 왼쪽 줄은 일직선으로 가는 방법인 1가지밖에 없다.
 * 그렇기 때문에 for문을 2번 작성해서 1로 다 초기화 시켜놓는다.
 * 그 이후 다른 곳까지 가는 경우의 수는 위쪽에서오는 방법과 왼쪽에서 오는 방법을 더하는 갯수가 될 것이다.
 * 그렇기에 result[i][j]는 위쪽에 저장해놓은 경우의 수인 result[i-1][j]와 왼쪽에 저장해놓은 경우의 수인 result[i][j-1]을 더해주면 된다.
 * 내가 마지막으로 도착하는 곳의 인덱스는 m-1, n-1이기 때문에, result[m-1][n-1]에 들어가 있는 값을 반환해주면 된다.
 */