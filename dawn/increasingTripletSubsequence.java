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
        for(int n: nums){
            if(n<=first){
                first = n;
            }else if(n<=second){
                second = n;
            }else{
                return true;
            }
        }
        return false;
    }
}

/***
 * 이 문제는 오름차순으로 배열된 숫자가 3개가 있는지 확인하는 문제이다.
 *
 * 일단 숫자 2개를 가장 큰 수로 설정해 놓는다.
 * 그리고 nums를 확인할건데, first보다 작거나 같으면 first를 n으로 갱신한다.
 * 그리고 다음 숫자로 넘어가게 될텐데, n이 first보다 크고, second보다 작거나 같으면 second를 n으로 갱신한다.
 * 이라고 또 다음 숫자로 넘어가게 될텐데, first, second보다 크면 오름차순으로 된 숫자가 3개가 되었다는 것이기에 true를 반환한다.
 * 반복문이 끝났는데 되지 않았다면 false를 반환한다.
 */