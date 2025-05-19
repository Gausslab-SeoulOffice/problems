/*
643. Maximum Average Subarray I

You are given an integer array nums consisting of n elements, and an integer k.
Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.


Example 1:
Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

Example 2:
Input: nums = [5], k = 1
Output: 5.00000
 */

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        double max = sum;
        for (int i = k; i < nums.length; i++) {
            sum = sum - nums[i-k] + nums[i];
            max = Math.max(max, sum);
        }
        return max/k;
    }
}

/***
 * 이 문제는 k개를 순서대로 골라서 최대값이 나오게 한 후에 k로 나눈 값을 반환하는 문제이다.
 *
 * 일단 k개의 합을 구하기 위해 sum이라는 변수를 선언하고 k개를 더한 값을 sum에 넣어둔다.
 * 그리고 max를 구하기 위해 한칸씩 옆으로 이동하면서 큰 값으로 max를 업데이트한다.
 * 반복분을 다 돌면 max값 /k 를 해서 반환한다.
 */