/*
435. Non-overlapping Intervals

Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

Note that intervals which only touch at a point are non-overlapping. For example, [1, 2] and [2, 3] are non-overlapping.


Example 1:
Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

Example 2:
Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.

Example 3:
Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */

class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0;
        int prevEnd = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            if (interval[0] >= prevEnd) {
                prevEnd = interval[1];
            } else {
                count++;
            }
        }
        return count;
    }
}

/***
 * 이 문제는 겹치지 않도록 만드는 최소 삭제의 수를 반환하라는 문제이다.
 *
 * 일단 끝을 기준으로 오름차순 정렬을 한다.
 * 그리고 리스트 한개씩 확인을 할건데, 이 전 리스트의 끝점보다 현재 리스트의 시작점이 더 크면 겹치지 않기때문에 prevEnd를 현재 리스트의 끝점으로 옮겨준다.
 * 즉, 그냥 넘어간다는 것이다.
 * 그게 아니라면 겹쳐진다는 의미이므로 count를 증가시킨다.
 * 이후 겹치는 걸 다 count했을테니 반환하면 된다.
 */