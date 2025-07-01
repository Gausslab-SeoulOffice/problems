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
        boolean[] visited = new boolean[isConnected.length];

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                num++;
                visit(isConnected, visited, i);
            }
        }
        return num;
    }

    private void visit(int[][] isConnected, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[curr][i] == 1 && !visited[i]) {
                visit(isConnected, visited, i);
            }
        }
    }
}

/***
 * 이 문제는 서로 연결되지 않은 섬이 몇개가 있는지 묻는 문제이다.
 *
 * 일단 방문을 확인해야하기 때문에 boolean[]을 만들어준다.
 * 그리고 전부 돌면서 방문하지 않은게 있다면 연결이 되지 않은 상태이기 때문에 num을 증가시킨다.
 * 그리고 연결된걸 방문해야한다.
 * visit라는 함수를 만들어서 연결된걸 확인해준다.
 * 현재 온건 visit를 true로 만들어주고, 연결된걸 확인하기 위해서 isConnected[curr][i]가 1이고 방문되지 않았으면 visit를 다시 불러서 방문해준다.
 * 최종적으로 num를 반환하면 된다.
 */