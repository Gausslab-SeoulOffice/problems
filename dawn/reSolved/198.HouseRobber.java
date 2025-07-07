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
        if (nums.length == 1) {
            return nums[0];
        }
        int[] max = new int[nums.length];
        max[0] = nums[0];
        max[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            max[i] = Math.max(max[i - 2] + nums[i], max[i - 1]);
        }
        return max[nums.length - 1];
    }
}

/***
 * 이 문제는 집을 털건데 바로 옆짚은 털수가 없을때 최대로 많이 돈을 가질 수 있는 경우를 찾는 문제이다.
 *
 * 일단 1개짜리라면 nums[0]을 바로 반환한다.
 * max라는 배열을 만들어서 여기에 최대값을 저장할것이다.
 * 일단 max[0]은 nums[0]이고, max[1]은 nums[0]과 nums[1]중에 더 큰 수를 저장하면 된다.
 * 2부터는 더 큰 수를 찾아서 저장하면 된다.
 * 바로 옆집은 안되기 때문에 그 전전집의 max와 현재 값을 더한 값, 그 전집의 max를 비교해서 넣어준다.
 * 이후 nums.length-1번째의 max를 반환하면 된다.
 */