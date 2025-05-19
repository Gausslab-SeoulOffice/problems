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
        int left =0;
        int maxLength =0;
        int zeroCount =0;

        for(int i =0; i<nums.length; i++){
            if(nums[i]==0){
                zeroCount++;
            }
            while(zeroCount>k){
                if(nums[left]==0){
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, i-left+1);
        }
        return maxLength;
    }
}

/***
 * 이 문제는 0을 최대 k개만큼 1로 바꿔서 가장 긴 길이를 반환하는 문제이다.
 *
 * 일단 왼쪽에서 오른쪽으로 확장해나갈예정이다.
 * 바라보는 확장하면서 바라보는 문자가 0이라면 zeroCount++를 해준다.
 * zeroCount가 k보다 크면 이제 왼쪽에서 한개를 줄이는 방법을 사용할것이다.
 * 그 사라지는 왼쪽 값이 0이면 zeroCount--를해주고 left를 한칸 옮겨야하기에 left++를 해준다.
 * 한칸씩 움직이면서 가장 긴 길이를 확인해서 maxLength를 업데이트 시켜준다.
 * 반복문을 다 돌리면 가장 긴 길이가 maxLength에 있기때문에 리턴해준다.
 */