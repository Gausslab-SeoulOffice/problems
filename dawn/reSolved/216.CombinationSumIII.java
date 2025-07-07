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
        if (subList.size() > k) {
            return;
        }
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
 * 이 문제는 k개의 숫자로 n을 만들 수 있는 경우의 수를 찾는 문제이다.
 *
 * 이것도 백트래킹을 사용하는 문제이다.
 * compute함수를 만들어서 한개씩 확인하면 된다.
 * 첫번째 수를 1부터 시작하게 된다.
 * 여기서 만약에 n이 0이고 k개만큼 찾았으면 result에 추가해준다.
 * 그게 아니라면 찾는 과정이다.
 * j는 i부터 시작해서 숫자가 겹치지 않도록 찾아주는 것이다.
 * 일단 i를 subList에 넣고 compute로 다시 다음 숫자를 찾아주면 된다.
 * 그리고 숫자를 빼야하기때문에 remove로 마지막 숫자를 제거해주면서 찾으면 된다.
 * 다음 수를 찾을때는 n에서 j만큼을 빼야하고, 다음 숫자로 넘어가야하기 때문에 j+1을 넘겨주면 된다.
 */