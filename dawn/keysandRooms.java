/*
841. Keys and Rooms

There are n rooms labeled from 0 to n - 1 and all the rooms are locked except for room 0. Your goal is to visit all the rooms. However, you cannot enter a locked room without having its key.

When you visit a room, you may find a set of distinct keys in it. Each key has a number on it, denoting which room it unlocks, and you can take all of them with you to unlock the other rooms.

Given an array rooms where rooms[i] is the set of keys that you can obtain if you visited room i, return true if you can visit all the rooms, or false otherwise.


Example 1:
Input: rooms = [[1],[2],[3],[]]
Output: true
Explanation:
We visit room 0 and pick up key 1.
We then visit room 1 and pick up key 2.
We then visit room 2 and pick up key 3.
We then visit room 3.
Since we were able to visit every room, we return true.

Example 2:
Input: rooms = [[1,3],[3,0,1],[2],[0]]
Output: false
Explanation: We can not enter room number 2 since the only key that unlocks it is in that room.
 */

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] visited = new boolean[rooms.size()];
        visit(rooms, visited, 0);
        for (boolean visit : visited) {
            if (!visit) {
                return false;
            }
        }
        return true;
    }

    private void visit(List<List<Integer>> rooms, boolean[] visited, int current) {
        visited[current] = true;
        for (int k : rooms.get(current)) {
            if (!visited[k]) {
                visit(rooms, visited, k);
            }
        }
    }
}

/***
 * 이 문제는 각 방에 들어가 있는 키를 가지고 들어갈 수 있는 방을 탐색한 후에 모든 방을 다 방문할 수 있는지 묻는 문제이다.
 *
 * 이 문제는 한개씩 연결되서 찾아나가야하는 문제이다.
 * 연결되어 있으면 모두 찾아내서 다 true가 되어있다.
 * 일단 방문한 것을 표현하기 위해 visited라는 배열을 만들어준다.
 * 개수는 room의 크기와 같으면 된다.
 * 그리고 처음에 방문은 0번째 노드부터 가기때문에 visit(room, visited, 0)으로 시작한다.
 * visit 함수 같은 경우에는 현재 내가 들어와 았는 방의 visited를 들어왔기 때문에 true로 설정해주고 시작한다.
 * 내가 온 곳 다음으로 방문할 곳이 visited가 된 방이 아니라면 처음가는 방이기 때문에 visit로 다시 가주게 된다.
 * 다 하고 나서는 visited를 확인해서 false인 곳이 있다면 절대 못가는 곳이 있다는 의미이기에 false를 반환하면 된다.
 */