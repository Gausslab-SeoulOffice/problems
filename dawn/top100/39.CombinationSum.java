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
        compute(candidates, target, index, total+candidates[index], result, list);
        list.remove(list.size()-1);
        compute(candidates, target, index+1, total, result, list);
    }
}

/***
 * 이 문제는 target을 만드는 조합을 찾는 문제이다.
 *
 * 일단 반복해서 수를 사용할 수 있다.
 * 그렇기 때문에 재귀로 가는데 경우의 수를 두개 생각해야한다.
 * 일단 total이랑 target이랑 같으면 찾은것이기에 result에 추가해준다.
 * total이 target보다 크거나 index가 넘어가면 return으로 끝낸다.
 * 그게 아니라면 일단 list에 수를 담아준다.
 * 그리고 compute로 다시 계산하게 된다.
 * total의 경우 수를 추가했으니까 추가해서 넘겨준다.
 * 그리고 list에서 맨 뒤에 걸 빼고 수를 안담고 다음 인덱스로 넘어가는 경우도 계산해주면 된다.
 */