/*
77. Combinations

Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].

You may return the answer in any order.



Example 1:
Input: n = 4, k = 2
Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
Explanation: There are 4 choose 2 = 6 total combinations.
Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.

Example 2:
Input: n = 1, k = 1
Output: [[1]]
Explanation: There is 1 choose 1 = 1 total combination.
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        compute(1, n, k, result, new ArrayList<>());
        return result;
    }

    private void compute(int index, int n, int k, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i <= n; i++) {
            list.add(i);
            compute(i + 1, n, k, result, list);
            list.remove(list.size() - 1);
        }
    }
}

/***
 * 이 문제는 1부터 n까지 숫자가 있고, 갯수가 k개인 리스트를 만들어서 반환하라는 문제이다.
 *
 * 일단 결과를 반환하기 위해 result를 만들고, 백트래킹을 위해 compute 함수를 만든다.
 * 인덱스는 1부터 진행될것이다.
 * 지금 만들어지는 list가 k랑 같으면 그 리스트는 다 만든것이기에 result에 추가시킨다.
 * 그게 아니라면 index가 1부터 시작하기 때문에 list에 넣게된다.
 * 그리고 그 다음에 들어올 인자를 계산하기 위해 compute를 다시 부르는데 그 다음 숫자를 넣어야하기 때문에 i+1로 인덱스를 넣어준다.
 * 그리고 list에 숫자를 바꿔야하니까 맨 뒤에 넣은 값을 빼야한다.
 */