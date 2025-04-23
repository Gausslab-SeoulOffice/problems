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
 * 이 문제는 배열이 있을때 k번째로 큰 수를 찾아서 반환하라는 문제이다.
 *
 * 일단 PriorityQueue를 사용한다.
 * 처음부터 오름차순으로 들어갈 수 있도록 Collections.reverseOrder()를 사용한다.
 * 그리고 모든 값을 queue에 넣는다.
 * k-1개 만큼 poll()로 뺀 후에 마지막에 있는 값을 반환해야하기때문에 queue.peek()을 사용해서 반환하면된다.
 */