/*
 * 55. Jump Game
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, which makes it impossible to reach the last index.
 *
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
 *이 문제는 일단 첫번째 인덱스에 내가 서있다고 생각하면 된다. 그리고 마지막 인덱스가 골인지점인거다.
 * [2, 3, 1, 1, 4] 이렇게 있으면 일단 난 2에 서 있어서 1,2만큼 움직일 수 있다.
 * 내가 갈 수 있는 최대를 일단 알아보고, 루프를 다 돌았을때 내가 갈 수 있는 최대 범위보다 인덱스가 더 높아지면 난 false가 되고, 그게 아니라면 true가 되는것이다.
 * 생각보다 코드는 짧다.
 */