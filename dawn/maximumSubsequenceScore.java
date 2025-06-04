/*
2542. Maximum Subsequence Score

You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. You must choose a subsequence of indices from nums1 of length k.

For chosen indices i0, i1, ..., ik - 1, your score is defined as:

The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
Return the maximum possible score.

A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.


Example 1:
Input: nums1 = [1,3,3,2], nums2 = [2,1,3,4], k = 3
Output: 12
Explanation:
The four possible subsequence scores are:
- We choose the indices 0, 1, and 2 with score = (1+3+3) * min(2,1,3) = 7.
- We choose the indices 0, 1, and 3 with score = (1+3+2) * min(2,1,4) = 6.
- We choose the indices 0, 2, and 3 with score = (1+3+2) * min(2,3,4) = 12.
- We choose the indices 1, 2, and 3 with score = (3+3+2) * min(1,3,4) = 8.
Therefore, we return the max score, which is 12.

Example 2:
Input: nums1 = [4,2,3,1,1], nums2 = [7,5,10,9,6], k = 1
Output: 30
Explanation:
Choosing index 2 is optimal: nums1[2] * nums2[2] = 3 * 10 = 30 is the maximum possible score.
 */

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int[][] pair = new int[n][2];
        for (int i = 0; i < n; i++) {
            pair[i] = new int[] { nums2[i], nums1[i] };
        }
        Arrays.sort(pair, (a, b) -> b[0] - a[0]);

        long sum = 0;
        long result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int[] p : pair) {
            pq.add(p[1]);
            sum += p[1];
            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                result = Math.max(result, (sum * (long) p[0]));
            }
        }
        return result;
    }
}

/***
 * 이 문제는 k개 만큼 각 숫자를 빼서 nums1에서는 덧셈, nums2에서는 그 중에 가장 작은걸 곱해서 나온 수중에 가장 큰수를 반환하라는 문제이다.
 *
 * 일단 중요한 포인트중 한개는 nums2에서는 가장 작은 수를 곱한다는 건데, 그럴때 가장 크려면 곱하는 숫자가 가장 크고 앞에 더하는 숫자도 제일 커야한다.
 * 그럼 nums2에 들어가는 숫자가 가장 커야한다.
 * 각 인덱스의 (nums2[i], nums1[i]) 값을 쌍(pair) 으로 묶어서, nums2[i] 값을 기준으로 내림차순 정렬하려는 것이다.
 * 예를 들면, nums1 = [3, 1, 3, 2], nums2 = [2, 4, 1, 5]이 있다고 할 때,
 * 정렬 전:
 * pair = [[2,3], [4,1], [1,3], [5,2]]
 * 정렬 후 (nums2 기준 내림차순):
 * pair = [[5,2], [4,1], [2,3], [1,3]]
 * 이제 이 순서대로 반복하면서 nums2를 고정해두고, nums1 중 가장 큰 k개를 골라 점수를 계산한다.
 * nums2[i]를 현재 최소값 후보로 고정해놓고, nums1[i]에서 가장 큰 k개를 선택하여 합을 구한 뒤, sum(nums1) * min(nums2) 점수를 계산해서 최댓값을 갱신하는 방식이다.
 */