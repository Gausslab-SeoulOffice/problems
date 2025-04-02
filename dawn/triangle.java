/*
120. Triangle

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.


Example 1:
Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

Example 2:
Input: triangle = [[-10]]
Output: -10
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] memo = new int[row];

        for (int i = 0; i < row; i++) {
            memo[i] = triangle.get(row - 1).get(i);
        }

        for (int r = row - 2; r >= 0; r--) {
            for (int j = 0; j <= r; j++) {
                memo[j] = Math.min(memo[j], memo[j + 1]) + triangle.get(r).get(j);
            }
        }
        return memo[0];
    }
}

/***
 * 이 문제는 삼각형으로 나오는 배열의 배열을 아래로 내려오면서 덧셈을 할때 최소값을 구하는 문제이다.
 *
 * 생각해보면 아래에서 위로 올라가면서 최소값을 찾으면서 올라가는게 더 좋은 선택이다.
 * 일단 row로 행이 몇개인지 찾는다.
 * 그리고 최소거리를 구할 memo를 선언한다. row만큼 마지막행의 갯수가 나오기 때문에 memo의 개수를 row로 주면 된다.
 * 그리고 memo를 일단 제일 마지막행걸로 복사를 한다.
 * 그리고 아래에서부터 확인을 하면서 갱신을 시켜줄것이다.
 * memo[j]와 그 옆에 있는걸 골라서 최소값이랑 그 위에 있는 값이랑 더해주면서 갱신을 하면된다.
 * 맨위까지 올라가면 memo[0]에 저장이 되기 때문에 memo[0]을 반환한다.
 */