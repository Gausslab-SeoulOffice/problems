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
        return grid[row-1][col-1];
    }
}

/***
 * 이 문제는 왼쪽 위에서 오른쪽 아로 내려오면서 숫자를 더할건데, 이 때 최소값을 찾는 문제이다.
 *
 * 왼쪽 위에서 오른쪽 아래로 내려온다는것에 초점을 맞추면 된다.
 * 그럼 제일 왼쪽 열은 무조건 아래로 내려오면서 더해지는 경우만 있고, 제일 위쪽 행은 무조건 왼쪽에서 오른쪽으로 오면서 더해지는 경우만 있는것이다.
 * 그래서 grid[i][0] 은 무조건 그 전꺼인 grid[i-1][0]이랑 더하면 되고, grid[0][i]는 무조건 그 전꺼인 grid[0][i-1]이랑만 더하면 된다.
 * 그 이후 다른 grid[i][j]들은 왼쪽 옆이나 한칸 위쪽인 셀들과 비교해서 더 작은거랑 더하면 된다.
 * 그렇게 되면 마지막 grid[row-1][col-1]에 들어가 있는 숫자가 최소가 된다.
 */