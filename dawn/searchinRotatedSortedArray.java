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
        int left = 0;
        int right = nums.length-1;
        int mid = 0;

        while(left<=right){
            mid = (left+right)/2;
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
 * 이 문제는 정렬된 배열에서 어떤 기준으로 뒤로 밀린 그런 배열에서 내가 찾고자 하는 target을 시간 복잡도 O(log n)에 찾는 문제이다.
 *
 * 일단 log n이라는건 나눠서 찾으라는 의미이기에 left, right를 선언해준다.
 * 그리고 반복문을 돌릴거고, 일단 중앙값을 찾아놓는다.
 * 중앙값이 target이랑 같으면 그 인덱스를 반환한다.
 * 그리고 이제 확인을 할건데, 처음부터 중앙값까지 정렬이 되어 있는 부분인지 확인한다.
 * 두가지 경우의 수로 나눠서 확인을 하면된다.
 * 찾으려는 값이 제일 왼쪽 값보다 크고, 중앙 값보다 작으면 그 앞에 있는거기때문에, right를 중앙값으로 업데이트시키고, 그게 아니면 뒤에 있는거기에 left를 중앙값 다음값으로 업데이트 하면 된다.
 * 다른 경우의 수도 비슷하지만 반대로 작성하면 된다.
 * 반복문을 다 돌렸는데 없으면 그건 그냥 값이 없다는 것이기에 -1를 반환한다.
 */