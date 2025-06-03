/*
994. Rotting Oranges

You are given an m x n grid where each cell can have one of three values:

0 representing an empty cell,
1 representing a fresh orange, or
2 representing a rotten orange.
Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes rotten.

Return the minimum number of minutes that must elapse until no cell has a fresh orange. If this is impossible, return -1.


Example 1:
Input: grid = [[2,1,1],[1,1,0],[0,1,1]]
Output: 4

Example 2:
Input: grid = [[2,1,1],[0,1,1],[1,0,1]]
Output: -1
Explanation: The orange in the bottom left corner (row 2, column 0) is never rotten, because rotting only happens 4-directionally.

Example 3:
Input: grid = [[0,2]]
Output: 0
Explanation: Since there are already no fresh oranges at minute 0, the answer is just 0.
 */

class Solution {
    public int orangesRotting(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int fresh = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0)
            return 0;

        int time = -1;
        int[][] directions = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                int[] curr = queue.poll();
                for (int[] direction : directions) {
                    int x = curr[0] + direction[0];
                    int y = curr[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        queue.offer(new int[] { x, y });
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

/***
 * 이 문제는 썪은 오렌지가 시간이 지날수록 상하좌우로 옮겨진다. 신선한 오랜지가 다 썪을때까지 걸리는 시간을 반환하라는 문제이다.
 *
 * queue에는 썩은 오렌지의 위치를 넣는다 (BFS 시작점).
 * fresh는 신선한 오렌지 개수이다.
 * 썩은 오렌지를 큐에 넣고, 신선한 오렌지 개수를 센다.
 * BFS를 통해 매 분마다 썩은 오렌지의 인접한 신선한 오렌지를 썩힌다.
 * 새로 썩은 오렌지를 큐에 추가하고 신선한 개수를 줄인다.
 * 모든 오렌지가 썩을 때까지 위 과정을 반복하며 시간(time)을 증가시킨다.
 * 모든 신선한 오렌지가 썩었으면 time, 그렇지 않으면 -1을 반환한다.
 */