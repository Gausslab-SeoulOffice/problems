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
 * 이 문제는 한 덩어리도 만들건데, 겹치는걸 몇개를 빼야 서로 독립적인게 만들어지는지 구하는 문제이다.
 *
 * 일단 2번째 인자로 오름차순 정렬을 한다.
 * 그 이후에 첫번째 배열의 두번째 원소와 두번째 배열의 첫번째 원소를 비교하면서 겹치면 카운팅을 해줘야한다.
 * count라는 변수와 첫번째 배열의 두번째 원소를 담아놓기 위해 prevEnd 변수를 선언한다.
 * 이후 interval[0]이 이전 prevEnd보다 크거나 같으면 서로 독립적이기 때문에 prevEnd를 interval[1]로 업데이트 해준다.
 * 그게 아니라면 겹치는 부분이기에 count를 증가시켜준다.
 * 이후 count를 반환하면 된다.
 */