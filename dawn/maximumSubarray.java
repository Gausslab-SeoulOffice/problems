/*
53. Maximum Subarray

Given an integer array nums, find the subarray with the largest sum, and return its sum.



Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int result  = nums[0];
        int total = 0;

        for(int n: nums){
            if(total < 0){
                total = 0;
            }
            total += n;
            result = Math.max(result, total);
        }
        return result;
    }
}

/***
 * 이 문제는 가장 긴 길이의 최대 합을 구하라는 문제이다.
 *
 * 일단 최대값을 저장할 수 있는 result를 선언하고 지금까지 합을 더하는 total이라는 변수를 선언한다.
 * 그리고 입력받은 배열을 끝까지 확인할건데, 이때 total이 0보다 작으면 그냥 0으로 바꿔준다.
 * 그리고 total에 더하고 제일 큰 값을 확인해서 지금 더한 값이 크면 그 값으로, 그 전값이 더 크면 큰 값으로 result를 업데이트 시킨다.
 */