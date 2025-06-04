/*
215. Kth Largest Element in an Array

Given an integer array nums and an integer k, return the kth largest element in the array.

Note that it is the kth largest element in the sorted order, not the kth distinct element.

Can you solve it without sorting?


Example 1:
Input: nums = [3,2,1,5,6,4], k = 2
Output: 5

Example 2:
Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
Output: 4
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
        }
        for (int i = 0; i < k - 1; i++) {
            queue.poll();
        }
        return queue.peek();
    }
}

/***
 * 주어진 정수 배열 nums에서 k번째로 큰 요소를 찾는 문제이다.
 *
 * 최대 힙(PriorityQueue with reverse order)을 생성한다.
 * nums의 모든 원소를 힙에 넣는다.
 * k번째로 큰 수를 찾기 위해 k-1번 poll()하여 가장 큰 값들을 제거한다.
 * 현재 힙의 top 값(peek())이 k번째로 큰 수이다.
 * 이 값을 반환한다.
 */