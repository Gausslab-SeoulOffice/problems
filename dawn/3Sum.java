/*
15. 3Sum

Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.


Example 1:
Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Explanation:
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
The distinct triplets are [-1,0,1] and [-1,-1,2].
Notice that the order of the output and the order of the triplets does not matter.

Example 2:
Input: nums = [0,1,1]
Output: []
Explanation: The only possible triplet does not sum up to 0.

Example 3:
Input: nums = [0,0,0]
Output: [[0,0,0]]
Explanation: The only possible triplet sums up to 0.

 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if (sum == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }
                    while (j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}

/***
 * 이 문제는 세 개의 수를 더해서 0이 나오는 쌍을 구하는 것이다.
 * 중복은 없어야한다.
 *
 * 일단 그 수가 무엇인지가 궁금하기 때문에 정렬을 시켜준다.
 * 그리고 인자는 총 3개가 필요하고, 한개를 고정시키고 두개를 움직인다는 느낌으로 진행할 것이다.
 * i라는건 제일 마지막에 움직이는 아이고, 그 숫자가 똑같으면 continue 할것이다.
 * 그리고 나머지 두 개의 포인터가 있고, 한 개는 i 다음수, 한 개는 맨 뒤의 수가 될 것이다.
 * 이제 이 세 개를 더해서 sum이라는 것을 저장한다.
 * sum이 0 이면 이걸 result에 저장해주고, 일단 j는 ++, k는 --를 해준다.
 * 그리고 옮겼는데, 똑같은 숫자면 의미가 없기때문에 다른게 나올때까지 j++과 k--를 해준다.
 * 그리고 sum이 0보다 작으면 더 큰 숫자가 필요하다는 의미이기에 j++를 하고, sum이 0보다 크면 더 작은 숫자가 필요하다는 의미이기에 k--를 한다.
 */