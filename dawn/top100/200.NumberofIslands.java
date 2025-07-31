/*
200. Number of Islands

Given an m x n 2D binary grid grid which represents a map of '1's (land) and '0's (water), return the number of islands.

An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.


Example 1:
Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1

Example 2:
Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3
 */

class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        int cols = grid[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    findIsland(grid, i, j, rows, cols);
                    result++;
                }
            }
        }
        return result;
    }

    private void findIsland(char[][] grid, int i, int j, int rows, int cols) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) {
            return;
        }
        if (grid[i][j] == '1') {
            grid[i][j] = '0';
            findIsland(grid, i + 1, j, rows, cols);
            findIsland(grid, i - 1, j, rows, cols);
            findIsland(grid, i, j + 1, rows, cols);
            findIsland(grid, i, j - 1, rows, cols);
        }
    }
}

/***
 * 이 문제는 섬의 갯수를 세는 문제이다.
 * 연결된 1은 동일한 섬을 의미한다.
 *
 * 일단 갯수를 세는 답을 result로 선언해둔다.
 * 그리고 grid[i][j]가 1이면 연결된 1을 모두 찾아야 카운팅 되지 않는다.
 * 새로 1을 찾는다면 result를 증가시켜주고, 마지막으로 result를 반환하면 된다.
 * 연결된 섬을 찾는 함수를 findIsland라고한다.
 * 맨처음 1을 찾으면 이 함수가 호출된다.
 * 그럼 연결된 1을 찾아야하는데 i와 j가 범위를 벗어나면 바로 return;을 한다.
 * 그리고 내가 있는 위치를 0으로 변경시켜서 다음에 찾지 않도록한다.
 * 그 후 상하좌우를 살피면서 findIsland  함수를 호출시켜준다.
 */