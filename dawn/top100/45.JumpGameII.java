/*
45. Jump Game II

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].


Example 1:
Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [2,3,0,1,4]
Output: 2
 */

class Solution {
    public int jump(int[] nums) {
        int currMax = nums[0];
        int jump = 0;
        int lastMax = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > lastMax) {
                jump++;
                lastMax = currMax;
            }
            currMax = Math.max(currMax, nums[i] + i);
        }
        return jump;
    }
}

/***
 * 이 문제는 최소의 step으로 이 계단을 다 넘어가는 수를 구하는 문제이다.
 *
 * int currMax        // 현재 위치에서 도달할 수 있는 가장 먼 거리
 * int jump = 0;           // 점프 횟수
 * int lastMax = 0;        // 이전 점프에서 도달할 수 있는 가장 먼 거리
 * 지금 거리보다 계단이 더 길다면 jump를 해야한다.
 * 이 경우 lastMax를 currMax로 업데이트 해주면 된다.
 * 그리고 currMax를 다시 업데이트 해주면 된다.
 * 이후 jump를 반환한다.
 */