/*
55. Jump Game

You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.

Return true if you can reach the last index, or false otherwise.


Example 1:
Input: nums = [2,3,1,1,4]
Output: true
Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.

Example 2:
Input: nums = [3,2,1,0,4]
Output: false
Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 */

class Solution {
    public boolean canJump(int[] nums) {
        int currMax = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(i > currMax){
                return false;
            }
            currMax = Math.max(currMax, i+nums[i]);
        }
        return true;
    }
}

/***
 * 이 문제는 계단을 다 올라갈 수 있는지 확인하는 문제이다.
 *
 * 현재 갈 수 있는 최대는 currMax로 하고, 계단이 더 길다면 false이다.
 * 이후 currMax를 업데이트 하면서 for문을 돌면 된다.
 * 이후 끝까지 갔다면 true를 반환한다.
 */