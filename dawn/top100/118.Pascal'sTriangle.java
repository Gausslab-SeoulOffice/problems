/*
118. Pascal's Triangle

Given an integer numRows, return the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:



Example 1:
Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]

Example 2:
Input: numRows = 1
Output: [[1]]
 */

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);

        for(int i=1; i<numRows; i++){
            List<Integer> prev = result.get(i-1);
            List<Integer> curr = new ArrayList<>();
            curr.add(1);

            for(int j= 1; j<i; j++){
                curr.add(prev.get(j-1)+prev.get(j));
            }
            curr.add(1);
            result.add(curr);
        }
        return result;
    }
}

/***
 * 이 문제는 파스칼의 삼각형에서 각 행의 배열을 구하라는 문제이다.
 *
 * 일단 정답을 넣을 result를 선언한다.
 * 그리고 맨 첫줄은 1을 넣어서 선언하고 이걸 result에 넣어둔다.
 * 이후 두번째 줄부터 시작하게 된다.
 * 이전에 가지고 있던 list를 가지고 온다.
 * 그리고 현재 계산해야할 list를 curr로 선언해둔다.
 * curr의 시작은 1로 시작한다.
 * 그리고 그 다음 수는 그 전에 있던 prev에 j-1과 j를 더해서 숫자를 만들어준다.
 * 그리고 curr의 마지막은 1로 채워준다.
 * result에 curr를 넣어준다.
 * 이후 result를 반환하면 된다.
 */