/*
64. Minimum Path Sum

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.


Example 1:
Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
Output: 7
Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

Example 2:
Input: grid = [[1,2,3],[4,5,6]]
Output: 12
 */

class Solution {
    public int minPathSum(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;

        for (int i = 1; i < row; i++) {
            grid[i][0] += grid[i - 1][0];
        }
        for (int i = 1; i < col; i++) {
            grid[0][i] += grid[0][i - 1];
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
            }
        }
        return grid[row - 1][col - 1];
    }
}

/***
 * 이 문제는 최소의 sum으로 끝까지 도달하는 수를 구하는 문제이다.
 *
 * 일단 맨 윗줄과 맨 왼쪽줄이 갈 수 있는 최소의 sum은 그 전에 있던 수와 합하는 경우밖에 없기때문에, grid[i][0]은 grid[i-1][0]과 합해주고, grid[0][i]는 grid[0][i-1]과 더해준다.
 * 이후 이중 for문을 통해 제일 작은 수와 합해주는 경우이다.
 * grid[i-1][j]와 grid[i][j-1]중에 더 작은 수와 grid[i][j]에 있는 값을 더해주면 갈 수 있는 최소의 합이 나오게 된다.
 * goal지점은 grid[row-1][col-1]지점이기 때문에 이를 반환하면 된다.
 */