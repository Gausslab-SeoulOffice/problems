/*
216. Combination Sum III

Find all valid combinations of k numbers that sum up to n such that the following conditions are true:

Only numbers 1 through 9 are used.
Each number is used at most once.
Return a list of all possible valid combinations. The list must not contain the same combination twice, and the combinations may be returned in any order.



Example 1:
Input: k = 3, n = 7
Output: [[1,2,4]]
Explanation:
1 + 2 + 4 = 7
There are no other valid combinations.

Example 2:
Input: k = 3, n = 9
Output: [[1,2,6],[1,3,5],[2,3,4]]
Explanation:
1 + 2 + 6 = 9
1 + 3 + 5 = 9
2 + 3 + 4 = 9
There are no other valid combinations.

Example 3:
Input: k = 4, n = 1
Output: []
Explanation: There are no valid combinations.
Using 4 different numbers in the range [1,9], the smallest sum we can get is 1+2+3+4 = 10 and since 10 > 1, there are no valid combination.
 */

class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> subList = new ArrayList<>();
        compute(result, subList, k, n, 1);
        return result;
    }

    private void compute(List<List<Integer>> result, List<Integer> subList, int k, int n, int i) {
        if (subList.size() > k)
            return;
        if (n == 0 && subList.size() == k) {
            result.add(new ArrayList<>(subList));
        }
        for (int j = i; j <= 9; j++) {
            subList.add(j);
            compute(result, subList, k, n - j, j + 1);
            subList.remove(subList.size() - 1);
        }
    }
}

/***
 * 이 문제는 n의 숫자를 만드는건데 숫자는 k개를 이용해서 만들 수 있는 조합을 반환하라는 문제이다.
 *
 * 이것도 백트래킹을 이용하는 문제이다.
 * 일단 결과를 담을 수 있는 List<List<Integer>> result를 선언해주고, 그 안에 들어갈 List를 subList로 만들어준다.
 * 그리고 함수를 돌리면서 백트래킹을 하면 된다.
 * compute함수에서 계산을 하는데 담긴 배열이 k보다 크면 안되기 때문에 k보다 크면 retrun;을 시킨다.
 * n이 0이고 sublist가 k랑 같으면 다 n을 딱 맞춘거고, k개라는 조건도 딱 맞춘것이기 때문에 result에 담아야한다.
 * 그게 아니면 아직 찾는 중이라는 의미이다.
 * 찾을때는 1부터 9까지 숫자를 사용해서 조합을 만들어야한다.
 * 맨 처음 1로 찾을 예정이기에 j는 i 부터 9까지 돌릴예정이다.
 * subList에 j를 담고 그 다음 숫자를 찾아야한다.
 * 그러면 n-j를 해줘야 다음 합을 구할 수 있을거고, i가 들어갔기때문에 i+1을 해서 1이였다면 2부터 찾을 수 있도록 해야한다.
 * 그리고 한개를 찾으면 다시 원래 상태로 돌아가서 다시 구해야하기때문에 subList에 있는 마지막 원소를 삭제할 수 있도록 한다.
 */