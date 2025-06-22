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
        Map<List<Integer>, Integer> map = new HashMap<>();
        int count = 0;

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
 * 이 문제는 가로에 있는 숫자의 list와 세로로 만든 숫자의 list가 겹치는 횟수를 반환하라는 문제이다.
 *
 * 일단 가로에 있는 숫자들의 list부터 map에 저장해준다.
 * 그리고 세로로 있는 숫자들을 list로 만들고, 기존에 있던 map에 있으면 카운팅을 해줘야한다.
 * map에서 기존에 저장된 수를 가지고 와서 count에 더해주면 된다.
 * 다 돌리고 나면 count를 반환한다.
 */