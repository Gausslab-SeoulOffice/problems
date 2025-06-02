/*
399. Evaluate Division

You are given an array of variable pairs equations and an array of real numbers values, where equations[i] = [Ai, Bi] and values[i] represent the equation Ai / Bi = values[i]. Each Ai or Bi is a string that represents a single variable.

You are also given some queries, where queries[j] = [Cj, Dj] represents the jth query where you must find the answer for Cj / Dj = ?.

Return the answers to all queries. If a single answer cannot be determined, return -1.0.

Note: The input is always valid. You may assume that evaluating the queries will not result in division by zero and that there is no contradiction.

Note: The variables that do not occur in the list of equations are undefined, so the answer cannot be determined for them.


Example 1:
Input: equations = [["a","b"],["b","c"]], values = [2.0,3.0], queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]
Output: [6.00000,0.50000,-1.00000,1.00000,-1.00000]
Explanation:
Given: a / b = 2.0, b / c = 3.0
queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ?
return: [6.0, 0.5, -1.0, 1.0, -1.0 ]
note: x is undefined => -1.0

Example 2:
Input: equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0], queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]
Output: [3.75000,0.40000,5.00000,0.20000]

Example 3:
Input: equations = [["a","b"]], values = [0.5], queries = [["a","b"],["b","a"],["a","c"],["x","y"]]
Output: [0.50000,2.00000,-1.00000,-1.00000]
 */

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            List<String> eq = equations.get(i);
            String a = eq.get(0);
            String b = eq.get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        double[] results = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String start = query.get(0);
            String end = query.get(1);

            if (!graph.containsKey(start) || !graph.containsKey(end)) {
                results[i] = -1.0;
            } else if (start.equals(end)) {
                results[i] = 1.0;
            } else {
                Set<String> visited = new HashSet<>();
                results[i] = dfs(graph, start, end, 1.0, visited);
            }
        }

        return results;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double accProduct, Set<String> visited) {
        visited.add(current);

        if (current.equals(target)) {
            return accProduct;
        }

        Map<String, Double> neighbors = graph.get(current);
        for (Map.Entry<String, Double> entry : neighbors.entrySet()) {
            String next = entry.getKey();
            double value = entry.getValue();

            if (!visited.contains(next)) {
                double result = dfs(graph, next, target, accProduct * value, visited);
                if (result != -1.0) {
                    return result;
                }
            }
        }
        return -1.0;
    }
}

/***
 * 이 문제는 나눗셈을 몇개 주어주고, 쿼리에 대해서 답변을 반환하라는 문제이다.
 *
 * a / b = 2.0은 a → b로 가는 간선이 있고 가중치가 2.0인 그래프를 만들면 된다.
 * 반대로 b → a는 1/2.0 = 0.5가 된다.
 * 즉, 양방향 그래프 + 가중치를 구성하고, 각 쿼리마다 DFS로 경로를 찾고 곱셈 누적을 하면 된다.
 * 쿼리 ["a", "c"]처럼 시작점부터 끝점까지 경로가 있는지 DFS로 탐색한다.
 * 처음 누적 곱(accProduct)은 1.0, 방문했던 노드는 visited에 넣어 중복 탐색 방지한다.
 * 그래프 탐색 중 current → neighbor를 곱하면서 target까지 도달하면 return한다.
 */