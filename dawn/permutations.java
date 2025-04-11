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
        compute(visited, new ArrayList<>(), result, nums);
        return result;
    }

    private void compute(boolean[] visited, List<Integer> list, List<List<Integer>> result, int[] nums){
        if(list.size() == nums.length){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i<nums.length; i++){
            if(visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            compute(visited, list, result, nums);
            list.remove(list.size()-1);
            visited[i] = false;
        }
    }
}

/***
 * 이 문제는 순서를 바꿔서 만들 수 있는 모든 배열의 조합을 만들어 반환하라는 문제이다.
 *
 * 일단 결과를 담을 result를 생성하고 원소가 갔는지 안갔는지 확인하기 위해 visited를 선성한다.
 * 그리고 백트래킹을 한다.
 * list에 담긴게 모두 담긴거라면 result에 넣고 return;한다.
 * 그게 아니라면 visited를 확인하고 true면 계속 진행한다. 이건 이미 쓴 숫자는 건너뛴다는 의미이다.
 * 방문하면 일단 true로 바꾸고, list에 값을 넣고, 그 다음 값을 넣기 위해 compute를 다시 진행시킨다.
 * 맨 뒤에 추가 시킨걸 또 없애고, 다음걸 진행하기 위해 visited도 false로 다시 초기화 시켜주면 된다.
 */