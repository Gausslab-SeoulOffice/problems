/*
33. Search in Rotated Sorted Array

There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.


Example 1:
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4

Example 2:
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1

Example 3:
Input: nums = [1], target = 0
Output: -1
 */

class Solution {
    public int search(int[] nums, int target) {
        int left =0;
        int right = nums.length-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(nums[mid] == target){
                return mid;
            }
            if(nums[mid]>= nums[left]){
                if(target>=nums[left] && target<nums[mid]){
                    right = mid;
                }else{
                    left = mid+1;
                }
            }else{
                if(target<=nums[right] && target>nums[mid]){
                    left = mid;
                }else{
                    right = mid-1;
                }
            }
        }
        return -1;
    }
}

/***
 * 이 문제는 단어가 오름차순으로 되어 있고 어느 순간부거 뒤쪽으로 이동 되어 있다.
 * 이때 target을 찾아서 인덱스를 반환시키는 문제이다.
 *
 * 일단 mid를 사용하면 되기 때문에 left, right를 인덱스로 정의시킨다.
 * 그리고 left<=right일때까지 반복한다.
 * mid는 left + (right-left)/2로 계산해주고, nums[mid]가 target이랑 같다면 mid를 반환하면 된다.
 * nums[mid]가 nums[left]보다 크고, target이 nums[left]보다 크고 nums[mid]보다 작으면 아래쪽에 있는 것이기 때문에 right를 mid로 옮겨주면 된다.
 * 그게 아니라면 반대쪽이기 때문에 left를 mid+1로 옮겨주어 위쪽을 검사한다.
 * nums[mid]가 nums[left]보다 작으면 숫자가 역전되어 있다는 의미이기에 반대로 가면 된다.
 * 이후 값이 없으면 -1을 반환한다.
 */