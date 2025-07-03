/*
1926. Nearest Exit from Entrance in Maze

You are given an m x n matrix maze (0-indexed) with empty cells (represented as '.') and walls (represented as '+'). You are also given the entrance of the maze, where entrance = [entrancerow, entrancecol] denotes the row and column of the cell you are initially standing at.

In one step, you can move one cell up, down, left, or right. You cannot step into a cell with a wall, and you cannot step outside the maze. Your goal is to find the nearest exit from the entrance. An exit is defined as an empty cell that is at the border of the maze. The entrance does not count as an exit.

Return the number of steps in the shortest path from the entrance to the nearest exit, or -1 if no such path exists.


Example 1:
Input: maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
Output: 1
Explanation: There are 3 exits in this maze at [1,0], [0,2], and [2,3].
Initially, you are at the entrance cell [1,2].
- You can reach [1,0] by moving 2 steps left.
- You can reach [0,2] by moving 1 step up.
It is impossible to reach [2,3] from the entrance.
Thus, the nearest exit is [0,2], which is 1 step away.

Example 2:
Input: maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
Output: 2
Explanation: There is 1 exit in this maze at [1,2].
[1,0] does not count as an exit since it is the entrance cell.
Initially, you are at the entrance cell [1,0].
- You can reach [1,2] by moving 2 steps right.
Thus, the nearest exit is [1,2], which is 2 steps away.

Example 3:
Input: maze = [[".","+"]], entrance = [0,0]
Output: -1
Explanation: There are no exits in this maze.
 */

class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int row = maze.length;
        int col = maze[0].length;
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';

        int[][] directions = new int[][] { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        int steps = 0;
        int x, y;
        while (!queue.isEmpty()) {
            steps++;
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    x = current[0] + direction[0];
                    y = current[1] + direction[1];

                    if (x < 0 || x >= row || y < 0 || y >= col)
                        continue;
                    if (maze[x][y] == '+')
                        continue;

                    if (x == 0 || x == row - 1 || y == 0 || y == col - 1)
                        return steps;
                    maze[x][y] = '+';
                    queue.offer(new int[] { x, y });
                }
            }
        }
        return -1;
    }
}

/***
 * 이 문제는 벽이 있는 미로에서 빠르게 탈출하는 횟수를 구하는 문제이다.
 *
 * queue를 이용해서 풀어줄 예정이다.
 * 갈 수 있는 방향인 상하좌우를 해놓고, 현재 위치를 queue에 넣어두었으니 이걸 이동시키면서 확인하면 된다.
 * 일단 queue가 빌때까지 할건데, 상하좌우를 더해가면서 벽이 아니고, 범위를 넘어가지 않은 경우에만 적용한다.
 * 맨 끝인 출구에 도착하면 step을 반환하면 되고, 그게 아니라면 본인이 온자리는 +로 변경시켜서 벽처럼 활용하면 된다.
 */