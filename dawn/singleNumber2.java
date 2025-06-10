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

        if (nums.length == 1)
            return nums[0];

        for (int i = 0; i < nums.length - 1; i += 2) {
            if (nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }
}

/***
 * 이건 짝이 없이 홀로 있는 숫자가 무엇인지 반환하라는 문제이다.
 *
 * 일단 정렬을 시켜준다.
 * 만약 nums에 담긴게 1개 뿐이라면 그냥 그걸 반환한다.
 * 여러개가 있다면 확인을 해야한다.
 * 짝이 맞다면 현재 있는 수와 그 다음수가 동일해야한다.
 * 그게 아니라면 짝이 맞지 않다는 것이다.
 * 그리고 넘어갈때는 짝이 맞다는 것이니 2칸씩 넘어가야한다.
 */