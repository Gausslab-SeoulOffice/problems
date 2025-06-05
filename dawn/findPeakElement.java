/*
162. Find Peak Element

A peak element is an element that is strictly greater than its neighbors.

Given a 0-indexed integer array nums, find a peak element, and return its index. If the array contains multiple peaks, return the index to any of the peaks.

You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.

You must write an algorithm that runs in O(log n) time.


Example 1:
Input: nums = [1,2,3,1]
Output: 2
Explanation: 3 is a peak element and your function should return the index number 2.

Example 2:
Input: nums = [1,2,1,3,5,6,4]
Output: 5
Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/***
 * 이 문제는 꼭대기를 찾으라는 문제이다.
 * 여러개가 있다면 무엇을 반환해도 상관없다.
 *
 * 일단 중간부터 탐색할 예정이다.
 * 가운데를 찾아서 그 다음에 있는 숫자랑 비교한다.
 * 가운데 숫자가 더 크면 일단 오른쪽보다는 크다는 의미이기에 왼쪽보다 크기만 하면 꼭대기임을 증명하는 것이다.
 * 그렇기에 오른쪽을 mid로 옮겨서 확인하면 된다.
 * 내리막(peak이 왼쪽에 있음): nums[mid] > nums[mid+1] → right = mid
 * 오르막(peak이 오른쪽에 있음): nums[mid] < nums[mid+1] → left = mid + 1
 * 이러다가 left == right가 되는 순간 그 곳이 꼭대기라는 것이다.
 */