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
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.offer(num);
        }
        for (int i = 0; i < nums.length - k; i++) {
            pq.poll();
        }

        return pq.poll();
    }
}

/***
 * 이 문제는 nums에서 정렬이 된다음에 k번째로 큰 수를 반환하라는 문제이다.
 *
 * 숫자를 PriorityQueue에 넣어서 자동으로 정렬이 되게한다.
 * 그 이후에 k번째로 큰수를 가져와야하기때문에 nums.length-k까지 뺀 이후에 그 다음 숫자를 가지고 오면 k번째로 큰 수를 반환하게 된다.
 */