/*
39. Combination Sum

Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if the frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations that sum up to target is less than 150 combinations for the given input.


Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []
 */

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        compute(candidates, target, 0, 0, result, new ArrayList<>());
        return result;
    }

    private void compute(int[] candidates, int target, int index, int total, List<List<Integer>> result,
                         List<Integer> list) {
        if (total == target) {
            result.add(new ArrayList<>(list));
            return;
        }

        if (total > target || index >= candidates.length) {
            return;
        }

        list.add(candidates[index]);
        compute(candidates, target, index, total + candidates[index], result, list);
        list.remove(list.size() - 1);
        compute(candidates, target, index + 1, total, result, list);
    }
}

/***
 * 이 문제는 target을 이룰 수 있는 집합을 구하는것과 같다.
 *
 * 한개 넣고 확인하고 뒤로 돌아가서 거기서 더 추가하고 하는 백트래킹을 사용할 예정이다.
 * 일단 결과를 담을 수 있는 result를 선언하고 함수를 따로 빼준다.
 *
 * 이 함수에서는 일단 total이라는 지금 list에 담긴 수를 확인하는 총합이 있다,
 * 총합과 target이 같으면 그걸 reuslt에 추가하고, return;하면 된다.
 * total이 target보다 크면 안되고, index가 범위를 넘어가면 안되기 때문에  그런 경우 바로 return;한다.
 * 그게 아닌 경우엔 이게 찾으면 된다.
 * list에 추가할건데, 지금 가지고 있는 index를 가지고 숫자를 추가해준다.
 * 그리고 다시 함수를 부르게 되고, 이를 통해 target이 될때까지 compute함수가 계속 돌아갈 것이다.
 * 이제 그게 아닌경우엔 숫자 한개를 빼야하기 때문에 list에서 마지막에 들어간 숫자를 빼준다.
 * 그리고 index를 다음걸로 옮긴 후 그 숫자를 넣어줘야하기 떄문에 index +1로 바꿔서 compute를 돌리면 된다.
 */