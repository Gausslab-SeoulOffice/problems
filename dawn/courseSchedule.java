/*
207. Course Schedule

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
Return true if you can finish all courses. Otherwise, return false.



Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
 */

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        int[] visited = new int[numCourses];

        for(int i = 0; i< numCourses; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] pair: prerequisites){
            int course = pair[0];
            int preCourse = pair[1];
            graph[preCourse].add(course);
        }

        for(int i =0;i<numCourses; i++){
            if(!check(i, graph, visited)){
                return false;
            }
        }
        return true;
    }

    private boolean check(int i, List<Integer>[] graph, int[] visited){
        if(visited[i] ==1){
            return false;
        }
        if(visited[i] == 2){
            return true;
        }
        visited[i] = 1;

        for(int next : graph[i]){
            if(!check(next, graph, visited)){
                return false;
            }
        }

        visited[i] = 2;
        return true;
    }
}

/***
 * 이 문제는 수강하려는 과목이 있고, 그 과목을 수강하기 위해서는 선행되어야 하는 과목이 있는데, 모든 과목을 수강할 수 있는 지 묻는 문제이다.
 *
 * 일단 연결된 과목을 확인할 graph를 선언한다. 각 과목별로 연결된 과목이 있기에 List<Integer>[] 이라는 list 배열로 선언하고, 이게 사이클이 있으면 false라는 것을 생각해서 방문을 확인하기 위해 visited를 선언해준다.
 * 그리고 graph를 초기화한다.
 * 입력으로 받은 과목 두 개 중, 첫 번째꺼가 수강하고 싶은거고, 두 번째꺼가 이전에 수강해야하는 과목이다.
 * graph[preCourse]에 수강하고 싶은 과목을 넣어준다.
 * 그리고 이제 한개씩 확인을 해야한다.
 * 확인하는 방법은 이미 방문 중인 노드를 또 방문하려 하면 → 사이클 발생한다.
 * 0은 아직 안간 과목, 1은 지금 방문 중인 과목, 2은 방문이 끝난 과목이다.
 * 과목을 왔는데 아마 방문을 했다면 사이클이기 때문에 false를 반환한다.
 * 2면 이미 끝났기 때문에 그냥 true를 넘기고 넘어간다.
 * 처음온거면, 방문 중인 1로 바꾸고, 그 아래껄로 넘어가서 사이클이 또 있는지 확인하면 된다.
 */