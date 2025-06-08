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
        if(nums.length == 1){
            return nums[0];
        }
        int[] maxMoney = new int[nums.length];
        maxMoney[0] = nums[0];
        maxMoney[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            maxMoney[i] = Math.max(maxMoney[i - 1], maxMoney[i - 2] + nums[i]);
        }
        return maxMoney[nums.length - 1];
    }
}

/***
 * 이 문제는 집을 건너뛰면서 최대로 가질 수 있는 값을 반환하라는 문제이다.
 *
 * 일단 nums가 1개면 그냥 첫번째 값을 리턴하면된다.
 * 그게 아니라면 이제 계산을 해야한다.
 * 일단 0번째 집을 갔을때 최대의 돈은 nums[0]이 되기때문에 세팅한다.
 * 1번째 집까지 있을때 최대의 돈은 nums[0], nums[1]을 비교해서 더 큰집을 찾으면 된다.
 * 그리고 2번째 집부터는 계산을 해야한다.
 * 이 전까지 모은 최대와 이 전전까지 모은 최대+현재값을 비교해서 더 큰 값으로 넣어주면 된다.
 * 그러면 마지막집은 maxMoney[nums.length-1]에 값이 들어가 있을예정이다.
 * 이를 반환하면 된다.
 */