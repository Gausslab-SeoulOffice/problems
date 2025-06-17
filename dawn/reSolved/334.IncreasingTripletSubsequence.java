/*
334. Increasing Triplet Subsequence

Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.


Example 1:
Input: nums = [1,2,3,4,5]
Output: true
Explanation: Any triplet where i < j < k is valid.

Example 2:
Input: nums = [5,4,3,2,1]
Output: false
Explanation: No triplet exists.

Example 3:
Input: nums = [2,1,5,0,4,6]
Output: true
Explanation: The triplet (3, 4, 5) is valid because nums[3] == 0 < nums[4] == 4 < nums[5] == 6.
 */

class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= first) {
                first = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}

/***
 * 이 문제는 인덱스가 커질 수록 숫자도 커지는 부분이 있는지 확인하는 문제이다.
 *
 * for문 안에서 3개의 숫자가 존재하는지 확인하면 된다.
 * 일단 숫자를 가지고 와서 first보다 작거나 같은지 확인한다.
 * 작거나 같으면 그걸 일단 first로 만들어둔다.
 * 그리고 다음 숫자로 넘어가서 그게 second보다 작은지 확인한다.
 * 작거나 같으면 그걸 일단 second로 만들어둔다.
 * 그리고 그 다음 숫자를 가지고와서 first, second를 돌려본다.
 * 그렇게 되면 맨 처음엔 랜덤숫자가 들어갈텐데, 돌릴수록 오름차순 first, second가 들어가게된다.
 * 이후 마지막 else까지 통과한다면, 오름차순 3개의 숫자가 다 있다는 의미이기에 true를 반환하고, for문을 돌렸는데 없다면 3개의 오름차순 숫자가 없다는 의미이기에 false를 반환한다.
 */