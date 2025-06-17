/*
283. Move Zeroes

Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

Note that you must do this in-place without making a copy of the array.


Example 1:
Input: nums = [0,1,0,3,12]
Output: [1,3,12,0,0]

Example 2:
Input: nums = [0]
Output: [0]
 */

class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}

/***
 * 이 문제는 0을 맨 뒤로 보내라는 문제이다.
 *
 * left는 0 이 아닌 숫자를 보내려는 인덱스공간이다.
 * 처음부터 확인하면서 지나갈 예정이다.
 * 0이 아니라면 left위치로 가져다 놓을거고, 그 자리는 찼으니까 left++로 옮겨준다.
 * 그러면 배열을 복사하지 않고 그냥 움직이는걸로 가능하다.
 */