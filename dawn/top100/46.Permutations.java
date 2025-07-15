/*
46. Permutations

Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.


Example 1:
Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

Example 2:
Input: nums = [0,1]
Output: [[0,1],[1,0]]

Example 3:
Input: nums = [1]
Output: [[1]]
 */

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        compute(nums, visited, result, new ArrayList<>());
        return result;
    }

    private void compute(int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            list.add(nums[i]);
            compute(nums, visited, result, list);
            list.remove(list.size() - 1);
            visited[i] = false;
        }
    }
}

/***
 * 이 문제는 nums를 이용해서 만들 수 있는 조합을 구하는 문제이다.
 *
 * 일단 방문을 했는지 안했는지 배열을 통해 계산할 수 있다.
 * 방문을 했으면 이미 썻다는 의미니까 넘어가면 된다.
 * 방문을 안했으면 그 수를 list에 넣고 compute를 다시 돌리면 된다.
 * 그러면 순서대로 들어가게 되고, list.remove를 통해 제일 마지막에 들어간 수를 빼고 다시 검색할 수 있게 된다.
 * 이후 list에 들어간 숫자들과 nums의 길이가 같아지게 되면 그 list를 result에 추가한다.
 * 이후 result를 반환하면 된다.
 */