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
        int[] arrayLenth = new int[nums.length];
        Arrays.fill(arrayLenth, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    arrayLenth[i] = Math.max(arrayLenth[i], arrayLenth[j] + 1);
                }
            }
        }

        int max = 0;
        for (int len : arrayLenth) {
            max = Math.max(max, len);
        }
        return max;
    }
}

/***
 * 이 문제는 증가하는 길이 중 가장 긴걸 반환하라는 문제이다.
 *
 * 일단 모두 자기자신은 가지고 있기 때문에 arrayLenth에 1을 다 넣어준다.
 * 그리고 그 다음 수가 나보다 큰 경우, 즉 nums[i]>nums[j]인 경우에는 증가했기 때문에 +1을 해줄 수 있다.
 * 이arrayLenth 중 가장 큰 수를 반환하기 위해서 max로 찾아준다.
 * 이후 max를 반환한다.
 */