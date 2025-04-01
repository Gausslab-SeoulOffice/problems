/*
300. Longest Increasing Subsequence

Given an integer array nums, return the length of the longest strictly increasing subsequence.


Example 1:
Input: nums = [10,9,2,5,3,7,101,18]
Output: 4
Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4.

Example 2:
Input: nums = [0,1,0,3,2,3]
Output: 4

Example 3:
Input: nums = [7,7,7,7,7,7,7]
Output: 1
 */

class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] lengthArray = new int[n];
        Arrays.fill(lengthArray, 1);

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lengthArray[i] = Math.max(lengthArray[i], lengthArray[j] + 1);
                }
            }
        }
        int max = 0;
        for (int len : lengthArray) {
            max = Math.max(max, len);
        }
        return max;
    }
}

/***
 * 이 문제는 배열중에 오름차순으로 된 가장 긴 배열의 길이를 구하라는 것이다.
 * 올라가기만 하면 된다.
 *
 * 일단 내가 위치한 곳까지 오름차순인것의 갯수를 세기 위해 lengthArray 배열을 한개 만들어준다.
 * 일단 모두 1 값으로 초기화 시켜놓는다.
 * 그리고 지금 값이랑 이전값이랑 비교해서 지금 값이 크면 lengthArray[현재값]의 값을 Math.max로 현재값 vs 1+그 전값으로 비교해서 넣는다.
 * 그리고 lengthArray에서 가장 큰 값을 반환한다.
 */