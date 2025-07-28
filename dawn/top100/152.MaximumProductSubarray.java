/*
152. Maximum Product Subarray

Given an integer array nums, find a subarray that has the largest product, and return the product.

The test cases are generated so that the answer will fit in a 32-bit integer.


Example 1:
Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Example 2:
Input: nums = [-2,0,-1]
Output: 0
Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 */

class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int currMax = nums[0];
        int currMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int tempMax = currMax;

            currMax = Math.max(nums[i], Math.max(currMax * nums[i], currMin * nums[i]));
            currMin = Math.min(nums[i], Math.min(tempMax * nums[i], currMin * nums[i]));

            max = Math.max(max, currMax);
        }

        return max;
    }
}

/***
 * 이 문제는 배열 순으로 곱셈을 했을때 최대 수를 찾는 문제이다.
 *
 * 이게 음수가 있을때 음수X음수를 하게 되면 최대 양수가 나올 수 있기때문에 최대 수와 최소 수를 동시에 찾으면서 진행해야한다.
 * [2, 3, -2, 4]
 * 처음엔 2
 * 최댓값: 2
 * 최솟값: 2
 * 다음 3
 * 곱 해볼 수 있는 경우들:
 * 3 (그냥 지금 수)
 * 2 × 3 = 6 (이전 최대와 곱)
 * 2 × 3 = 6 (이전 최소와 곱)
 * 최대: 6, 최소: 3
 * 다음 -2
 * 곱 해볼 수 있는 경우들:
 * -2
 * 6 × -2 = -12 (이전 최대와 곱)
 * 3 × -2 = -6 (이전 최소와 곱)
 * 최대: -2, 최소: -12
 * 다음 4
 * 곱 해볼 수 있는 경우들:
 * 4
 * -2 × 4 = -8
 * -12 × 4 = -48
 * 이후 max를 반환하면 된다.
 */