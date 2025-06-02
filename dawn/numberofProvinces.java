/*
547. Number of Provinces

There are n cities. Some of them are connected, while some are not. If city a is connected directly with city b, and city b is connected directly with city c, then city a is connected indirectly with city c.

A province is a group of directly or indirectly connected cities and no other cities outside of the group.

You are given an n x n matrix isConnected where isConnected[i][j] = 1 if the ith city and the jth city are directly connected, and isConnected[i][j] = 0 otherwise.

Return the total number of provinces.


Example 1:
Input: isConnected = [[1,1,0],[1,1,0],[0,0,1]]
Output: 2

Example 2:
Input: isConnected = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
 */

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int num = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                num++;
                visit(isConnected, visited, i);
            }
        }
        return num;
    }

    private void visit(int[][] isConnected, boolean[] visited, int current) {
        visited[current] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[current][i] == 1 && !visited[i]) {
                visit(isConnected, visited, i);
            }
        }
    }
}

/***
 * 이 문제는 군집이 있을때 독립된 군집이 몇개가 있는지 반환하라는 문제이다.
 *
 * 일단 결과를 나타내는 num을 선언한다.
 * 그리고 방문하는지 확인하는 visited를 선언한다.
 * 처음부터 확인할 예정이다.
 * 일단 처음 방문했을테니 num++를 하고 연결된 노드를 찾아야한다.
 * 일단 방문한 노드의 visited를 true로 변경해주고, 연결된 노드의 특징은 isConnected[current][i]가 1이라는 점이다.
 * 그리고 그 노드를 방문하지 않았다면 visit함수로 다시 방문하면 된다.
 * 이렇게 되면 연결된 노드는 방문해서 true로 바꿔주니 다시 방문하지 않게 되고, 연결되어 있지 않은 노드들은 num++을 하고 방문을한다.
 * 이렇게 되면 독립된 노드들의 개수가 num에 쌓이게 된다.
 * 반복문을 다 돌면 num을 반환하면 된다.
 */