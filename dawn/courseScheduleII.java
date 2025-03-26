/*
210. Course Schedule II

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.



Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: [0,1]
Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].

Example 2:
Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
Output: [0,2,1,3]
Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].

Example 3:
Input: numCourses = 1, prerequisites = []
Output: [0]
 */

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] visited = new int[numCourses];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            int course = pair[1];
            int preCourse = pair[0];
            graph[preCourse].add(course);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!check(i, graph, visited, result)) {
                return new int[0];
            }
        }
        return result.stream().mapToInt(i -> i).toArray();
    }

    private boolean check(int i, List<Integer>[] graph, int[] visited, List<Integer> result) {
        if (visited[i] == 1) {
            return false;
        }
        if (visited[i] == 2) {
            return true;
        }
        visited[i] = 1;
        for (int next : graph[i]) {
            if (!check(next, graph, visited, result)) {
                return false;
            }
        }
        visited[i] = 2;
        result.add(i);
        return true;
    }
}

/***
 * 이 문제는 전문제랑 거의 비슷하다.
 * 차이가 있다면 그 순서대로  출력하라는 것이다.
 *
 * 전이랑 비교해서 추가한 부분이 result를 선언하고, 방문이 끝난시점에 result에 그 과목을 추가하는 부분이다.
 */