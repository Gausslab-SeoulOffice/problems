/*
1493. Longest Subarray of 1's After Deleting One Element

Given a binary array nums, you should delete one element from it.

Return the size of the longest non-empty subarray containing only 1's in the resulting array. Return 0 if there is no such subarray.


Example 1:
Input: nums = [1,1,0,1]
Output: 3
Explanation: After deleting the number in position 2, [1,1,1] contains 3 numbers with value of 1's.

Example 2:
Input: nums = [0,1,1,1,0,1,1,0,1]
Output: 5
Explanation: After deleting the number in position 4, [0,1,1,1,1,1,0,1] longest subarray with value of 1's is [1,1,1,1,1].

Example 3:
Input: nums = [1,1,1]
Output: 2
Explanation: You must delete one element.
 */

class Solution {
    public int longestSubarray(int[] nums) {
        int left =0;
        int zeroCount=0;
        int maxLength =0;

        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount>1){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, i-left+1-zeroCount);
        }
        return maxLength == nums.length ? nums.length-1 : maxLength;
    }
}

/***
 * 이 문제는 원소를 한개 삭제해서 최대로 긴 1 배열의 길이를 구하는 문제이다.
 * 0을 삭제하면 좋고, 0이 한개도 없으면 1이라도 삭제해야한다.
 *
 * 이전이랑 거의 비슷하다.
 * 왼쪽부터 한개씩 획인하고 0이면 zeroCount를 올려주는 것이다.
 * 근데 1개만 삭제할 수 있으니까 zeroCount가 1보다 커지면 원상복구 시켜놓고 다시 확인해야한다.
 * 여기서 주의할점은 모두 1이 들어가 있는 경우이다.
 * 그러면 1개를 삭제해야하니까 nums.length-1을 반환해야한다.
 */