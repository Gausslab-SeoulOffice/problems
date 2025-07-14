/*
1466. Reorder Routes to Make All Paths Lead to the City Zero

here are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

It's guaranteed that each city can reach city 0 after reorder.


Example 1:
Input: n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
Output: 3
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 2:
Input: n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]
Output: 2
Explanation: Change the direction of edges show in red such that each node can reach the node 0 (capital).

Example 3:
Input: n = 3, connections = [[1,0],[2,0]]
Output: 0
 */

class Solution {
    int dfs(List<List<Integer>> al, boolean[] visited, int from) {
        int change = 0;
        visited[from] = true;
        for (var to : al.get(from))
            if (!visited[Math.abs(to)])
                change += dfs(al, visited, Math.abs(to)) + (to > 0 ? 1 : 0);
        return change;
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> al = new ArrayList<>();
        for(int i = 0; i < n; ++i)
            al.add(new ArrayList<>());
        for (var c : connections) {
            al.get(c[0]).add(c[1]);
            al.get(c[1]).add(-c[0]);
        }
        return dfs(al, new boolean[n], 0);
    }
}

/***
 * 이 문제는 방향이 있는 간선으로 구성된 트리가 주어질때, 모든 노드에서 노드 0번 (city zero) 으로 가는 경로가 존재하도록 간선 방향을 최소 몇 개 뒤집어야 하는지 묻는 문제이다.
 *
 * 간선이 u → v 라는 방향이면, 이건 v → 0 경로에 방해가 되는 방향일 수 있다.
 * 따라서, 모든 간선을 무방향 그래프처럼 순회하면서, 정방향 간선 (from → to) 을 뒤집어야만 city 0으로 경로를 만들 수 있다.
 * 반대 방향으로 이미 연결된 경우는 뒤집을 필요 없다.
 * dfs함수는 from 노드에서 DFS를 시작한다.
 * 인접한 노드 중 아직 방문하지 않은 노드로 재귀 호출한다.
 * to > 0이면 실제 입력 방향 from → to이므로, 방향을 반대로 바꿔야 하므로 +1이다.
 * to < 0이면 to → from 형태이므로 그대로 두면 되므로 +0이다.
 */