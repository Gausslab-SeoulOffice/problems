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
 * 이 문제는 내가 있는 위치에서 최소한의 숫자로 나가는데 그 횟수가 몇인지 반환하라는 문제이다.
 *
 * 미로의 크기를 저장하고, 시작점을 큐에 넣은 뒤에 해당 위치를 +로 바꿔서 재방문을 막는다.
 * 상하좌우로 이동하기 위해서 directions을 정의해서 이용한다.
 * BFS탐색을 하면서 한단계씩 나갈때마다 steps를 증가한다.
 * 큐애서 현재 위치를 꺼내서 인접한 칸을 탐색한다.
 * 이동 가능한 통로가 미로의 가장자리이면 현재까지의 step을 반환한다.
 * 모두 탐색했는데 출구가 없으면 -1을 반환한다.
 */