/*
209. Minimum Size Subarray Sum

Given an array of positive integers nums and a positive integer target, return the minimal length of a
subarray whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.



Example 1:
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.

Example 2:
Input: target = 4, nums = [1,4,4]
Output: 1

Example 3:
Input: target = 11, nums = [1,1,1,1,1,1,1,1]
Output: 0
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLen = nums.length + 1;
        int left = 0;
        int currSum = 0;

        for (int right = 0; right < nums.length; right++) {
            currSum += nums[right];

            while (currSum >= target) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                }
                currSum -= nums[left];
                left++;
            }
        }
        if (minLen == nums.length + 1) {
            return 0;
        } else {
            return minLen;
        }
    }
}

/***
 * 이 문제는 잘 읽어야한다.
 * nums라는 배열이 주어지고, target이라는 수가 주어진다. target보다 크거나 같아지는 수들의 합이 있을텐데, 그 처음과 끝의 길이의 최소를 return하라는 것이다.
 *
 * 일단 최소 길이를 찾아야하니까 제일 길게 해서 선언해준다.
 * 그리고 left인덱스와, 합을 업데이트 해야해서 선언한다.
 * 그리고 이제 합을 구할것이다. 오른쪽으로 계속 가면서 더해준다.
 * 그 합이 target보다 크거나 같을때 이제 맨 왼쪽에 있던 left-right+1로 길이를 찾아서 그 전보다 작은지 확인 후, 작으면 업데이트 시킨다. 그리고 또 다른 답이 있을 수 있기에 currSum에서 왼쪽 값을 빼고, 왼쪽을 옮겨온다.
 * 최종적으로 minLen을 나올 수 없는 수로 처음에 선언했는데 그 값이라면 답이없다는 뜻이다.
 * 답이 없으면 0을 return 하고 있으면 답을 return한다.
 */