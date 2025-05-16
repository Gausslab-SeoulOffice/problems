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
        int left =0;
        for(int i =0; i< nums.length;i++){
            if(nums[i]!=0){
                int temp = nums[i];
                nums[i] = nums[left];
                nums[left] = temp;
                left++;
            }
        }
    }
}

/***
 * 이 문제는 0을 맨 뒤로 움직이라는 것이다.
 *
 * 일단 순서대로 돌면서 확인할 것이다.
 * 지금 있는 위치의 숫자가 0이 아니면 자리를 변경해줄 것이다.
 * 그렇게 하다보면 0은 밀려나고 그 외의 숫자들은 swap되서 앞으로 옮겨지게 된다.
 */