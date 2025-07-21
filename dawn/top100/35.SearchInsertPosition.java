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
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/***
 * 이 문제는 target을 O(log n)안에 찾는 문제이다.
 *
 * 절반으로 나눠야한다는게 확실해졌기 때문에, left, right를 먼저 선언해준다.
 * 그리고 left <= right일때까지 반복한다.
 * mid를 중간값으로 찾아내고 그 값이 target이랑 같다면 mid를 반환한다.
 * nums[mid]가 찾으려는 값보다 크면 더 작은 값에서 검색해야하기 때문에 right를 옮겨준다.
 * 그게 아니라면 더 큰 값에서 검색해야하기 때문에 left를 옮겨준다.
 * 이후 left를 반환하면 된다.
 */