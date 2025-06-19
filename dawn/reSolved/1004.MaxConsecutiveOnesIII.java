/*
1004. Max Consecutive Ones III

Given a binary array nums and an integer k, return the maximum number of consecutive 1's in the array if you can flip at most k 0's.


Example 1:
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation: [1,1,1,0,0,1,1,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.

Example 2:
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
Bolded numbers were flipped from 0 to 1. The longest subarray is underlined.
 */

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int zeroCount = 0;
        int maxLength = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroCount++;
            }
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, (i - left + 1));
        }
        return maxLength;
    }
}

/***
 * 이 문제는 k개의 수 만큼 0을 1로 바꿀 수 있는데 바꿔서 가장 긴 1의 배열길이를 구하라는 문제이다.
 *
 * 맨 왼쪽부터 확인하면서 한개씩 길이를 업데이트 하면 된다.
 * 일단 맨 왼쪽 인덱스를 위해 left를 선언하고, 0을 바꾼 갯수를 세야하니까 zeroCount, 가장 긴 1의배열 길이를 구하기 위해 maxLength를 선언한다.
 * 이제 왼쪽부터 시작하면서 늘려가야한다.
 * nums[i]가 0이라면 이걸 1로 바꾸기 위해서 zeroCount를 증가시킨다.
 * 바꾼 갯수가 k개를 넘어가면 한개씩 줄여야한다.
 * 바꾼 인덱스를 left로 해놨기 때문에 왼쪽이 0이면 카운트 줄이고 오른쪽으로 이동시켜줘야한다.
 */