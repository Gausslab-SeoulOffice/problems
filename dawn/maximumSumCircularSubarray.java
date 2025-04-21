/*
918. Maximum Sum Circular Subarray

Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.

A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].

A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.


Example 1:
Input: nums = [1,-2,3,-2]
Output: 3
Explanation: Subarray [3] has maximum sum 3.

Example 2:
Input: nums = [5,-3,5]
Output: 10
Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

Example 3:
Input: nums = [-3,-2,-3]
Output: -2
Explanation: Subarray [-2] has maximum sum -2.
 */

class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0;

        int maxSum = nums[0];
        int currMax = 0;
        int minSum = nums[0];
        int currMin = 0;

        for (int n : nums) {
            total += n;
            currMax = Math.max(currMax + n, n);
            maxSum = Math.max(maxSum, currMax);

            currMin = Math.min(currMin + n, n);
            minSum = Math.min(minSum, currMin);
        }
        if (maxSum < 0) {
            return maxSum;
        }
        return Math.max(maxSum, total - minSum);
    }
}


/***
 * 이 문제는 배열이 연결되어 있다고 생각할때, 최대합을 구하는 문제이다.
 *
 * 일단 일반적인 연속적인 합을 maxSum이라고 하고, 연속적인 최소합을 minSum이라고 할건데, 이렇게 되면 maxSum이랑 total-minSum중에 큰걸 반환하면 되는것이다.
 * 예외가 있다면 모든 원소가 마이너스이면, 그땐 maxSum을 출력하면 된다.
 */