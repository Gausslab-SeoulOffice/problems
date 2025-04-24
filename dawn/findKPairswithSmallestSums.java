/*
373. Find K Pairs with Smallest Sums

You are given two integer arrays nums1 and nums2 sorted in non-decreasing order and an integer k.

Define a pair (u, v) which consists of one element from the first array and one element from the second array.

Return the k pairs (u1, v1), (u2, v2), ..., (uk, vk) with the smallest sums.


Example 1:
Input: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
Output: [[1,2],[1,4],[1,6]]
Explanation: The first 3 pairs are returned from the sequence: [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]

Example 2:
Input: nums1 = [1,1,2], nums2 = [1,2,3], k = 2
Output: [[1,1],[1,1]]
Explanation: The first 2 pairs are returned from the sequence: [1,1],[1,1],[1,2],[2,1],[1,2],[2,2],[1,3],[1,3],[2,3]
 */

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> result = new ArrayList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < nums1.length; i++) {
            queue.offer(new int[] { nums1[i] + nums2[0], 0 });
        }

        while (k > 0 && !queue.isEmpty()) {
            int[] pair = queue.poll();
            int sum = pair[0];
            int pos = pair[1];

            result.add(List.of(sum - nums2[pos], nums2[pos]));

            if (pos + 1 < nums2.length) {
                queue.offer(new int[] { sum - nums2[pos] + nums2[pos + 1], pos + 1 });
            }
            k--;
        }
        return result;
    }
}

/***
 * 이 문제는 쌍을 구하는데 더했울때 최고가 되는 합의 쌍을 k개 만큼 구하는 문제이다.
 *
 * 일단 결과를 담을 result를 선언하고, 최소힙을 사용해서 문제를 풀 예정이다.
 * 일단 PriorityQueue를 선언해서 <합, nums2의 인덱스>를 넣어줄 예정이다.
 * 처음엔 queue에 각각 nums1의 원소와 nums2의 가장 작은 원소를 더해서 넣어준다.
 * nums1의 모든 값에 대해 nums2[0]과 짝을 지어 힙에 넣는다
 * (nums1[i] + nums2[0], 0) → 가장 작은 조합부터 시작
 * 그리고 한개씩 빼면서 비교를 하게 된다.
 * k개를 다 찾았거나 힙이 빌 때까지 반복이다.
 * 힙에서 가장 합이 작은 쌍을 꺼낸다
 * sum은 현재 합, pos는 nums2의 인덱스
 * sum - nums2[pos] → nums1[i] 값을 구한다.
 * 최종적으로 (nums1[i], nums2[pos]) 쌍을 리스트에 추가한다.
 * 다음 nums2[pos+1] 값으로 업데이트해서 새 쌍을 힙에 넣는다.
 * 여전히 같은 nums1[i]와 짝이지만, nums2만 한 칸 오른쪽으로 이동한다.
 */