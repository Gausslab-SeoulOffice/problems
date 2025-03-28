/*
198. House Robber

You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security systems connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array nums representing the amount of money of each house, return the maximum amount of money you can rob tonight without alerting the police.


Example 1:
Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:
Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.
 */

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        int[] result = new int[n];
        result[0] = nums[0];
        result[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            result[i] = Math.max(result[i - 1], nums[i] + result[i - 2]);
        }
        return result[n - 1];
    }
}

/***
 * 이 문제는 집을 터는 도둑이 되는건데, 각 집들을 갈때는 바로 옆집에 갈 수는 없다. 띄엄띄엄 들오거여허는데 이때 구할 수 있는 최대의 값을 구하는 문제이다.
 *
 * 일단 집이 한개라면 그걸 리턴한다.
 * 그리고 두번째부터는 선택의 순간이다. nums[0], nums[1] 중에서 더 큰걸 선책하게 된다.
 * 현재 집을 털면, 이전 집은 못 털어 → nums[i] + result[i - 2]
 * 현재 집을 안 털면, 이전 집까지의 최댓값을 그대로 가져옴 → result[i - 1]
 * 인덱스이니까 n-1을 최종 값으로 리턴하면 된다.
 */