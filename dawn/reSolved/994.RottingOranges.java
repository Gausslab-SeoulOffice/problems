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
        int time = -1;
        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] { i, j });
                } else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        if (fresh == 0) {
            return 0;
        }

        while (!queue.isEmpty()) {
            int n = queue.size();
            int x, y;
            while (n-- > 0) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];
                    if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fresh--;
                        queue.offer(new int[] { x, y });
                    }
                }
            }
            time++;
        }
        return fresh == 0 ? time : -1;
    }
}

/***
 * 이 문제는 오렌지를 전부 상하게 하는데 얼마나 시간이 걸리는지 구하는 문제이다.
 *
 * 일단 상한 오렌지를 먼저 찾고, 안상한건 fresh로 갯수를 세서 둬야한다.
 * 그리고 queue에 상한 위치를 넣고 시간이 지나면서 상하좌우에 있는 fresh오렌지를 상하게 할것이다.
 * n만큼 반복 → 현재 시간에서 썩은 오렌지들을 모두 꺼낸다.
 * 인접한 좌표가 유효하고 1(신선한 오렌지)일 경우:
 * 2(썩은)으로 바꾸고, fresh 감소, 큐에 새로 썩은 오렌지를 넣음 → 다음 레벨에서 사용할 예정
 */