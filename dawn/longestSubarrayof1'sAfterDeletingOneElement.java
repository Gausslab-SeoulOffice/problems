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
        int maxLength=0;

        for(int i =0; i<nums.length; i++){
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
        return (maxLength == nums.length) ? maxLength-1 : maxLength;
    }
}

/***
 * 이 문제는 원소 한개를 제거해서 1이 연속해서 나오는 것중에 가장 긴 길이를 반환하는 문제이다.
 *
 * 오른쪽으로 한칸씩 이동해야하기때문에, left를 선언해준다.
 * 내가 바라보고 있는 문자가 0이라면 zeroCount++를 해준다.
 * zero가 1개 이상이라면 오른쪽으로 이동한다.
 * 오른쪽으로 이동하면서 제거하는 왼쪽이 0이라면 zeroCount--를 한다.
 * 오른쪽으로 이동하면서 가장 긴 길이를 maxlength를 업데이트 해준다.
 * 이때 maxLength와 비교대상은 i-left+1-zeroCount를 해줘야한다.
 * zeroCount를 삭제하는 것이기때문이다.
 * 그리고 마지막으로 nums.length랑 같으면 -1을 해서 반환해야한다.
 */