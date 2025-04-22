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
            int mid = (left + right) / 2;
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
 * 이 문제는 튀어나온 값을 구하라는 문제이다.
 * 근데 시간 복잡도가 O(log n) 이어야한다.
 *
 * 일단 오른쪽 왼쪽을 나눠서 생각하면 된다.
 * 중앙값을 찾아서 그 값이 다음값보다 크면 right를 내값까지 가지고 오는거고,
 * 그게 아니면 반대로 중앙값 다음값이 더 크다는 거니까 left를 중앙값다음값으로 가지고 오면된다.
 * 그렇게 반복하다보면 left<right 이 조건이 끝나는 지점이 있을것이다.
 * 그때 left를 반환하면 솟아오른 값이 반환된다.
 */