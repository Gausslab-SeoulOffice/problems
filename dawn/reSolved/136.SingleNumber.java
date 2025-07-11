/*
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
 */

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

/***
 * 이 문제는 짝이 없는 숫자를 반환하라는 문제이다.
 *
 * 일단 sort로 정렬해 준다.
 * 그리고 for문을 돌면서 확인해줄건데 일단 현재 값이랑 다음 값이 같은지 확인한다.
 * 그리고 같으면 2개씩 넘어간다.
 * 다르면 앞에걸 반환하면 된다.
 * 이후 다 돌리면 맨 뒤에걸 확인해서 반환해준다.
 */