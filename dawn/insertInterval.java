/*
57. Insert Interval

You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).
Return intervals after the insertion.
Note that you don't need to modify intervals in-place. You can make a new array and return it.



Example 1:
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]

Example 2:
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>(Arrays.asList(intervals));
        list.add(newInterval);

        Collections.sort(list, (a, b) -> Integer.compare(a[0], b[0]));
        int[] prev = list.get(0);

        List<int[]> merged = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            int[] interval = list.get(i);

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
 * 이 문제는 int[][]에다가 int[]한 개를 더 더해서 합칠 수 있는걸 한개로 합치겠다는 문제이다.
 *
 * 저번 문제랑 아주 유사하게 풀면 되는것이다. 다른점이 있다면 List<int[]>한 개를 먼저 선언해서 해로 들어오는 한개의 int[]를 추가해준다는 것이다.
 * 그리고 이제 int[][]가 아니고 list이기 때문에 Arrays를 사용하는게 아닌, Collections를 사용해서 compare해서 sort 시킨다.
 * 그리고 저번이랑 똑같이 흘러간다. 최종적 결과를 담을 merged를 선언한다.
 * prev는 일단 맨처음걸로 선언해준다.
 * 그리고 for문을 도는것이다. 비교할(interval의) 첫 번째 원소가 그 전 prev의 두 번째 원소보다 작거나 같은지 확인한다.
 * 맞다면 합칠 수 있는것이다. prev의 두 번째 원소는 큰걸 선택해서 넣어준다.
 * 그게 아니라면 합칠 수 없는 것이기에 merged에 넣어주고 prev는 interval로 업데이트 해준다.
 * for문을 다 돌았다면 마지막에 있는 prev도 merged에 넣어준다,
 * 그리고 merged를 int[][]로 변경해서 반환하면 된다.
 */