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
                result = Math.max(result, (sum * p[0]));
            }
        }
        return result;
    }
}

/***
 * 이 문제는 pair를 잡아서 k만큼 nums1선택해서 더한 값고 nums2에서 min값을 가지고 와서 곱한 값중에 가장 큰 수를 구하는 문제이다.
 *
 * 일단 pair를 만들어주어야한다.
 * 값을 만든 이후엔 정렬을 해야하는데 b[0]-a[0]으로 nums2의 값으로 오름차순이 되도록한다.
 * 그리고 정렬이 된 후엔 pq에 넣으면서 확인하면 된다.
 * 알아서 정렬이 될거고, pq에 들어간 값이랑 k랑 같으면 result에 계산해서 넣으면 된다.
 * pq에 들어간 값이 더 크면 가장작은걸 삭제하고 sum에서 빼주면 된다.
 * 이후 result를 반환한다.
 */