/*
35. Search Insert Position

Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.



Example 1:
Input: nums = [1,3,5,6], target = 5
Output: 2

Example 2:
Input: nums = [1,3,5,6], target = 2
Output: 1

Example 3:
Input: nums = [1,3,5,6], target = 7
Output: 4
 */

class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;

    }
}

/***
 * logn으로 target의 인덱스를 찾거나 없으면 들어갈 곳의 인덱스를 반환하라는 문제이다.
 *
 * 오른쪽, 왼쪽 인덱스를 가지고 찾으면 된다.
 * 절반에 있는 숫자를 확인하고, 같으면 그 인덱스인 mid를 반환.
 * 작으면 left를 mid 다음걸로 옮기고, 크면 right를 mid전껄로 옮긴다.
 * while문이 다 돌았는데 없다면 left를 반환하면 된다.
 */