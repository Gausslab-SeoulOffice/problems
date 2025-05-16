/*
1679. Max Number of K-Sum Pairs

You are given an integer array nums and an integer k.

In one operation, you can pick two numbers from the array whose sum equals k and remove them from the array.

Return the maximum number of operations you can perform on the array.


Example 1:
Input: nums = [1,2,3,4], k = 5
Output: 2
Explanation: Starting with nums = [1,2,3,4]:
- Remove numbers 1 and 4, then nums = [2,3]
- Remove numbers 2 and 3, then nums = []
There are no more pairs that sum up to 5, hence a total of 2 operations.

Example 2:
Input: nums = [3,1,3,4,3], k = 6
Output: 1
Explanation: Starting with nums = [3,1,3,4,3]:
- Remove the first two 3's, then nums = [1,4,3]
There are no more pairs that sum up to 6, hence a total of 1 operation.
 */

class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int secondNum = k - nums[i];
            if (map.containsKey(secondNum) && map.get(secondNum) > 0) {
                count++;
                map.put(secondNum, map.get(secondNum) - 1);
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}

/***
 * 이 문제는 더해서 k가 만들어지는 쌍을 찾을건데 몇개를 만들 수 있는지 묻는 문제이다.
 *
 * 일단 이 숫자로 몇개를 만들 수 있는지 확인하는 map을 한개 만들어준다.
 * 그리고 숫자를 카운팅해야하기때문에 count변수를 선언한다.
 * for문을 돌면서 만들 수 있는 쌍을 확인해야한다.
 * 현재 수를 가지고 내가 필요한 수가 무엇인지 k-nums[i]로 구한다.
 * 그리고 필요한 수가 map에 있고, 사용할 수 있는 수가 0이상이면 count++로 추가한 후에, 사용했으니까 사용횟수만큼 빼준다.
 * 그게 아니라면 만들어진게 없다는 의미이기에 map에 추가해주어야한다.
 * (현재 가지고 있는 숫자, 1)로 map에 넣어준다.
 */