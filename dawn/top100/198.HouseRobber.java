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
            max[i] = Math.max(max[i - 1], max[i - 2] + nums[i]);
        }
        return max[nums.length - 1];
    }
}

/***
 * 이 문제는 집을 터는데 바로 이웃집을 바로 터는건 어렵고, 띄엄띄엄 털어야하는데 구할 수 있는 돈의 최대를 구하는 문제이다.
 *
 * 일단 nums가 1개라면 바로 그 값을 반환한다.
 * 최대값을 저장해놓기 위해서 max를 선언한다.
 * 현재 내가있는 위치에서 최대값을 저장하는 것이다.
 * max[0]은 맨 처음이니까 nums[0]으로 하면된다.
 * max[1]부터는 큰 수를 찾아서 해야하기 때문에 nums[0]과 nums[1]중에 큰걸 선택한다.
 * 그리고 반복문을 돌려서 max[i-1]이 그 전에 있던 값과 그 전전값에 현재 값을 더한 것 중에 더 큰 수를 max[i]에 넣으면 된다.
 * 이후 max[nums.length-1]을 반환한다.
 */