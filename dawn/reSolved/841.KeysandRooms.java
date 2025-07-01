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

    private void visit(List<List<Integer>> rooms, boolean[] visited, int curr) {
        visited[curr] = true;
        for (int k : rooms.get(curr)) {
            if (!visited[k]) {
                visit(rooms, visited, k);
            }
        }
    }
}

/***
 * 이 문제는 방에 각 방의 키가 놓여져있고, 모든 방을 다 들어갈 수 있는지 확인하는 문제이다.
 *
 * 일단 맨 처음은 0부터 시작하기 때문에 vistit(rooms, visited, 0)으로 시작한다.
 * 그리고 간 곳은 확인을 해야하기 때문에 visited에 확인을한다.
 * 만약 안간 곳이 발행하면 false를 반환한다.
 * visit함수는 지금 있는 곳에 왔다는 표시를 하고 방에 있는 key를 확인해서 계속 타고타고 가서 확인을 하는 것이다.
 */