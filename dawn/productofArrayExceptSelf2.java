/*
238. Product of Array Except Self

Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
You must write an algorithm that runs in O(n) time and without using the division operation.



Example 1:
Input: nums = [1,2,3,4]
Output: [24,12,8,6]

Example 2:
Input: nums = [-1,1,0,-3,3]
Output: [0,0,9,0,0]
 */

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = 1;
        }
        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] *= left;
            left *= nums[i];
        }
        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= right;
            right *= nums[i];
        }
        return result;
    }
}

/***
 * 이 문제는 나를 제외한 숫자를 곱한 숫자 배열을 구하라는 문제이다.
 *
 * 일단 결과 값을 구할  result를 선언한다.
 * 그리고 모든 값을 1로 초기화 시켜놓는다.
 * 그리고 왼쪽에 있는 숫자를 모두 먼저 곱한다.
 * result에 일단 left를 곱하고, left값을 업데이트 한다.
 * left값은 nums[i]값을 곱해서 업데이트 시킨다.
 * result에 right를 곱해야한다.
 * right값은 nums[i]값을 곱해서 업데이트 시키는데, 이 때 i는 뒤에서부터 오도록 한다.
 * 이후 다 만들어진 result값을 반환한다.
 */