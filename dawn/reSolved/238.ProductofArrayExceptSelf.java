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
 * 이 문제는 본인을 제외하고 왼쪽, 오른쪽에 있는 값을 다 곱한 리스트를 반환하라는 문제이다.
 *
 * 일단 값을 저장하기 위해서 int[]를 선언한다.
 * 그리고 각각 값에 본인을 제외한 왼쪽 값들과 오른쪽값들을 곱해주면된다.
 * left를 1로 먼저 선언하고 왼쪽에서부터 시작한다.
 * 왼쪽 값을 일단 곱하고, 왼쪽 값을 업데이트 하면된다.
 * 왼쪽값은 현재 값에서 내 자신을 곱하면 그 다음에 곱할 값이 되기 때문에 nums[i]를 곱해서 업데이트 시켜준다.
 * 오른쪽 값도 비슷하다.
 * 오른쪽부터 시작하면 되기 때문에 for문을 돌릴때 큰 수부터 돌리면 된다.
 * 오른쪽 값을 일단 곱하고, 오른쪽 값을 업데이트 하면된다.
 * 오른쪽 값은 현재 값에서 내 자신을 곱하면 그 다음에 곱할 값이 되기 때문에 nums[i]를 곱해서 업데이트 시켜준다.
 * 이후에 result를 반환하면 된다.
 */