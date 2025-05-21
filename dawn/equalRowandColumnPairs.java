/*
2352. Equal Row and Column Pairs

Given a 0-indexed n x n integer matrix grid, return the number of pairs (ri, cj) such that row ri and column cj are equal.

A row and column pair is considered equal if they contain the same elements in the same order (i.e., an equal array).


Example 1:
Input: grid = [[3,2,1],[1,7,6],[2,7,7]]
Output: 1
Explanation: There is 1 equal row and column pair:
- (Row 2, Column 1): [2,7,7]

Example 2:
Input: grid = [[3,1,2,2],[1,4,4,5],[2,4,2,2],[2,4,2,2]]
Output: 3
Explanation: There are 3 equal row and column pairs:
- (Row 0, Column 0): [3,1,2,2]
- (Row 2, Column 2): [2,4,2,2]
- (Row 3, Column 2): [2,4,2,2]
 */

class Solution {
    public int equalPairs(int[][] grid) {
        int count = 0;
        Map<List<Integer>, Integer> map = new HashMap<>();

        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[i][j]);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }

        for (int i = 0; i < grid.length; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < grid.length; j++) {
                list.add(grid[j][i]);
            }
            if (map.containsKey(list)) {
                count += map.get(list);
            }
        }
        return count;
    }
}

/***
 * 이 문제는 가로 세로줄을 비교해서 같은 것이 몇 번 나오는지 확인하는 문제이다.
 *
 * 일단 카운팅 할 수 있도록 count 변수를 선언해준다.
 * 그리고 가로부터 확인해서 map에 넣을 것이다.
 * map에 넣을땐 list형태, 횟수 형태로 넣을 수 있게한다.
 * 그리고 세로를 넣을때 카운팅 하는 것이다.
 * count에 넣을 조건은 map에 이미 list가 키값으로 있으면 넣을 예정이다.
 * count방법은 map.get(list)를 해서 몇개가 이미 있는지 확인해서 있는건 모두 겹친다는 의미이기에 count에 더해준다.
 * 이후 count를 반환하면된다.
 */