/*
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.


Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }
        return new int[] { firstIndex, secondIndex };
    }
}

/***
 * 이 문제는 두 개의 숫자를 가지고 target을 만들 수 있는 수의 인덱스를 반환하라는 문제이다.
 *
 * 일단 firstIndex, secondIndex를 선언한다.
 * 그리고 이중 for문을 돌면서 nums[i]+nums[j]가 target인 수를 찾는다.
 * 이후 firstIndex에다가는 i을 넣고, secondIndex에다가는 j를 넣어준다.
 * 이후 firsIndex, secondIndex를 int[]형태로 반환하면 된다.
 */