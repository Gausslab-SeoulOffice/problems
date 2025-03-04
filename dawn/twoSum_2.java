/*
1. Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.


Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    firstIndex = i;
                    secondIndex = j;
                }
            }
        }
        return new int[]{firstIndex, secondIndex};
    }
}

/***
 * 한 5번은 풀었던 문제가 오늘의 문제였다.
 * 두개의 숫자를 찾아서 타켓이 맞는지 확인하고 그걸 return하는 문제였다. map문제인데 map은 생각도 안나고 그냥 저렇게만 풀 수 있따.
 *
 * 첫번쨰 인덱스와 두번째 인덱스를 찾을건데 이중for문을 사용한다.
 * 그리고 두개를 더 했을때 target이라면 int[]로 리턴한다.
 */