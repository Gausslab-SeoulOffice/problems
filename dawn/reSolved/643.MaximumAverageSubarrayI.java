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
            sum = sum - nums[i - k] + nums[i];
            max = Math.max(max, sum);
        }
        return max / k;
    }
}

/***
 * 이 문제는 연속되는 k개의 숫자를 뽑아서 합한 후 k로 나눈 값을 구하는 문제이다.
 *
 * 여기서 일단 sum을 구한다. 처음부터 k개를 더하면 된다.
 * 근데 sum이 가장 커야하기 때문에 max라는 값으로 업데이트 시켜서 찾아야한다.
 * sum에서 그 다음 값을 더하고 맨 앞에 있는 값들 제거하면 된다.
 * max에서 비교해서 업데이트 하면 가장 큰 연속되는 숫자의 합이 max에 들어가 있는다.
 * k로 나눠서 반환하면된다.
 */