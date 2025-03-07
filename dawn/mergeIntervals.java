/*
56. Merge Intervals

Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:
Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:
Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                merged.add(prev);
                prev = interval;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}

/***
 * 이 문제는 합칠 수 있는건 합치라는 것이다.
 *
 * 일단 제일 먼저 힘들었던건 sort를 시키는 것이다.
 * 람다식으로 비교함수인 compare를 사용해서 a와 b를 비교해서 오름차순으로 sort를 해준다.
 * 그리고 결과를 나타낼 List<int[]> 한 개를 선언한다. 맨 처음걸 prev로 먼저 두고 시작한다.
 * 비교할걸 interval로 가지고 오고, 비교할 대상의 첫 번째 원소와 가지고 있던 prev의 두번째 원소를 비교한다.
 * 비교할 대상의 첫 번째 원소가 prev의 두 번째 원소보다 작거나 같으면 합칠 수 있는것이다.
 * prev의 두번째 원소를 더 큰걸로 선택하고 넘어간다.
 * [1,3],[2,5]가 있었다면 2<=3이고, 5가 더 크기 때문에 prev는 [1,5]가 되는것이다.
 * 만약 그게 아니라면 합칠 수있는게 없는것이기에, merged에다가 넣어주고 prev는 interval로 업데이트 해준다.
 * for문이 완성되면 마지막 prev까지 merged에 넣어주고, merged를 리턴하면된다.
 * 리턴 형은 int[][]이기 때문에, merged를 toArray로 변경하고 그 값은 int[merged.size()][]로 선언하면 완성이다.
 */