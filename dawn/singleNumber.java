/*
136. Single Number

Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.

You must implement a solution with a linear runtime complexity and use only constant extra space.


Example 1:
Input: nums = [2,2,1]
Output: 1

Example 2:
Input: nums = [4,1,2,1,2]
Output: 4

Example 3:
Input: nums = [1]
Output: 1
 */

class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);

        if(nums.length==1){
            return nums[0];
        }

        for(int i = 0; i<nums.length-1; i=i+2){
            if(nums[i] != nums[i+1]){
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

/***
 * 이 문제는 혼자 있는 순자를 찾는 문제이다.
 *
 * 일단 sort로 정렬을 시켜놓는다.
 * 만약 nums가 1갬나 있다면 그게 정답일 것이고,
 * 그게 아니라면 이제 2개씩 확인을 하면 된다.
 * 첫번째 꺼랑 두번째 꺼랑 다르면 그게 정답일 것이고, 반복문을 돌릴때 2씩 증가하면 된다.
 */