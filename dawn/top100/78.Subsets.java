/*
78. Subsets

Given an integer array nums of unique elements, return all possible subsets (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

Example 2:
Input: nums = [0]
Output: [[],[0]]
 */

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        compute(nums, result, new ArrayList<>(), 0);
        return result;
    }

    private void compute(int[] nums, List<List<Integer>> result, List<Integer> list, int index) {
        result.add(new ArrayList<>(list));
        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            compute(nums, result, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}

/***
 * 이 문제는 부분집합을 모두 구하는 문제이다.
 *
 * 백트래킹으로 계속 찾아나가면 된다.
 * 일단 compute라는 함수를 이용한다.
 * result에 list를 추가하면서 list를 업데이트 하면 된다.
 * 인덱스는 0부터 시작하면 된다.
 * 백트래킹으로 맨 뒤에 있는 숫자를 제거하고 업데이트하면서 추가해야하기 때문에 일단 list.add(nums[i])로 숫자를 넣고 compute함수를 index를 증가시켜서 찾는다.
 * list에 있는 제일 마지막 인자를 제거시키면 된다.
 * 이후 result를 반환하면 된다.
 */